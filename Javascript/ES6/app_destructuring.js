/**
 * Created by rahul.pandey on 5/10/17.
 */
const person = {
  first: 'Rahul',
  last: 'Pandey',
  country: 'India',
  city: 'Lucknow',
  email: 'blah@gmail.com',
};

const { first, last, email } = person;

const obj = {
  first: 'Rahul',
  last: 'Pandey',
  email: 'blah@gmail.com',
  address: {
    country: 'India',
    city: 'Lucknow',
  },
};

const { first: firstName, last: lastName } = obj;
// renaming the vars
const { country: c, city: ct } = obj.address;

const settings = { width: 300, color: 'black' };


const { width = 100, height = 100, color = 'blue', fontSize = 25 } = settings;

// Object Destructuring with variable renaming & default values
const { w: wTH = 400, h: hTH = 500 } = { w: 200 };
// w and h are undefined over here

// Arrays with Destructuring
const details = ['Rahul Pandey', 123, 'blah@gmail.com'];
// const name = details[0];
const [name, id, emailId] = details;
console.log('array dtls ', name, ' ', id, ' ', emailId);

const data = 'Cricket,Sports,2017,28,rahul,pandey';

const [itemName, category, sku, inventory] = data.split(',');

const team = ['Sachin', 'Sourav', 'Dravid', 'Anil'];

const [opener1, opener2, ...players] = team;

// swapping variables with Destructuring
let inRing = 'Hulk Hogan';
let onSide = 'The Rock';

console.log('before swapping ', inRing, ' ', onSide);
[inRing, onSide] = [onSide, inRing];
console.log('after swapping ', inRing, ' ', onSide);

// Multiple returns and named defaults
function convertCurrency(amount) {
  return {
    USD: amount * 0.76,
    GPB: amount * 0.53,
    AUD: amount * 1.01,
    MEX: amount * 13.30,
  };
}

const { USD, AUD } = convertCurrency(100);
console.log('currency ', USD, ' ', AUD);


function tipCalc({ total, tip = 0.15, tax = 0.13 } = {}) {
  return total + (tip * total) + (tax * total);
}

// the obj is undefined over here so have to handle as a default
// in the function
// const bill = tipCalc();
const bill = tipCalc({ total: 200, tip: 0.20 });
console.log('bill ', bill);
