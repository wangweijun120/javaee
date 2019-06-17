package com.homework.service;

import cn.hutool.json.JSONUtil;
import com.homework.model.Mail;
import com.homework.model.Person;
import com.homework.repository.PersonRepository;
import com.homework.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public String doLogin(String email, String password, HttpServletRequest request) {
        List<Person> userList = personRepository.findByEmail(email);
        if (!ObjectUtils.isEmpty(userList) && password.equals(userList.get(0).getPassword())) {
            request.getSession().setAttribute("user",userList.get(0));
            return JsonResult.success();
        }
        request.getSession().removeAttribute("user");
        return JsonResult.fail();
    }

    @Override
    public String doRegister(Person user) {
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

    @Override
    public String sendMail(HttpServletRequest request, String className) {
        Mail mail =new Mail();
        Person person =(Person) request.getSession().getAttribute("user");
        mail.setContent("您好，您订购的私教课程 <bold>"+className+"</bold> 后台已经受理，请您确认");
        mail.setEmail(person.getEmail());
        mail.setTitle("私教课程确认通知");
        kafkaTemplate.send("testTopic", JSONUtil.toJsonStr(mail));
        return JsonResult.success();
    }



}
