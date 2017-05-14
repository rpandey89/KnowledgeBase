/**
 * Created by rahul.pandey on 5/7/17.
 */
var a = 3;
console.log("number? ", typeof a);

var b = "Hello";
console.log("string? ", typeof  b);

var c = {};
console.log("obj? ", typeof c);

var d = [];
console.log("array? ", typeof d); //weird!
//take the array and call toString function using this as d
console.log("array better way ", Object.prototype.toString.call(d)); //better! [object Array]
console.log(d.toString(), " ", d); //returns empty string

var z = function () {
};
console.log("function typeof ", typeof z);

function Person(name) {
    this.name = name;
}

var e = new Person('Jane');
console.log("Person typeof? ", typeof e, " ", e); //object prototype is object
//check whether a is something that is there in its prototype chain
console.log("Person instance of ", e instanceof Person);

console.log("undefined typeof ", typeof undefined);
console.log("null typeof ", typeof null);