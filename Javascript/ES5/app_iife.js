//IIFE
var greeting = function(name) {
    console.log("without return ", name);
}('John');

console.log("without return ", greeting);

var greetingFunc = function(name) {
    return name;
}('John');

console.log("with return", greetingFunc);

//an IIFE wrapped in parenthesis
(function(name) {
    //greeting is scoped to the execution context of this anonymous function
    var greeting = 'Hello';
    console.log(greeting + ' ' + name);
    console.log("inside this", this);
}('John'));

console.log(greeting);

function glob() {

    var greeting = "ajdsa";
}

glob();
console.log("after glob ", greeting); //still prints undefined