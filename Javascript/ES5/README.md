# Syntax Parsers

A program that reads your code and determines what it does and if its grammar is valid, and translates our code into computer
instructions.

# Lexical Environment

Where something sits physically in the code we write. For e.g. variables are declared and used inside a function

# Execution Contexts

A wrapper to help manage the code that is running. There are lots of lexical environments. Which one is currently 
running is managed via execution contexts. It can contain things beyond what you've written in your code. 

# Name/Value Pairs and Objects

- Name

A name which maps to a unique value. The name may be defined more than once, but it can have only one value in any 
given context. That value may be more name/value pairs (collections)

- Object

A collection of name/value pairs in JS. For e.g.

```
Address: {
    Street: 'Main',
    Number: 100,
    Apartment: {
        Floor: 3,
        Number: 301
    }
}
```

# Global Environment and Global Variable 

Javascript engine wraps the currently executing code in an execution context.

Base Execution context is the global context. The engine provides a global object and a variable 'this', whenever our 
code is run. Because the code is wrapped in the global context by the engine.

Each tab will have its own execution context. Global Object -> window, if we are running the code in browser. 
At global level global object = this.

- Global : Not inside a function

```
                Execution Context
              /    |       |     \
       global_obj this outer_env  our_code
```

# Execution Context: Creation and Hoisting

- Creation phase : Global object and 'this' are setup in memory, outer env is setup. At this point the parser runs through 
the code to translate it and recognizes where we have declared variables and functions. It then sets up memory space for 
vars and functions. Hence, the functions and vars exist in memory. The function is stored in the memory, but for vars 
it is different. All vars are set to undefined. As the value is determined in the execution phase. This vars and func 
setting up is called hoisting.

- Execution phase : In this phase the engine assigns the value to the vars setup in memory. The engine then runs the code.

Note: Single Threaded - One command at a time.

Note: Synchronous - One at a time and in order.

# Function Invocation and Execution Stack

```
function b() { 
    var d;
}

function a() {
    b();
    var c;
}
a();
var d;
```
Stack is:

```Global Execution context -> a() Execution context -> b() Execution context```

Every function has its own create and execute phase. Once function finishes, it is popped from the stack. The lexical order
does not matter, but the execution order does. After the function at the top is finished and popped. The next function on
the stack resumes its execution.

# Functions, Context, and Variable Environment

Variable Environment : Where the variables live and how do they relate to each other.

```
function b() {
    var myVar;
}

function a() {
    var myVar = 2;
    b();
}

var myVar = 1;
a();
```

Global Execution Context - myVar = 1 -> a() Execution context - myVar = 2 -> b() Execution context - myVar = undefined

In other words, the context defines the scope of a variable.

# Scope Chain

Links to ref to outer env.

```
function b() {
    console.log(myVar);
}

function a() {
    var myVar = 2;
    b();
}

var myVar = 1;
a();
```

Global Execution Context - myVar = 1 -> a() Execution context - myVar = 2 -> b() Execution context - empty

Every execution context has a reference to its outer env. Over here function b has ref to its outer lexical env. In this
case it is global execution context.

# Scope, ES6 and let

Scope: where a var is available in the code. And if it's truly the same var or a new copy.
let: JS engine can use block scoping. let allows you to declare variables that are limited in scope to the block, 
statement, or expression on which it is used. This is unlike the var keyword, which defines a variable globally, or 
locally to an entire function regardless of block scope.

At the top level of programs and functions, let, unlike var, does not create a property on the global object.

[Let keyword explained](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/let)

# Asynchronous Callbacks

Rendering Engine <-> JS Engine <-> Http request

JS Engine has an event queue and it check if there is a handler inside the queue. If an event is present then the engine
will periodically check for the event to occue and execute that function. The queue is not processed until after the 
execution stack is empty. The browser is putting things on the queue asynchronously, while the code is executed line by
line.

# Types in JS

- Dynamic Typing: We don't tell the engine what type of data a variable holds, it figures it out while our code is running.
Variables can hold different types of values as it is determined during execution

```
var isNew = true;
isNew = 'yup!';
isNew = 1;
```

- Static Typing: We tell the compiler what kind of data a variable will hold

```
boolean isNew = 'true'; //error
```

- Primitive Types: type of data that represents a single variable. Something that is not an object.

#### Undefined

Represents lack of existence. We should not set a variable to undefined.

#### Null

Null represents lack of existence. We can set a variable to null.

####Boolean

#### Number

Floating point number (there's always some decimals). Only one number type.

#### String

A sequence of characters. It can be represented by "" and ''

#### Symbol

Used in ES6.

- Operators

A function that takes two params and returns a result. Infix Notation.

- Operator Precedence and Associativity

Associativity: What order operator functions get called in, is it left-to-right or right-to-left. This is when functions
have the same precedence.

- Coercion

Converting a value from one type to another. This happens quite often in JS because it is dynamically typed.

- Default values

```
/lib1.js
var libName = "Lib1"
/lib2.js
var libName = "Lib2"
```

The above two files when loaded in a certain order will attach the variable libName to the global context. The last file
to load will have the value set to the var. Here it will be "Lib2".

To avoid this we can do something like below:

```
/lib1.js
window.libName = window.libName || "Lib1"
/lib2.js
window.libName = window.libName || "Lib2"
```

- Objects and Functions

```
                        Object
           /              |             \
  Primitive "Prop"   Object "Prop"   Function "Method"
```

- Faking Namespaces

Namespace: A container for variables and functions. Typically to keep variables and functions with the same name separate.

- Object vs JSON

# Functions are Objects

First Class Functions: Everything you can do with other types you can do with functions. Assign them to variables, pass
them around, create them on the fly.

Function resides in memory. We can attach property and methods as it is an object. Special hidden properties:
1. Name - optional, can be anonymous
2. Code - actual lines of code written. And that property can be invoked

They have access to call(), apply() and bind() methods. These methods have to do with this object with which the function is
attached.

It also has another property called prototype. This is used only by the new operator. This is not the prototype of function.
It is the prototype of any object that is created when we use function as a constructor.

- Expression

A unit of code that results in a value. It does not have to save a variable.

- Statement

It does not do anything in execution phase

- By Value vs By Reference

By Value:

a --0x001--> Primitive Value
b = a or pass "a" to a function
b --0x002--> Copy of Primitive Value

By Reference:

a --0x001--> Object
b = a or pass "a" to a function
b --0x001--> Object

- Function Execution Context

Creation Phase: what happens when we run that code property?
Three things are present 
variable environment, ref to outer environment, 'this' (will be pointing at diff object or diff thing depending on how 
function is invoked, and this is determined by the engine) and 'arguments' list of all the parameters that we pass to the 
function

- Arrays

Collections of anything primitives or objects

- arguments and Spread

JS gives a keyword 'arguments' that contains the list of params passed to the function.
Spread operator can be used to get all the params passed in the arguments to the function
function greet(...args) {
}

- Immediately Invoked Function Expressions
```
var greeting = function(name) {
    console.log(name);
}();
```

- Closures

Functions defined inside another function, and that have access and can modify variables defined in the outside function 
even after the outside function has finished execution. 

The reason is that the variables are still there in the memory. So, when the inner function is called. The execution context
of the inner function will still have link to the outer lexical environment (scope chain). Execution context closes in
the access to outer variables.

Closures can be passed as an argument to other functions.

- Callback Function

A function you give to another function, to be run when the other function is finished. So the function we call, calls back
by calling the function we give as a param.

- Function Currying

Creating a copy of a function but with some preset parameters. Very useful in mathematical functions.

# Inheritance in JS

One object gets access to the properties and methods of another object.

- Classical Inheritance

Verbose

- Prototypal Inheritance
Simple, flexible, extensible and easy to understand.

- Prototype

All objects have some custom defined properties and one hidden property amongst other called proto object, which is the prototype object.
That prototype object can have its own properties and the prototype object. This is called prototype chain. This defines
the position of property in the chain of linked objects. So, it might appear that the first object contains that property,
but it is down the prototype chain.

Objects can share same proto object.

The base object in the prototype chain is Object.
All functions have the prototype object as an empty function object
```function() {}```
This object has methods on it like call, apply, bind etc.
All arrays have a default prototype
```[]```
This object has methods like push and prop like length etc.

- Reflection

An object can look at itself listing and changing its properties and methods.

- Object Creation

Objects can be created via Function constructors and new operator in JS.

- Function Constructor

A normal function that is used to construct objects. The 'this' variable points to a new empty object, and that 
object is returned from the function automatically.

- Polyfill

Code that adds a feature which the engine may lack. For e.g. Object.create is not supported by old browsers or JS engines.
So we will write the code that will imitate the feature.

- Syntactic Sugar

A different way to type something that does not change how it works under the hood.

- Strict mode

[Strict Mode MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Strict_mode)

- Transpile

Convert the syntax of one programming language, to another.
In this case languages that don't really ever run anywhere, but instead are processed by 'transpilers' that generate JS.

# Useful Links

[Mozilla Developer Network](https://developer.mozilla.org/en-US/docs/Web/JavaScript)

[Typescript](http://www.typescriptlang.org)

[Traceur](https://github.com/google/traceur-compiler)

[ES6](https://github.com/lukehoban/es6features)