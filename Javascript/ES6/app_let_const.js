/**
 * Created by rahul.pandey on 5/8/17.
 */

const key = 'abc123';
const points = 50;
const winner = false;

if (true) {
  const winner = true;
}

// will print outside scoped variable - false
console.log('winner ', winner);

// can't do this
// key = "3455";

const person = {
  name: 'Ajay',
  age: 28,
};

// not valid
// person = {}

// valid
person.street = '111 Main St.';


// MDN - prevents new properties from being added to it; prevents existing properties from being removed;
// and prevents existing properties, or their enumerability, configurability, or writability, from being changed.
// The method returns the object in a frozen state.
const obj = Object.freeze(person);

obj.age = 34;

// the values remain unchanged
console.log('person ', person);
