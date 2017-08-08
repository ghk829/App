package com.example.ki.myapplication;

import java.util.HashMap;
import java.util.Set;

public class Individual {
    private String name;
    private int age;
    /*\C3߰\A1\C7ϰ\ED \BD\CD\C0\BA \B1\D7 \BB\E7\B6\F7\BF\A1 \B4\EB\C7\D1 \C1\A4\BA\B8 \C3߰\A1\B1\E2\B4\C9*/
    private HashMap<String, String> Informations;


    public Individual(String name) {
        super();
        this.name = name;
        Informations = new HashMap<String,String>();
    }

    public Individual(String name, int age) {
        super();
        this.name = name;
        this.age = age;
        Informations = new HashMap<String,String>();
    }

    public String getname() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void getInformations() {
        Set<String> keys = Informations.keySet();
        for(String  key : keys) {
            System.out.println(key+" : "+Informations.get(key));
        }

    }

    public void addInformations(String info, String Detail) {
        Informations.put(info, Detail);
    }
    public void addInformations(String info, int Detail) {
        String detail = Integer.toString(Detail);
        Informations.put(info, detail);
    }

}