/**
 * Created by rahul.pandey on 5/13/17.
 */
// symbols avoid naming collisions, they are a unique identifier
// they are not enumerable, hence they cannot be looped over

// here Rahul is a descriptor
const name = Symbol('Rahul');
const person = Symbol('Rahul');

console.log('Rahul Symbol == ', name == person);
console.log('Rahul Symbol === ', name === person);

const classRoom = {
  [Symbol('Mark')]: { grade: 50, gender: 'male' },
  [Symbol('Olivia')]: { grade: 80, gender: 'female' },
  [Symbol('Mark')]: { grade: 90, gender: 'female' },
};

console.log('classroom with symbol ', classRoom);

// nothing
for (const p in classRoom) {
  console.log(p);
}

const syms = Object.getOwnPropertySymbols(classRoom);
const data = syms.map(sym => classRoom[sym]);
console.log('classroom after iterating using getOwnPropertySymbols ', data);
