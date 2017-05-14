/**
 * Created by rahul.pandey on 5/7/17.
 */
//this is an object
// we set the prototype using extends
class Person {
    constructor(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    greet() {
        return 'hi ' + this.firstName;
    }
}

//sets the prototype (__proto__)
class InformalPerson extends Person {
    constructor(firstName, lastName) {
        super(firstName, lastName);
    }

    greet() {
        return 'Yo ' + this.firstName;
    }
}

var john = new Person('John', 'Doe');