package com.itheima.service.impl;

import com.itheima.service.UserService;
import java.util.*;


public class UserServiceImpl4 implements UserService {

    //前两个是重点
    private List<String> list;
    private Properties p;
    //了解
    private int[] array;
    private Set<String> set;
    private Map<String,String> map;

    public void save() {
        System.out.println("UserServiceImpl4 save...");
        System.out.println("list->" + list);
        System.out.println(list instanceof ArrayList);//true
        System.out.println("properties->" + p);
        System.out.println("array->" + Arrays.toString(array));
        System.out.println("set->" + set);
        System.out.println("map->" + map);
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Properties getP() {
        return p;
    }

    public void setP(Properties p) {
        this.p = p;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }


}
