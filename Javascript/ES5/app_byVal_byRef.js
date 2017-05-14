//by value (primitives)
var a = 3;
var b;
b = a;

console.log("by value a ", a);
console.log("by value b ", b);

// by reference (all objects (including functions))
var c = {greeting: 'hi'};
var d;
d = c;

c.greeting = 'Hellloo'; //mutate

console.log("by ref c ", c);
console.log("by ref d ", d);

// by reference (even as parameters)
function changeGreeting(obj) {
    obj.greeting = "holaa";
}

changeGreeting(d);
console.log("by ref c param ", c);
console.log("by ref d param ", d);

// equals operator sets up new memory space (new address)
c = {greeting: "howdy"};
console.log("by ref after assigning new obj c ", c);
console.log("by ref after assigning new obj d ", d);