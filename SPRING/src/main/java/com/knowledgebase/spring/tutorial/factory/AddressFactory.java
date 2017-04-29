package com.knowledgebase.spring.tutorial.factory;

import com.knowledgebase.spring.tutorial.beans.Address;

/**
 * Created by rahul.pandey on 4/25/17.
 */
public class AddressFactory {

    //this needs to be non-static
    public Address createAddress(String street, String city, String postalCode) {
        System.out.println("Creating address via factory bean");
        return new Address(street, city, postalCode);
    }

}
