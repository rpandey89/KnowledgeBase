function greet(name) {
    name = name || '<Your name here>'; // undefined || 'hello' -> hello returns value that can be coerced to true
    console.log('Hello ' + name);
}

//the || operator returns the first value that can be coerced to true
console.log("undefined || 'hello' ", undefined || 'hello');
console.log("null || 'hello' ", null || 'hello');
console.log("'' || 'hello' ", '' || 'hello');
console.log("'' || 0 ", '' || 0);
console.log("'' && 'hello' ", '' && 'hello'); // prints empty string
console.log("undefined && 'hello' ", undefined && 'hello'); //undefined
console.log("1 && 'hello' ", 1 && 'hello'); //'hello'
//&& Returns expr1 if it can be converted to false; otherwise, returns expr2. Thus, when used with Boolean values,
// && returns true if both operands are true; otherwise, returns false.

//|| Returns expr1 if it can be converted to true; otherwise, returns expr2. Thus, when used with Boolean values,
// || returns true if either operand is true.

//! Returns false if its single operand can be converted to true; otherwise, returns true.

greet('Ravi'); //Hello Ravi

greet(); //Hello undefined. The JS does not find any value set to name
greet(0); //Your name here as 0 is still false