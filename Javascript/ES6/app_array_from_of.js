/**
 * Created by rahul.pandey on 5/10/17.
 */
// from and of functions are not in Array prototype rather than on Array directly

const people = Array.from(document.querySelectorAll('.people p'));
const names = people.map(person => person.textContent);
console.log('names map ', names);

const people2 = document.querySelectorAll('.people p');
const peopleArray = Array.from(people2, person => person.textContent);
console.log('people array ', peopleArray);

function sumAll() {
  const nums = Array.from(arguments);
  return nums.reduce((total, el) => total + el, 0);
}

console.log('total ', sumAll(12, 34, 653, 2534, 6451, 132));

const ages = Array.of(12, 32, 54, 11, 65, 76);

console.log('Ages ', ages);

