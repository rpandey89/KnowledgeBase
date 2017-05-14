/**
 * Created by rahul.pandey on 5/6/17.
 */
var person = {
    firstName: 'Default',
    lastName: 'Default',
    getFullName: function() {
        return this.firstName + ' ' + this.lastName;
    }
};

var john = {
    firstName: 'John',
    lastName: 'Doe'
}

//Never use in real world. For demo purpose only
john.__proto__ = person;
//this will refer to john, whatever object originated the call
console.log(john.getFullName());
//the engine starts at the top and goes down the prototype chain
//the firstName will be taken from john
console.log(john.firstName);


var jane = {
    firstName: 'Jane'
}

jane.__proto__ = person;
console.log(jane.getFullName());