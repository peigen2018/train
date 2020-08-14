package com.peigen.test.effectivev3.e003_singleton;

public class User {

    private static final User INSTANCE =new User();

    private User(){ }

    public static User getInstance(){
        return INSTANCE;
    }
}
