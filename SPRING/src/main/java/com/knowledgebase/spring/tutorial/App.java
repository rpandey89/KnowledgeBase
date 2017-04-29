package com.knowledgebase.spring.tutorial;

//import org.springframework.context.ApplicationContext;

import com.knowledgebase.spring.tutorial.beans.FruitBasket;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.beans.factory.xml.XmlBeanFactory;
//import org.springframework.core.io.ClassPathResource;
import com.knowledgebase.spring.tutorial.beans.Person;
import com.knowledgebase.spring.tutorial.beans.Address;
import com.knowledgebase.spring.tutorial.beans.Jungle;

/**
 * Created by rahul.pandey on 4/22/17.
 */
public class App {
    public static void main(String[] args) {
        //ApplicationContext context = new FileSystemXmlApplicationContext("./SPRING/beans.xml");
        //ApplicationContext context = new FileSystemXmlApplicationContext("/SPRING/src/main/java/com/knowledgebase/spring/tutorial/configuration/beans.xml");
        //ApplicationContext context = new ClassPathXmlApplicationContext("com/knowledgebase/spring/tutorial/configuration/beans.xml");
        //XmlBeanFactory factory = new XmlBeanFactory (new ClassPathResource("com/knowledgebase/spring/tutorial/configuration/beans.xml"));

        //to register a shutdown hook
        AbstractApplicationContext context = new FileSystemXmlApplicationContext("/SPRING/src/main/java/com/knowledgebase/spring/tutorial/configuration/beans.xml");

        //type cast is required
        Person person = (Person) context.getBean("person");
        Person person1 = (Person) context.getBean("person1");
        Person person2 = (Person) context.getBean("person2");

        //the taxId over here will be 879 if there is no scope defined
        //singleton is the default scope
        //person1.setTaxId(879);
        System.out.println(person);
        System.out.println(person1);
        System.out.println(person2);

        Address ad = (Address) context.getBean("address3");
        System.out.println(ad);

        FruitBasket basket = (FruitBasket) context.getBean("fruitBasket");
        System.out.println(basket);
        //ApplicationContext does not have close method
        //((FileSystemXmlApplicationContext) context).close();
        //((ClassPathXmlApplicationContext) context).close();
        Jungle jungle = (Jungle) context.getBean("jungle");

        System.out.println(jungle);
        context.registerShutdownHook();
        context.close();
    }
}
