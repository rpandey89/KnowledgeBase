//not the preferred way to declare objects

console.log("----new Object()-----");
var person = new Object();
console.log(person);
//[ and ] is an operator which is called Computed Member Access Op
person["firstName"] = "Ajay";
person["lastName"] = "Singh";

var firstNameProperty = "firstName";

console.log("person ", person);
console.log("firstName ", person[firstNameProperty]);

//. is member access op
console.log("firstName ", person.firstName);
console.log("lastName ", person.lastName);

person.address = new Object();
person.address.street = "FLores Street";
person.address.city = "New York";
person.address.state = "NY";

//both operators are accessing same memory locations
console.log("street ", person.address.street);
console.log("city ", person["address"].city);
console.log("state ", person["address"]["state"]);

console.log("---Object literal----");
//Object literal
var temp = {};
console.log("temp ", temp);
//faster
//engine will look for curly braces and identify that we are declaring an object
var person = {
    firstName: "Ajay",
    lastName: "Singh",
    address: {
        street: "Flores Street",
        city: "New York",
        state: "NY"
    }
};
console.log("person ", person);

function greet(person) {
    console.log("Hi ", person.firstName);
}

greet(person);
greet({
    firstName: "Me",
    lastName: "here"
});
