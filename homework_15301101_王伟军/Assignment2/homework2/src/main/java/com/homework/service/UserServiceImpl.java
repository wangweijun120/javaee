package com.homework.service;

import com.google.common.util.concurrent.RateLimiter;
import com.homework.model.Person;
import com.homework.repository.PersonRepository;
import com.homework.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PersonRepository personRepository;

    private RateLimiter doLoginLimiter = RateLimiter.create(2);

    private RateLimiter doRegisterLimiter = RateLimiter.create(2);

    @Override
    public String doLogin(String email, String password, HttpServletRequest request) {
        if (!doLoginLimiter.tryAcquire()) {
            return JsonResult.fail("登录请求被限流");
        }
        List<Person> userList = personRepository.findByEmail(email);
        if (!ObjectUtils.isEmpty(userList) && password.equals(userList.get(0).getPassword())) {
            request.getSession().setAttribute("user", userList.get(0));
            return JsonResult.success();
        }
        request.getSession().removeAttribute("user");
        return JsonResult.fail();
    }

    @Override
    public String doRegister(Person user) {
        if (!doRegisterLimiter.tryAcquire()) {
            return JsonResult.fail("注册请求被限流");
        }
        List<Person> userList = personRepository.findByEmail(user.getEmail());
        if (!ObjectUtils.isEmpty(userList)) {
            return JsonResult.fail();
        }
        personRepository.saveAndFlush(user);
        return JsonResult.success();
    }

    @Override
    public long count() {
        return personRepository.count();
    }


}
