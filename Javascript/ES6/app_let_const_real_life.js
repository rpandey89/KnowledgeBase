/**
 * Created by rahul.pandey on 5/8/17.
 */
{
  const name = 'Abhishek';
  console.log('const name ', name);
}

(function () {
    // does not get leak to the global scope
  const name = 'Ajay';
  console.log('name ', name);
}());


for (var i = 0; i < 10; i++) {
  setTimeout(() => {
        // will print 10
        // as the loop has run
    console.log('The number is ', i);
  }, 1000);
}
// prints 10
console.log(i);

// let is block scoped
for (let j = 0; j < 10; j++) {
  setTimeout(() => {
        // will print jth index
        // as the loop has run
    console.log('The let number is ', j);
  }, 1000);
}
// error as let is block scoped
// console.log(j);
