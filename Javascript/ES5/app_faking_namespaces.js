var greet = "Hello!";
var greet = "Hola!";

console.log(greet); //Hola!

//faking namespace by creating objects
var english = {
    greet: "Hello!"
};

var spanish = {
    greet: "Hola!"
}

console.log(english.greet); //Hello

//english.greetings.greet = "Hello"; //error undefined.greet cannot set the prop to undefined
english.greetings = {};
english.greetings.greet = "Hello"; //Hello