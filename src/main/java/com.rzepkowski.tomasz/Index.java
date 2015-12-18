package com.rzepkowski.tomasz;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "helloWorld", eager = true)
public class Index {
    public Index() {
        System.out.println("HelloWorld started!");
    }
    public String getMessage() {
        return "Hello World!";
    }
}