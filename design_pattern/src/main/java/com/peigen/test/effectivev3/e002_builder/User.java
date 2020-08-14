package com.peigen.test.effectivev3.e002_builder;


public class User {
    private int sex;
    private String name;
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static class Builder {
        private int sex;
        private String name;
        private int age;

        public Builder man() {
            this.sex = com.peigen.test.effectivev3.e001_static_factory.User.SexType.M.getKey();
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public User(Builder b) {
        this.age = b.age;
        this.name = b.name;
        this.sex = b.sex;
    }

}
