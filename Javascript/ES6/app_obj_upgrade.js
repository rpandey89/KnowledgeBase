/**
 * Created by rahul.pandey on 5/13/17.
 */
const first = 'snickers';
const last = 'boss';
const age = 2;
const breed = 'King Charles Cav';
// we want the key to be same as variable name
const dog = { first, last, age, breed };
console.log('addition to obj literal ', dog);


const modal = {
  create(selector) {
  },
  open(content) {
  },
  close(goodbye) {
  },
  closeNew(goodbye) {
  },
};


function invertColor(color) {
  return `#${(`000000${(0xFFFFFF ^ parseInt(color.substring(1), 16)).toString(16)}`).slice(-6)}`;
}

const key = 'pocketColor';
const value = '#ffc600';
const tShirt = {
  [key]: value,
  [`${key}Opposite`]: invertColor(value),
};

console.log('new obj tShirt ', tShirt);


const key1 = ['size', 'color', 'weight'];
const values = ['medium', 'red', 100];

// automatically loops through using shift
const shirt = {
  [key1.shift()]: values.shift(),
  [key1.shift()]: values.shift(),
  [key1.shift()]: values.shift(),
};

console.log('shift key/value shirt obj ', shirt);
