/**
 * Created by rahul.pandey on 5/8/17.
 */
// When you really need `this`
/* const button = document.querySelector("#pushy");
button.addEventListener("click", () => {
    //arrow function not bound to the button
    console.log(this);
    this.classList.toggle('on');
});
//instead do this
const button = document.querySelector('#pushy');
button.addEventListener('click', function() {
    console.log(this);
    this.classList.toggle('on');
});*/


// When you need a method to bind to an object
/* const person = {
    points: 23,
    score: () => {
        console.log(this);
        this.points++;
    }
}*/

const person = {
  points: 23,
    // we can define function like this too
  score() {
    console.log(this);
    this.points++;
  },
    // score: function() {console.log(this);this.points++;}
};

// When you need to add a prototype method
class Car {
  constructor(make, colour) {
    this.make = make;
    this.colour = colour;
  }
}
const beemer = new Car('bmw', 'blue');
const subie = new Car('Subaru', 'white');

/* Car.prototype.summarize = () => {
    //this points to window
    console.log(this);
    return `This car is a ${this.make} in the colour ${this.colour}`;
}*/
Car.prototype.summarize = function () {
  return `This car is a ${this.make} in the colour ${this.colour}`;
};
// When you need arguments object
/* const orderChildren2 = () => {
    //areguments not defined
    const children = Array.from(arguments);
    return children.map((child, i) => {
        return `${child} was child #${i + 1}`;

    });
    console.log(arguments);
}*/
const orderChildren = function () {
  const children = Array.from(arguments);
  return children.map((child, i) => `${child} was child #${i + 1}`);
  console.log(arguments);
};

// console.log(orderChildren2(['rahul', 'suman', 'shanti']));
console.log(orderChildren(['rahul', 'suman', 'shanti']));
