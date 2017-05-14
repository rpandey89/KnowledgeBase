/**
 * Created by rahul.pandey on 5/7/17.
 */
//polyfill
//the below functionality is what Object.create does
if (!Object.create) {
    Object.create = function (o) {
        if (arguments.length > 1) {
            throw new Error('Object.create implementation only accepts the first parameter.')
        }
        function F() {
        }

        F.prototype = o;
        return new F();
    }
}


var person = {
    firstName: 'Default',
    lastName: 'Default',
    greet: function () {
        return 'Hi ' + this.firstName;
    }
}

//person acts as a prototype object
var john = Object.create(person);
//override the properties from the prototype object
john.firstName = 'John';
john.lastName = 'Doe';
console.log("john ", john);