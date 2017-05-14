/**
 * Created by rahul.pandey on 5/8/17.
 */
const course = 'RFB2';
const flightNumber = '20-AC2018-jz';
const accountNumber = '825242631RT0001';

const make = 'BMW';
const model = 'x5';
const colour = 'Royal Blue';

// .startsWith()
console.log('startsWith RFB? ', course.startsWith('RFB')); // true
console.log('startsWith rfb? ', course.startsWith('rfb')); // false
console.log('startsWith AC after 3 chars? ', flightNumber.startsWith('AC', 3)); // start after three characters - true

// .endsWith()
console.log('endsWith jz? ', flightNumber.endsWith('jz'));// true
console.log('endsWith RT after 11 chars? ', accountNumber.endsWith('RT', 11)); // true

// .includes()
console.log('includes AC?', flightNumber.includes('AC')); // true
console.log('includes ac?', flightNumber.includes('ac')); // false

// .repeat()

function leftPad(str, length = 20) {
  return `${' '.repeat(length - str.length)}${str}`;
}


console.log('make ', leftPad(make));
console.log('model ', leftPad(model));
console.log('colour ', leftPad(colour));

