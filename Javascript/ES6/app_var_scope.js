/**
 * Created by rahul.pandey on 5/8/17.
 */
var width = 100;
console.log('width ', width);

var width = 200;

console.log('updated width ', width);

function setWidth() {
  const innerT = 400;
  console.log('inner width ', innerT);
}

setWidth();

// can't access as var is function scoped
// here we defined it inside the function
// console.log("outside inner Width ", innerT);

const age = 100;
if (age > 12) {
  var dogYears = age * 7;
  const dogYears2 = dogYears;
  console.log(`You are ${dogYears} dog years old!`);
}

// dogYears is accessible as it is defined in a block not a function scope
console.log(`Outside you are ${dogYears} dog years old`);
// not accessible
// console.log(`Outside you are ${dogYears2} dog years old`);
