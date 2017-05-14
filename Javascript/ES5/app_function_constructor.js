/**
 * Created by rahul.pandey on 5/6/17.
 */
/*function Person() {
 //empty Person object
 console.log(this);
 this.firstName = 'John';
 this.lastName = 'Doe';
 console.log('this function is invoked');
 //what if we write this
 //Object{greeting: 'Aha!'} will be created and we will get in the way of JS engine
 //return {greeting: 'Aha!'};
 }*/

//js does not support function overloading
//so this function will be used as constructor
// start the function name with a capital letter, if we are using it as function constructor
function Person(firstName, lastName) {
    //empty Person object
    console.log(this);
    this.firstName = firstName;
    this.lastName = lastName;
    console.log('this function is invoked');

}
//we can add the getFullName function to the object itself, but the functions are objects and if we tie each object with
// its own copy of getFullName function. This will just increase the memory.
// __proto__ is the accessor of prototype object of function
// prototype property defines the prototype of the objects which are created from the function, which acts as a
// constructor
Person.prototype.getFullName = function () {
    return this.firstName + ' ' + this.lastName;
}

//when we say new it creates an empty function's object, in this case Person, then it invokes the function. A new
// execution context is created. The new operator
// sets "this" to the empty object that it created.
var john = new Person('John', 'Doe');
console.log(john);

var tim = new Person('Tim', 'Cook');
console.log(tim);

Person.prototype.getFormalFullName = function () {
    return this.lastName + " " + this.firstName;
}

console.log(john.getFormalFullName());