/**
 * Created by rahul.pandey on 5/8/17.
 */
const names = ['rahul', 'rakesh', 'suman'];

const fullNames = names.map(name => `${name} pandey`);

console.log('fullNames ', fullNames);

const fullNames1 = names.map(name => `${name} pandey`);

console.log('fullNames1 ', fullNames1);

const fullNames2 = names.map(name => `${name} pandey`);

console.log('fullNames2 ', fullNames2);

const fullNames3 = names.map(name => `${name} pandey`);

console.log('fullNames3 ', fullNames3);

const fullNames4 = names.map(() => 'cool T');

console.log('fullNames4 ', fullNames4);

const sayHello = name => console.log(`Hello ${name}`);

sayHello('John');


const race = '100m Dash';
const winners = ['Hunter Gath', 'Singa Song', 'Imda Ros'];

const win = winners.map((winner, i) => ({
  name: winner, race, place: i + 1,
}));

console.log('win data ', win);
// type console.table(win) - magic

const ages = [23, 62, 45, 234, 2, 62, 234, 62, 34];

const old = ages.filter(age => age >= 60);

console.log('old data ', old);
