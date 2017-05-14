/**
 * Created by rahul.pandey on 5/3/17.
 */
function b() {
    var myVar;
    console.log(myVar);
}

function a() {
    b();
    var myVar = 2;
    console.log(myVar);
}


a();
var myVar = 1;
console.log(myVar);