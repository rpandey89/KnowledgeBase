//function statement is hoisted, functions expressions are not hoisted
greet();
//function object is put on the global context
//name and code are set in the execution phase
//this is a function statement as it does not do anything in execution phase
function greet() {
    console.log('hi');
}

greet.language = 'english';

greet();
console.log(greet); //prints the code of the function
console.log(greet.language); // prints english

//anonymousGreet(); //similar concept to an object, gives error function not defined

//this is a function expression as it results in a value
//in creation phase undefined is assigned to the var in the memory
var anonymousGreet = function() {
    console.log('hi');
}

anonymousGreet();

/*
this is a statement as it does not results in a value
the expression is though inside the brackets
 if() {

 }
 */


function log(a) {
    console.log("log func ", a);
    typeof(a) === "function" ? a() : false;
}

log("hello");
log(3);
log({greeting: "hi"});
//passing functions around
log(function(){
    console.log("hello from inside");
});