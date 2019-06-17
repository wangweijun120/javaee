package com.homework.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "person")
public class Person {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String password;
    private String email;
    private String activationCode;
    private Integer activationState;
    private Date overdue;
    private String office;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public Integer getActivationState() {
        return activationState;
    }

    public void setActivationState(Integer activationState) {
        this.activationState = activationState;
    }

    public Date getOverdue() {
        return overdue;
    }

    public void setOverdue(Date overdue) {
        this.overdue = overdue;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFixedtelephone() {
        return fixedtelephone;
    }

    public void setFixedtelephone(String fixedtelephone) {
        this.fixedtelephone = fixedtelephone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    private String username;
    private String sex;
    private String position;
    private String department;
    private String fixedtelephone;
    private String cellphone;
    private String company;
    private String userImg;
}
