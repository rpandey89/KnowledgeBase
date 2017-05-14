var a = 1 + '2'; //coerced 1 to string representation
console.log("1 + '2' ", a);

console.log("1 + true ", 1 + true); // true coerced to value 1 -> 2

console.log("1 + null ", 1 + null); // 1
console.log("1 + undefined ", 1 + undefined); // NaN

console.log("1 - true ", 1 - true); // true coerced to value 1 -> 0
console.log("1 - null ", 1 - null); // still 1
console.log("1 +  '2' + '2' ", 1 + "2" + "2"); //122
console.log("1 +  +'2' + '2' ", 1 + +"2" + "2"); //32
console.log("1 +  -'1' + '2' ", 1 + -"1" + "2"); //02
console.log("+'1' +  '1' + '2' ", +"1" + "1" + "2"); //112
console.log("'A' - 'B' + '2' ", "A" - "B" + "2"); //NaN2
console.log("'A' - 'B' + 2 ", "A" - "B" + 2); //NaN