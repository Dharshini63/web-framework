package com.example.cw1.service;

import org.springframework.stereotype.Service;

@Service
public class DharshiniMyService {

    public void doSomething() {
        System.out.println("Around advice: Executing after doSomething()");
    }
}
