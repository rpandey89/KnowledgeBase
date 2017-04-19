## Why java is evolving

- Hard to program multithreaded software. It is buggy. Multicore CPUs have separate caches (fast memory) attached to 
each processor core. Locking requires these to be synchronized, requiring relatively slow cache-coherency-protocol 
inter-core communication.
- Presence of multicore CPUs. Java earlier used mostly one of them.
- Need for more functional programming paradigm

The first programming concept is stream processing. For introductory purposes, a stream is a
sequence of data items that are conceptually produced one at a time—a program might read
items from an input stream one by one and similarly write items to an output stream.

```cat file1 file2 | tr "[A-Z]" "[a-z]" | sort | tail -3```

In Unix the commands (cat, tr, sort, and tail)
are executed concurrently, so that sort can be processing the first few lines before cat or tr has
finished.

## Streams API

Present in java.util.stream. Stream<T> is a sequence of items of type T. The API provides many methods which can be 
chained together much like Unix commands. Advantages:

- Provides higher level of abstraction by chaining streams
- Java 8 can run pipeline of streams on several CPU cores on disjoint parts of the input—this is ```parallelism``` almost 
for free
- Prevents obscurity involved with processing collections and difficulty leveraging multicore CPUs
- Collections and Streams both provide access to sequence of items
- However, Collections is about storing and accessing the items whereas Streams describe the computations to be done on
those items
- Streams can be used to perform sequential as well as parallel operations

```
import static java.util.stream.Collectors.toList;
Map<Currency,List<Transaction>> transactionByCurrencies = transactions.stream()
                                                                      .filter((Transaction t) -> t.getPrice() > 100)
                                                                      .collect(groupingBy(Transaction::getCurrency))

//Sequential Processing
List<Apple> heavyApples = inventory.stream()
                                   .filter((Apple a) -> a.getWeight() > 150)
                                   .collect(toList());

Parallel processing:
List<Apple> heavyApples = inventory.parallelStream()
                                   .filter((Apple a) -> a.getWeight() > 150)
                                   .collect(toList());

```

## Passing code to methods with behavior parameterization

In early versions of Java we passed a comparator object to compare objects, but that was verbose and did not really used
the idea of re-use

## Parallelism and shared mutable data

This means we should always pass the behavior or piece of code that does not work on shared mutable data. Such piece of
code are called side-effect free or stateless functions. Parallelism is achieved by handling partitioning of 
data/streams into smaller streams by libraries and method passed to library methods don't interact.

```
Two of these points (no shared mutable data and the ability to pass methods and functions—code—to other methods) are
the cornerstones of what’s generally described as the paradigm of functional programming. In contrast, in the imperative
programming paradigm you typically describe a program in terms of a sequence of statements that mutate state. 
The no-shared-mutable-data requirement means that a method is perfectly described solely by the way it transforms 
arguments to results; in other words, it behaves as a mathematical function and has no (visible) side effects.

The primary meaning of functional in functional programming means “using functions as first class values,” it often has
a secondary nuance of “no interaction during execution between components.”

```

## Java 8 adds methods and functions as values

### Methods and lambdas as first-class citizens

- Old style Java to list all the hidden files:

```
File[] files = new File(".").listFiles(new FileFilter(){
    public boolean accept(File file){
        return file.isHidden();
    }
})
```

- Java 8 style where we pass method reference. Here method reference syntax :: is used for passing method as a value.
```
File[] hiddenFiles = new File(".").listFiles(File::isHidden);
```

- Lambdas - anonymous functions
```
(int x) -> x + 1 means “the function that, when called with argument x, returns the value
x + 1.”
```

- Passing code 

1. Old style programming

```
public static List<Apple> filterApplesByWeight(List<Apple> apples) {
    List<Apple> inventory = new ArrayList<>();
    for(Apple a : apples) {
        if(a.getWeight() > 50) {
            inventory.add(a);
        }
    }
    return inventory;
}

public static List<Apple> filterApplesByColor(List<Apple> apples) {
    List<Apple> inventory = new ArrayList<>();
    for(Apple a : apples) {
        if("green".equals(a.getColor())) {
            inventory.add(a);
        }
    }
    return inventory;
}

```

2. Java 8 version of passing the predicates. What is a Predicate?

It is a function-like piece of code that takes a value and returns value true/false.

```
public static List<Apple> filterApples(List<Apple> apples, Predicate<T> p) {
    List<Apple> inventory = new ArrayList<>();
    for(Apple a : apples) {
        if(p.test(a)) {
            inventory.add(a);
        }
    }
    return inventory;
}

public static boolean isGreen(Apple a) {
    return "green".equals(a.getColor());
}

public static boolean isAboveFifty(Apple a) {
    return a.getWeight() > 50;
}


public static void main(String[] args) {
    List<Apple> list = Apple.getApplist();
    List<Apple> greenApples = Apple.filterApples(list, Apple::isGreen);
    List<Apple> heavyApples = Apple.filterApples(list, Apple::isAboveFifty);
}

//this is the signature of Predicate provided in the java.util.function package
public interface Predicate<T> {
    boolean test(T t);
}
```

The previous code passed a method Apple::isGreenApple (which takes an Apple for argument
and returns a boolean) to filterApples, which expected a Predicate-<Apple> parameter. The
word predicate is often used in mathematics to mean something function-like that takes a value
for an argument and returns true or false. As you’ll see later, Java 8 would also allow you to
write Function<Apple,Boolean>—more familiar to readers who learned about functions but not
predicates at school—but using Predicate<Apple> is more standard (and slightly more efficient
because it avoids boxing a boolean into a Boolean).

- Passing lambdas

In the above example, if the code is not big then we can pass lambdas as following.

```
filterApples(list, (Apple a) -> "green".equals(a.getColor()));
filterApples(list, (Apple a) -> a.getWeight() > 50);
```

# Default Methods
Interfaces have now default methods. The developers don't have to add the methods in their concrete classes once
changes are made to the interface due to introduction of Streams and parallelism in Java. For e.g. List interface now
has sort method. However, ArrayList class does not have to implement that method.

This feature provides multiple inheritance upto a certain extent.

#Other good ideas

- Optional<T> - In Java 8 there’s an Optional<T> class that, if used consistently, can help you avoid NullPointer
                exceptions. It’s a container object that may or not contain a value. Optional<T> includes
                methods to explicitly deal with the case where a value is absent, and as a result you can avoid
                NullPointer exceptions. In other words, it uses the type system to allow you to indicate when a
                variable is anticipated to potentially have a missing value.
