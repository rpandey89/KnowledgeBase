# Spring Core

Spring Core is the cornerstone on top which everything else is built off. The following image shows how the core relates
to other components in Spring framework.

<img src="https://cloud.githubusercontent.com/assets/18672435/25557176/ef1c9326-2cc0-11e7-8402-497d21f55ab4.png"></img>

# Spring Beans

In contrast to EJB, the Spring Framework is designed from the core to use POJO's (Plain Old Java Objects), or 'Spring 
Beans'. Spring Beans are meant to be simple Java objects.

In practice, Spring Beans are one of the true beauties of the Spring Framework. Spring Beans are meant to be simple. 
Thus, you as a developer are discouraged from creating overly complex objects.

# Dependency Injection

Dependency Injection is a software design pattern where dependent objects are injected into your class.

### Without DI

- Objects take responsibility for managing their own dependencies
- Generally leads to more tightly coupled code
- Can require coding changes to manage changes with dependencies
- Can make classes more difficult to unit test

### With DI
- Generally leads to loosely coupled code
- The class is not responsible for determining its dependencies
- This allows the class to be composed at runtime

A good example of Dependency Injection in action would be when you have a web controller handling a form post. 
Following the Single Responsibility Principle, you don't want your controller class interacting with the database. 
Instead, you would have some type of service class for that. Thus your controller code would deal with the form post, 
and then call a method on the injected class. The controller doesn't need to care, nor worry about the database 
connection, connection pooling or what tables need to be updated. Likewise, the service does not need to know anything 
about the web request. The service doesn't need to care that the data came from a form post or a JSON string.

### Types of DI
Constructor Based
Setter Based - more flexible

### Interface Based DI
Best practice to code dependencies to an interface. Different implementations can be injected to support different
behaviors, and Mocks can be used to facilitate unit testing.

# Inversion of Control
A core concept of the Spring Framework is Inversion of Control, or also known as IoC. For application developers, 
this is the true strength of the Spring Framework. Through the concept of Inversion of Control, the Spring Framework 
manages the software components and injection of components into dependent objects. The framework determines the dependencies
to inject into your classes at run time.

Its very easy to get Dependency Injection and Inversion of Control confused. Remember, Dependency Injection is exactly 
as it sounds. Dependencies are being injected into your class. Inversion of Control is the actual injection of the 
dependencies. This is a subtle, yet important difference.

# Spring Context

The Spring Context is what brings everything together. It looks at the class files of your source code, 
ie the Spring Beans, then looks at the configuration of the context and wires up the environment. Spring will ensure 
your classes are injected with the specified dependencies.

# SpEL - Spring Expression Language

This is a concise language used to give you a great deal of flexibility when configuring the Spring Framework.
