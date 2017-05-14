function greet(firstName, lastName, language) {
    if (arguments.length == 0) {
        console.log("Missing arguments");
        console.log('-------');
        return;
    }
    language = language || 'en';
    console.log(firstName);
    console.log(lastName);
    console.log(language);
    console.log('-------');
    //arguments is array like structure
    console.log(arguments); //["John", "Doe", "es", callee: function, Symbol(Symbol.iterator): function]
}

greet(); //undefined undefined undefined - remember hoisting!
greet('John', 'Doe', 'es');
greet('John', 'Doe');
greet('John');

function greet2(...args) {
    console.log("greet2 ", args[0]);
    console.log("greet2 ", args[1]);
}

greet2("hi", "hey hey");