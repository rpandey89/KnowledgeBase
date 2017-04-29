package com.knowledgebase.spring.tutorial.beans;

import org.springframework.beans.factory.DisposableBean;

/**
 * Created by rahul.pandey on 4/22/17.
 */
public class Person implements DisposableBean{

    private int id;
    private String name;
    private int taxId;
    //we can set it using constructor or a setter method
    private Address address;

    //defining this in case we want to use default constructor
    //as the java compiler will look for parameterized constructor in case we define that
    //by default java compiler provides default constructor when we do not define any constructor
    /*public Person() {
    }*/

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void onCreate() {
        System.out.println("Person created");
    }

    //can't use private here as we are accessing from beans.xml
    public void setTaxId(int id) {
        this.taxId = id;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void destroy() {
        System.out.println("Person Destroyed");
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taxId=" + taxId +
                ", address=" + address +
                '}';
    }
}
