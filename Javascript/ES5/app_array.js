//var arr = new Array();
//Array literal format
var arr = [
    1,
    false,
    {
        name: 'Ajay',
        address: '111 Main St.'
    },
    function(name) {
    "use strict";
    var greeting = "Hello ";
    console.log(greeting + name);
    },
    "hello"
];

console.log(arr);
arr[3](arr[2].name);