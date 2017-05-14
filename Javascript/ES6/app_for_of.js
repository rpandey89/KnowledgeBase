/**
 * Created by rahul.pandey on 5/10/17.
 */
Array.prototype.myProp = 'hey yo';
const cuts = ['Chuck', 'Brisket', 'Shank', 'Short Rib'];

for (let i = 0; i < cuts.length; i++) {
  console.log('for normal cuts_', i, ' ', cuts[i]);
}

cuts.forEach((cut, i) => {
  console.log('cut_', i, ' ', cut);
    // but we can't break or continue in this
});

// iterating over the props here
// but it will iterate over the prop down the prototype chain too
for (const index in cuts) {
  console.log('for in cuts_', index, ' ', cuts[index]);
}

for (const cut of cuts) {
    // we can use break and continue
  console.log('for of ', cut);
}

// ArrayIterator
const entries = cuts.entries();
let b = entries.next();

while (!b.done) {
  b = entries.next();
  console.log('entry ', b);
}

for (const [i, cut] of cuts.entries()) {
  console.log(`${cut} is the ${i} item`);
}


function addUpNumbers() {
  let total = 0;
  console.log('arguments ', arguments);
    // arguments is an array like object
    // we can convert to an array using Array.from
    // or Array.prototype.slice.call(arguments)
    // always use const for block scoping
  for (const num of arguments) {
    total += num;
  }

    // forEach can't be called on arguments array like obj
    // arguments.forEach((num) => {total += num});
    // we can use Array.prototype.forEach.call(arguments, function(arg, i){console.log(arg, ' ', i)});
  console.log('total ', total);
  return total;
}

addUpNumbers(10, 23, 43, 56, 78, 90);

const name = 'Wes Bos';
for (const char of name) {
  console.log('string el ', char);
}

// objects are not iterable so cannot use with for of
const apple = {
  color: 'Red',
  size: 'Medium',
  weight: 50,
  sugar: 10,
};
// of course we can use for in
for (const prop of Object.keys(apple)) {
  const value = apple[prop];
  console.log('apple value ', value, ' ', prop);
}
