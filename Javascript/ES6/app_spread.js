/**
 * Created by rahul.pandey on 5/13/17.
 */

const featured = ['Depp Dish', 'Peperoni', 'Hawaiian'];
const specialty = ['Meatzaa', 'Spicy Mama', 'Margherita'];

let pizzas = [];
pizzas = pizzas.concat(featured);
pizzas.push('veg');
pizzas = featured.concat(specialty);
console.log('old way pizzas ', pizzas);


const pizzasNew = [...featured, 'veg', ...specialty];
console.log('new way pizzas ', pizzasNew);

// copy by reference
// const fridayPizzas = pizzas;
// we can do this way but little verbose
// const fridayPizzas = [].concat(pizzas);

// spread operator copies by value
const fridayPizzas = [...pizzas];
fridayPizzas[0] = 'Pie';
console.log('copy by value ', fridayPizzas);
console.log('old way pizzas ', pizzas);


const people = document.querySelectorAll('.people p');
const names = Array.from(people).map(person => person.textContent);

const deepDish = {
  pizzaName: 'Deep dish',
  size: 'Medium',
  ingredients: ['Marinara', 'Italian Sausage', 'Dough', 'Cheese'],
};

const shoppingList = ['Milk', 'Flour', ...deepDish.ingredients];

const comments = [
    { id: 2, text: 'a' },
    { id: 3, text: 'b' },
    { id: 4, text: 'c' },
    { id: 5, text: 'x' },
];

const id = 5;
const commentIndex = comments.findIndex(comment => comment.id === id);

const newComments = [...comments.slice(0, commentIndex), ...comments.slice(commentIndex + 1)];
console.log(' new comments ', newComments);

// spreading in functions
const inventors = ['Einstein', 'Newton', 'Galileo'];
const newInventors = ['Musk', 'Jobs'];
// this works
// inventors.push.apply(inventors, newInventors);
inventors.push(...newInventors);
console.log('spread function inventors ', inventors);

function sayHi(first, last) {
  console.log(`Hey there ${first} ${last}`);
}

sayHi(...['Rahul', 'Pandey']);
