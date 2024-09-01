package com.example.demo.passwordEncoder;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BCryptPasswordEncoderTest {
    @Test
    public void test(){
        PasswordEncoder passwordEncoder1=new BCryptPasswordEncoder();
        System.out.println(passwordEncoder1.matches("123456",passwordEncoder1.encode("123456")));
    }
}
