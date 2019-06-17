package com.homework.service;

import com.homework.model.Person;
import com.homework.repository.PersonRepository;
import com.homework.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author wangweijun
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public Flux<String> doLogin(String email, String password) {
        List<Person> userList = personRepository.findByEmail(email);
        if (!ObjectUtils.isEmpty(userList) && password.equals(userList.get(0).getPassword())) {
            return Flux.just(JsonResult.success());
        }
        return Flux.just(JsonResult.fail("邮箱或密码错误"));
    }

    @Override
    public Flux<String> doRegister(Person user) {
        List<Person> userList = personRepository.findByEmail(user.getEmail());
        if (!ObjectUtils.isEmpty(userList)) {
            return Flux.just(JsonResult.fail("该邮箱已注册"));
        }
        personRepository.saveAndFlush(user);
        return Flux.just(JsonResult.success());
    }

    @Override
    public Mono<Long> count() {
        return Mono.just(personRepository.count());
    }


}
