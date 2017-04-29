//Calls functions from sum.js then prints the result
// CommonJS
// const sum = require('./sum');
import sum from './sum';
//the file gets executed
import './image_viewer';

const total = sum(10, 5);
console.log("total ", total);