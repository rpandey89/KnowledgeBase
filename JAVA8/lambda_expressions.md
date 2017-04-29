# Lambdas

A concise representation of an anonymous function that can be passed around: it does not have a name, but it has a list 
of parameters, a body, a return type, and also possibly a list of exceptions that can be thrown.

- Anonymous : We say anonymous because it doesn’t have an explicit name like a method would normally have: less to write 
and think about!
- Function : We say function because a lambda isn’t associated with a particular class like a method is. But like a 
method, a lambda has a list of parameters, a body, a return type, and a possible list of exceptions that can be thrown.
- Passed around : A lambda expression can be passed as argument to a method or stored in a variable.
- Concise : You don’t need to write a lot of boilerplate like you do for anonymous classes.

Syntax:
```
(parameters) -> expression
or
(parameters) -> { statements; }
```

Before:
```
Comparator<Apple> byWeight = new Comparator<Apple>() {
    public int compare(Apple a1, Apple a2){
        return a1.getWeight().compareTo(a2.getWeight());
    }
};
```

After (with lambda expressions):
```
Comparator<Apple> byWeight =
    (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

(Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        |                               |
    parameters                         body
```

Examples:

```
Use case                               Examples of lambdas
A boolean expression                   (List<String> list) -> list.isEmpty()
Creating objects                       () -> new Apple(10)
Consuming from an object               (Apple a) -> {System.out.println(a.getWeight());}
Select/extract from an object          (String s) -> s.length()
Combine two values                     (int a, int b) -> a * b
Compare two objects                    (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight())
```

# Functional Interface
A functional interface is an interface that specifies exactly one abstract method. An interface is still a functional 
interface if it has many default methods as long as it specifies only one abstract method. Though if an interface with 
one abstract method and one from inherited interface is not a functional interface.
For e.g.

```
public interface Comparator<T> {
    int compare(T o1, T o2);
}

public interface Runnable {
    void run();
}

public interface Callable<V> {
    V call();
}

//this is not a functional interface
public interface MyComparator<T> extends Comparator {
    int compare2(T o1, T o2, T o3);
}
```

Lambda expressions let you provide the implementation of the abstract method of a functional interface directly inline 
and treat the whole expression as an instance of a functional interface. You can achieve the same thing with an 
anonymous inner class, although it’s clumsier: you provide an implementation and instantiate it directly inline.

Note: Lambda expression should match with the signature of the abstract method of functional interface.


# Functional Descriptor

The signature of the abstract method of the functional interface essentially describes the signature of the lambda 
expression. We call this abstract method a function descriptor.


<table>
<tr><td>Functional interface</td><td>Function descriptor</td><td>Primitive specializations</td></tr>
<tr><td>Predicate<T></td><td>T -> boolean</td><td>IntPredicate, LongPredicate, DoublePredicate</td></tr>
<tr><td>Consumer<T></td><td>T -> void</td><td>IntConsumer, LongConsumer, DoubleConsumer</td></tr>
<tr><td>Function<T, R></td><td>T -> R</td><td>IntFunction<R>, IntToDoubleFunction, IntToLongFunction, LongFunction<R>, LongToDoubleFunction, LongToIntFunction, DoubleFunction<R>, ToIntFunction<T>, ToDoubleFunction<T>, ToLongFunction<T></td></tr>
<tr><td>Supplier<T></td><td>() -> T</td><td>BooleanSupplier, IntSupplier, LongSupplier, DoubleSupplier</td></tr>
<tr><td>UnaryOperator<T></td><td>T -> T</td><td>IntUnaryOperator, LongUnaryOperator, DoubleUnaryOperator, UnaryOperator<T></td></tr>
<tr><td>BinaryOperator<T></td><td>(T, T) -> T</td><td>IntBinaryOperator, LongBinaryOperator, DoubleBinaryOperator</td></tr>
<tr><td>BiPredicate<L, R></td><td>(L, R) -> boolean</td><td></td></tr>
<tr><td>BiConsumer<T, U></td><td>(T, U) -> void</td><td>ObjIntConsumer<T>, ObjLongConsumer<T>,ObjDoubleConsumer<T></td></tr>
<tr><td>BiFunction<T, U, R></td><td>(T, U) -> R</td><td>ToIntBiFunction<T, U>, ToLongBiFunction<T, U>,ToDoubleBiFunction<T, U></td></tr>
</table>


@FunctionalInterface annotation provided in Java API

# Functional Interfaces

- Predicate
The java.util.function.Predicate<T> interface defines an abstract method named test that
accepts an object of generic type T and returns a boolean.
- Consumer
The java.util.function.Consumer<T> interface defines an abstract method named accept that
takes an object of generic type T and returns no result (void).
- Function
The java.util.function.Function<T, R> interface defines an abstract method named apply that
takes an object of generic type T as input and returns an object of generic type R.

# Primitive specializations

- Refresher

To refresh a little: every Java type is either a reference type (for example, Byte, Integer, Object,
List) or a primitive type (for example, int, double, byte, char). But generic parameters (for
example, the T in Consumer<T>) can be bound only to reference types. This is due to how
generics are internally implemented. As a result, in Java there’s a mechanism to convert a
primitive type into a corresponding reference type. This mechanism is called boxing. The
opposite approach (that is, converting a reference type into a corresponding primitive type) is
called unboxing. Java also has an autoboxing mechanism to facilitate the task for programmers:
boxing and unboxing operations are done automatically.

But this comes with a performance cost. Boxed values are essentially a wrapper around
primitive types and are stored on the heap. Therefore, boxed values use more memory and
require additional memory lookups to fetch the wrapped primitive value.

Java 8 brings a specialized version of the functional interfaces we described earlier in order to
avoid autoboxing operations when the inputs or outputs are primitives. For example, in the
following code, using an IntPredicate avoids a boxing operation of the value 1000, whereas
using a Predicate<Integer> would box the argument 1000 to an Integer object:

```
public interface IntPredicate{
    boolean test(int t);
}

IntPredicate evenNumbers = (int i) -> i % 2 == 0; //true
evenNumbers.test(1000);
Predicate<Integer> oddNumber = (Integer i) -> i % 2 == 1; //false
evenNumbers.test(1000);
```

# Exception Handling
None of the functional interfaces allow checked exception to be thrown. We have two options
1. Define a functional interface that throws checked exception
1. Wrap the code in lambda with try and catch

```
//1
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
BufferedReaderProcessor p = (BufferedReader br) -> br.readLine();

//2
Function<BufferedReader, String> f =
    (BufferedReader b) -> {
        try {
            return b.readLine();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
};
```

# Type Checking
The type-checking process is deconstructed as follows:
- First, you look up the declaration of the filter method.
- Second, it expects as the second formal parameter an object of type Predicate-<Apple> (the target
type).
- Third, Predicate<Apple> is a functional interface defining a single abstract method called test.
- Fourth, the method test describes a function descriptor that accepts an Apple and returns a
boolean.
- Finally, any actual argument to the filter method needs to match this requirement.

The code is valid because the lambda expression that we’re passing also takes an Apple as
parameter and returns a boolean. Note that if the lambda expression were throwing an
exception, then the declared throws clause of the abstract method would also have to match.

# Same Lambda different functional interfaces
Because of the idea of target typing, the same lambda expression can be associated with
different functional interfaces if they have a compatible abstract method signature. For example,
both interfaces Callable and PrivilegedAction described earlier represent functions that accept
nothing and return a generic type T. The following two assignments are therefore valid:

```Callable<Integer> c = () -> 42;
PrivilegedAction<Integer> p = () -> 42;
```

# Diamond operator
Those of you who are familiar with Java’s evolution will recall that Java 7 had already
introduced the idea of types being inferred from context with generic inference using the
diamond operator (<>) (this idea can be found even earlier with generic methods). A given class
instance expression can appear in two or more different contexts, and the appropriate type
argument will be inferred as exemplified here:

```List<String> listOfStrings = new ArrayList<>();
List<Integer> listOfIntegers = new ArrayList<>();
```

# Type Inference
The Java compiler deduces what functional
interface to associate with a lambda expression from its surrounding context (the target type),
meaning it can also deduce an appropriate signature for the lambda because the function
descriptor is available through the target type. The benefit is that the compiler has access to the
types of the parameters of a lambda expression, and they can be omitted in the lambda syntax.

```
List<Apple> greenApples = filter(inventory, a -> "green".equals(a.color()));
Comparator<Apple> c = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());
```

# Using Local Variables
Lambdas can access free variables i.e. variables from outer scope. These lambdas are called capturing lambdas.
Lambdas can access instance and static variables without any restrictions, but the local variables have to be explicitly
declared final or effectively final.

- Why this restriction?
First, there’s a key
difference in how instance and local variables are implemented behind the scenes. Instance
variables are stored on the heap, whereas local variables live on the stack. If a lambda could
access the local variable directly and the lambda were used in a thread, then the thread using the
lambda could try to access the variable after the thread that allocated the variable had
de-allocated it. Hence, Java implements access to a free local variable as access to a copy of it
rather than access to the original variable. This makes no difference if the local variable is
assigned to only once—hence the restriction.
Second, this restriction also discourages typical imperative programming patterns (which, as we
explain in later chapters, prevent easy parallelization) that mutate an outer variable.