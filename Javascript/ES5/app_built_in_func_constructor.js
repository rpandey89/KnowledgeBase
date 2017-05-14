/**
 * Created by rahul.pandey on 5/7/17.
 */

//Built in function constructors
// prototype property has functions defined available to objects created
var a = new Number(3);
console.log("Number a ", a); //Number {[[PrimitiveValue]]: 3}__proto__: Number[[PrimitiveValue]]: 3
var b = new String("hey");
console.log("String b ", b); //String {0: "h", 1: "e", 2: "y", length: 3, [[PrimitiveValue]]: "hey"}
var c = new Date("3/1/2015");
console.log("date c ", c); //Sun Mar 01 2015 00:00:00 GMT-0800 (PST)
String.prototype.isLengthGreaterThan = function(limit) {
    return this.length > limit;
}

Number.prototype.isPositive = function() {
    return this.valueOf() > -1;
}

console.log("is greater than 3 ", b.isLengthGreaterThan(3));
//this works, JS converts string to object automatically
console.log("is greater than 3 ", "hello".isLengthGreaterThan(3));

console.log("is positive " , a.isPositive());

//here it does not happen the same
//console.log("is positive " , 3.isPositive());

//Note: don't use function constructors for primitives
//this is legal and can be used
//we can use them for conversion as normal functions
var t = Number("3");
console.log("converted from string ", t);



