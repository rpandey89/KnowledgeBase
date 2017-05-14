/**
 * Created by rahul.pandey on 5/5/17.
 */
var person = {
    firstName: 'John',
    lastName: 'Doe',
    getFullName: function () {
        var fullName = this.firstName + ' ' + this.lastName;
        return fullName;
    }
}

var logName = function (lang1, lang2) {
    //this is window object from line 55
    console.log('Logged: ', this.getFullName());

    console.log('Arguments: ', lang1, ' ', lang2);
    console.log('-------');
}

//bind copies the function and sets some more props
//when engine executes the function it sets the this context to person or whatever we pass to bind
//the function will be executed later
var logPersonName = logName.bind(person);

logPersonName('en');

//call executes the function and decides this param and passes on the params required by the function
logName.call(person, 'en', 'es');

//apply method requires an array as param
logName.apply(person, ['en', 'es']);

// function borrowing
var person2 = {
    firstName: 'Jane',
    lastName: 'Doe'
}

console.log("function borrow ", person.getFullName.apply(person2));

// function currying
function multiply(a, b) {
    return a * b;

}

//set param 1 to 2 permanently
var multiplyByTwo = multiply.bind(this, 2);
//this will be param2
console.log('function currying ', multiplyByTwo(10));

console.log("Another way to call after bind ", multiply.bind(this, 2, 3)());

logName();

