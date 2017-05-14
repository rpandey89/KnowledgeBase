// Select all the list items on the page and convert to array
//let listItems = Array.from(document.querySelectorAll("li"));
let listItems = Array.from(document.querySelectorAll("[data-time]"));
// Filter for only the elements that contain the word 'flexbox'
listItems = listItems
    .filter((el) => el.innerText.toLowerCase().includes("flexbox"))
    // map down to a list of time strings
    .map((el) => el.getAttribute("data-time"))
    // map to an array of seconds
    .map((el) => {
        const arr = el.split(":").map(p => parseFloat(p));
        return arr[0] * 3600 + arr[1] * 60;
    })
    // reduce to get total
    .reduce((total, seconds) => {
        return total + seconds;
    }, 0);
console.log("total is ", total);
// 🔥  This can also be done in a single .reduce(), but we're practicing arrow functions here, so chain them!
const totalFromSingleReduce = Array.from(document.querySelectorAll("li")).reduce(function (total, el) {
    if (el.textContent.toLowerCase().includes("flexbox")) {
        const arr = el.dataset.time.split(":");
        total = total + parseFloat(arr[0]) * 3600 + parseFloat(arr[1]) * 60;
    }
    return total;
}, 0);
console.log("totalFromSingleReduce ", totalFromSingleReduce);

// 1. Given this array: `[3,62,234,7,23,74,23,76,92]`, use the array filter method and an arrow function to create an array of the numbers greater than `70`
const numbers = [3, 62, 234, 7, 23, 74, 23, 76, 92];
const numbersGreaterThan70 = numbers.filter((number) => number > 70);
console.log("numbers greater than 70 ", numbersGreaterThan70);