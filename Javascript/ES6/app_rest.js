/**
 * Created by rahul.pandey on 5/13/17.
 */

// Rest param takes multiple elements and packs into array

// rest params should not be initialized
function convertCurrency(rate, ...amounts) {
  return amounts.map(amount => amount * rate);
}

console.log('converted amounts ', convertCurrency(1.54, 10, 23, 52, 1, 56));
console.log('converted amounts no pass ', convertCurrency(1.54));

const runner = ['Rahul Pandey', 123, 5.5, 5, 3, 6, 35];

const [name, id, runs, ...left] = runner;

console.log(name, id, runs, left);

const [captain, assistant, ...players] = ['Saurav', 'Rahul', 'Sachin', 'Kumble', 'Yuvraj'];
console.log(captain, assistant, players);
