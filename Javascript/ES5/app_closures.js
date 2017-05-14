function greet(whatToSay) {
    return function (name) {
        console.log(whatToSay, " ", name);

    }
}

greet('Hi')('Tony');

var sayHi = greet('Hi');
sayHi('Tony');


function buildFunctions() {
    var arr = [];

    for (var i = 0; i < 3; i++) {
        arr.push(
            function () {
                console.log("buildFunction ", i);

            }
        )
    }
    return arr;
}

var fs = buildFunctions();

fs[0]();
fs[1]();
fs[2]();

//es6 way
function buildFunctions2() {
    var arr = [];

    for (var i = 0; i < 3; i++) {
        //scoped to the block inside the curly braces
        // new var in memory
        //the execution context will have link to diff memory every time
        let j = i;
        arr.push(
            function () {
                console.log("buildFunction2 ", j);

            }
        )
    }
    return arr;
}

var fs2 = buildFunctions2();

fs2[0]();
fs2[1]();
fs2[2]();


//es5 way
function buildFunctions3() {
    var arr = [];

    for (var i = 0; i < 3; i++) {
        arr.push(
            (function (j) {
                return function () {
                    console.log("builFunction3 ", j, " this ", this);

                }
            }(i))
        )
    }
    return arr;
}

var fs3 = buildFunctions3();

fs3[0]();
fs3[1]();
fs3[2]();