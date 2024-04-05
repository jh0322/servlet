package com.example.mvc1.model;
//회원(Object) -> MemberVO

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberVO {
    private int num;
    private String id;
    private String password;
    private String name;
    private int age;
    private String email;
    private String phone;

    public MemberVO(){}

    public MemberVO(String id, String password, String name, int age, String email, String phone) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public MemberVO(int num, String id, String password, String name, int age, String email, String phone) {
        this.num = num;
        this.id = id;
        this.password = password;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "MemberVO{" +
                "num=" + num +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
