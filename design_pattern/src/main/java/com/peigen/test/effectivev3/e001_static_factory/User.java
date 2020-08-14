package com.peigen.test.effectivev3.e001_static_factory;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class User {
    private int sex;

    public int getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    private String name;

    public User(int sex, String name) {
        this.sex = sex;
        this.name = name;
    }

    public User(SexType sex) {
        this.sex = sex.key;
    }

    /**
     * 类型转换方法
     *
     * @param type
     * @return
     */
    public static User from(SexType type) {
        return new User(type);
    }


    /**
     * 聚合方法
     *
     * @param users
     * @return
     */
    public static Set<User> of(User... users) {
        return Arrays.stream(users).collect(Collectors.toSet());
    }

    public static User valueOf() {
        return null;
    }

    public static User getInstance() {
        return null;
    }

    public static User create() {
        return null;
    }

    public static User getNewMan(){
        return new User(SexType.M);
    }

    public enum SexType {
        M(1, "man"), W(1, "woman");

        public int getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        private int key;
        private String value;

        SexType(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
