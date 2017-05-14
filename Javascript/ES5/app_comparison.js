//associativity rule
console.log("1 < 2 < 3 ", 1 < 2 < 3); //true (2 < 3) = true, which is 1 (1 < 3) true
console.log("3 < 2 < 1 ", 3 < 2 < 1); //true (3 < 2) = false, which is 0 (false < 1) true

console.log("3 < 2 < -11 ", 3 < 2 < -11); //false

console.log("3 < 2 < null ", 3 < 2 < null); //false
//Number(null) = 0 Number(undefined) = NaN
//Number(false) = 0 Number(true) = 1
//Number("3") = 3

console.log("3 == 3 ", 3 == 3); //true
console.log("3 == \"3\" ", 3 == "3"); //true
console.log("false == 0 ", false == 0); //true
console.log("null == 0 ", null == 0); //false null is 0 from above
console.log("null < 1 ", null < 1); //true null is 0 from above
console.log("\"\" == 0 ", "" == 0); //true
console.log("\"\" == false " , "" == false); //true

console.log("3 === 3 ", 3 === 3) //true
console.log("\"3\" === \"3\" ", "3" === "3") //true
console.log("3 === \"3\" ", 3 === "3") //false