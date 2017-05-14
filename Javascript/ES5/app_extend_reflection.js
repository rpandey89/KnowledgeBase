/**
 * Created by rahul.pandey on 5/6/17.
 */
var person = {
    firstName: 'Default',
    lastName: 'Default',
    getFullName: function () {
        return this.firstName + ' ' + this.lastName;
    }
};

var john = {
    firstName: 'John',
    lastName: 'Doe'
}

//Never use in real world. For demo purpose only
john.__proto__ = person;

//loop over every member in the object
//prop will be the current item that we are looking at
for (var prop in john) {
    //this function is on base Object object
    if (john.hasOwnProperty(prop)) {
        console.log(prop, ': ', john[prop]);
    }
}

var jane = {
    address: '111 Main St.',
    getFormalFullName: function () {
        return this.lastName + ', ' + this.firstName;

    }
}

var jim = {
    getFirstName: function () {
        return firstName;

    }
}

_.extend(john, jane, jim);

console.log("after extend ", john);