/**
 * Created by rahul.pandey on 5/6/17.
 */
function Person() {
    //empty Person object
    console.log(this);
    this.firstName = 'John';
    this.lastName = 'Doe';
    console.log('this function is invoked');
    //what if we write this
    //Object{greeting: 'Aha!'} will be created and we will get in the way of JS engine
    //return {greeting: 'Aha!'};
}

//js does not support function overloading
//so this function will be used as constructor
function Person(firstName, lastName) {
    //empty Person object
    console.log(this);
    this.firstName = firstName;
    this.lastName = lastName;
    console.log('this function is invoked');

}


//when we say new it creates an empty function's object, in this case Person, then it invokes the function. A new
// execution context is created. The new operator
// sets "this" to the empty object that it created.
var john = new Person('John', 'Doe');
console.log(john);

var tim = new Person('Tim', 'Cook');
console.log(tim);