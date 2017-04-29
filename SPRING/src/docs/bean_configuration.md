# Constructor Arguments
A bean's constructor can be configured via beans.xml by providing the values in the bean definition. The values can be
set up using value and indicating the argument by type, name, ref, index

# Bean Properties
A bean's property can also be set up by using property tag in xml file.

# Dependency Injection
If we have one object that is dependent on another object, then instead of using new keyword we can get that object using
the spring container. The Spring container uses DI to manage the components that make up an application.

# Bean Scope

When defining a <bean> you have the option of declaring a scope for that bean. For example, to force Spring to produce 
a new bean instance each time one is needed, you should declare the bean's scope attribute to be prototype. Similarly, 
if you want Spring to return the same bean instance each time one is needed, you should declare the bean's scope 
attribute to be singleton.

The Spring Framework supports the following five scopes, three of which are available only if you use a web-aware 
ApplicationContext.

1. singleton - This scopes the bean definition to a single instance per Spring IoC container (default).

1. prototype - This scopes a single bean definition to have any number of object instances.

1. request - This scopes a bean definition to an HTTP request. Only valid in the context of a web-aware Spring ApplicationContext.

1. session - This scopes a bean definition to an HTTP session. Only valid in the context of a web-aware Spring ApplicationContext.
	
1. global-session - This scopes a bean definition to a global HTTP session. Only valid in the context of a web-aware Spring ApplicationContext.

# Bean Lifecycle
The life cycle of a Spring bean is easy to understand. When a bean is instantiated, it may be required to perform some 
initialization to get it into a usable state. Similarly, when the bean is no longer required and is removed from the 
container, some cleanup may be required.

Though, there are lists of the activities that take place behind the scene between the time of bean Instantiation and 
its destruction, this chapter will discuss only two important bean life cycle callback methods, which are required at 
the time of bean initialization and its destruction.

To define setup and teardown for a bean, we simply declare the <bean> with initmethod and/or destroy-method parameters. 
The init-method attribute specifies a method that is to be called on the bean immediately upon instantiation. 
Similarly, destroy method specifies a method that is called just before a bean is removed from the container.

you need to register a shutdown hook ```registerShutdownHook()``` method that is declared on the 
```AbstractApplicationContext``` class. This will ensure a graceful shutdown and call the relevant destroy methods.
Though the destroy methods of singletons will execute it seems!

From StackOverflow
the shutdown hook is more reliable; if you close your application with Ctrl-C from a terminal, the shutdown hook will 
get executed but your close() call will most likely never get reached. The shutdown hooks are what application servers 
usually rely on to properly terminate (unless kill -9 cuts their head off). Ultimately, that shutdown hook for the 
spring app context does nothing more than call doClose(), but it its execution is guaranteed by the JVM

# Factory Beans and Methods
Beans can also be instantiated via factory-bean and factory-method

# P Namespace
The properties can also be set using p attribute

# Setting List Properties
There are <list/> and <set/> properties which allow duplicate and non-duplicate entries respectively. Primitive values
can be set using <value> tag and beans can be set using <ref> tag.

#Inner Beans
Beans can be defined as properties or constructor arguments inside another bean. There is no need to provide ids in that
case. In addition, we have to redefine it if that bean is used elsewhere in the configuration.

```
<bean id="jungle" class="com.knowledgebase.spring.tutorial.beans.Jungle">
        <property name="largest">
            <bean class="com.knowledgebase.spring.tutorial.beans.Animal">
                    <constructor-arg name="name" value="Mira"/>
                    <constructor-arg name="type" value="Elephant"/>
            </bean>
        </property>
        <property name="animals">
            <list>
                <bean id="bear" class="com.knowledgebase.spring.tutorial.beans.Animal">
                        <constructor-arg name="name" value="Baloo"/>
                        <constructor-arg name="type" value="Bear"/>
                    </bean>
                <bean id="lion" class="com.knowledgebase.spring.tutorial.beans.Animal">
                        <constructor-arg name="name" value="Shera"/>
                        <constructor-arg name="type" value="Lion"/>
                 </bean>
            </list>
        </property>
    </bean>
```