/**
 * Created by rahul.pandey on 5/3/17.
 */

var x = 'global';
let y = 'global';
console.log(this.x); // "global"
console.log(this.y); // undefined

function varTest() {
    var x = 1;
    if (true) {
        var x = 2;  // same variable!
        console.log(x);  // 2
    }
    console.log(x);  // 2
}

function letTest() {
    let x = 1;
    if (true) {
        let x = 2;  // different variable
        console.log(x);  // 2
    }
    console.log(x);  // 1
}

varTest();
letTest();


for (let i = 1; i <= 5; i++) {
    let item = document.createElement('li');
    item.appendChild(document.createTextNode('Item ' + i));

    item.onclick = function (ev) {
        console.log('Item ' + i + ' is clicked.');
    };
    document.body.appendChild(item);
}

// to achieve the same effect with 'var'
// you have to create a different context
// using a closure to preserve the value
for (var i = 1; i <= 5; i++) {
    var item = document.createElement('li');
    item.appendChild(document.createTextNode('Item ' + i));

    (function (i) {
        item.onclick = function (ev) {
            console.log('Item ' + i + ' is clicked.');
        };
    })(i);
    document.body.appendChild(item);
}

/*
 The example above works as intended because the five instances of the (anonymous) inner function refer to five
 different instances of the variable i. Note that it does not work as intended if you replace let with var, since all
 of the inner functions would then return the same final value of i: 6. Also, we can keep the scope around the loop
 cleaner by moving the code that creates the new elements into the scope of each loop.
 */