package com.itheima01.pojo;

import com.itheima01.annotation.Entity;

/**
 * @author codermao
 * @date 2023/2/20 10:14
 */
public class Student {
    @Entity("zhangsan")
    private String name;
    @Entity("18")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
