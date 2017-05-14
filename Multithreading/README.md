Concurrent Programming has two basic units of execution: processes and threads. Processing time for a single core is shared
among processes and threads -> this is the time slicing.

# Processes

A process has a self-contained execution environment and a private set of basic run-time resources. For e.g. each process
has itw own memory space.

Processes can communicate with each other via IPC (Inter Process Communication). IPC is used not just for communication 
between processes on the same system, but processes on different systems. In java we use ProcessBuilder to build processes.

# Threads
Threads are lightweight processes. Going to be cheaper to create threads. Both processes and threads provide an execution
environment, but creating a new thread requires fewer resources than creating a new process.

Threads must exist within a process. Every process has at least one thread. Threads share the process's resources: including
memory and open files.

Threads must be synchronized as they share the resources for opening a file etc.

Java application: System thread (memory management), main thread -> we can create new threads with the help of main thread.

# Multithreading Advantages

We can design more responsive software -> do several things at the same time
We can achieve better resource utilization
We can improve performance

E.g. - 
Thread 1) Downloading images from the web, 
Thread 2) IO Operations: copying files asn parse the content, 
Thread 3) doing heavy calculations -> simulations and numerical operations.

All the threads when done will signal the main thread of their completion of task.

# Disadvantages of Multithreading

Threads manipulate data located on the same memory area -> we have to take it into consideration
Difficult to design multithreaded software
Hard to detect errors
Expensive to communicate between threads
Switching between threads is also expensive -> CPU saves local data, pointers of the current thread + 
loads the data of the other thread. As there will not be as many CPUs as there will be threads

Rule of thumbs for small problems it is unnecessary to use multithreading. It may be slower than single threaded apps.
Multithreaded sorting slower for small number of items. Advantageous only when there are millions or billions of items.

There has to be an optimal number of threads for better performance

# Threads Lifecycle

1. New - when we instantiate a thread. It is in this state until we start it ~ start()
1. Runnable - after we have started the thread. The thread is executing its task in this state
1. Waiting - when a thread is waiting. For e.g. for another thread to finish its task. When other thread signals -> this thread 
goes back to the runnable state ~ wait() and sleep()
1. Dead - after the thread finishes its task

# Parallel vs Multithreaded Computing
Parallel Threads run on usually multiprocessors with multiple cores
Multithreaded environment assumes that it is running on a single processor having single core. They share the resources and 
processing time -> time slicing.

# Threads vs Runnable

There are two common differences:

1. When we extends Thread class, after that we can’t extend any other class which we required. (As we know, Java does not allow inheriting more than one class).
   
   When we implement Runnable, we can save a space for our class to extend any other class in future or now.

1. Another significant difference between implementing Runnable and extending Thread is that by extending Thread, each of your threads has a unique object associated with it, whereas implementing Runnable, many threads can share the same object instance.

# Volatile

The Java volatile keyword is used to mark a Java variable as "being stored in main memory". More precisely that means, 
that every read of a volatile variable will be read from the computer's main memory, and not from the CPU cache, and 
that every write to a volatile variable will be written to main memory, and not just to the CPU cache.

Every read of a volatile variable will be read from the RAM so from the main memory and not from the cache. Usually variables
are cached for performance reasons.

Caches are faster -> do not use volatile keyword if not necessary (it prevents instruction reordering which is a performance boost technique)