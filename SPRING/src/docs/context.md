Spring provides two distinct types of containers. Containers that hold the configuration of the beans. They create, 
initialize and load the bean objects specified in the configuration file. We can fetch the beans from the context by 
specifying the bean id. The container gets its instructions on what objects to instantiate, configure, and assemble by 
reading the configuration metadata provided. The configuration metadata can be represented either by XML, Java annotations, or Java code. 

# BeanFactory
This is the simplest container providing the basic support for DI and is defined by 
the org.springframework.beans.factory.BeanFactory interface. The BeanFactory and related interfaces, such as 
BeanFactoryAware, InitializingBean, DisposableBean, are still present in Spring for the purpose of backward 
compatibility with a large number of third-party frameworks that integrate with Spring. The most commonly used 
BeanFactory implementation is the XmlBeanFactory class.

# ApplicationContext
This container adds more enterprise-specific functionality such as the ability to resolve textual messages from a 
properties file and the ability to publish application events to interested event listeners. 
This container is defined by the org.springframework.context.ApplicationContext interface.

The ApplicationContext container includes all functionality of the BeanFactory container, so it is generally 
recommended over BeanFactory. BeanFactory can still be used for lightweight applications like mobile devices or 
applet-based applications where data volume and speed is significant.

- FileSystemXmlApplicationContext − This container loads the definitions of the beans from an XML file. Here you need to 
provide the full path of the XML bean configuration file to the constructor.

- ClassPathXmlApplicationContext − This container loads the definitions of the beans from an XML file. 
Here you do not need to provide the full path of the XML file but you need to set CLASSPATH properly 
because this container will look like bean configuration XML file in CLASSPATH.

- WebXmlApplicationContext − This container loads the XML file with definitions of all beans 
from within a web application.