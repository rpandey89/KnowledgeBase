package com.knowledgebase.spring.tutorial.beans;

/**
 * Created by rahul.pandey on 4/25/17.
 */
public class Address {

    private String street;
    private String city;
    private String postalCode;

    //in order to use p namsepace
    public Address() {
    }

    public Address(String street, String city, String postCode) {
        this.city = city;
        this.street = street;
        this.postalCode = postCode;
    }

    public static Address localCreateAddress(String street, String city, String postCode) {
        System.out.println("Creating address from local method");
        return new Address(street, city, postCode);
    }

    public void init() {
        System.out.println("App init");
    }

    public void clean() {
        System.out.println("App clean up");
    }

    //for p namespace
    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postalCode + '\'' +
                '}';
    }
}
