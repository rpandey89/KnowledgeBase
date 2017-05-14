/**
 * Created by rahul.pandey on 5/3/17.
 */
function b() {
    console.log("b -> ", myVar);
}

function a() {
    function c() {
        console.log("c -> ", myVar);
    }

    var myVar = 2;
    b();
    c();
}

var myVar = 1;
a();
//error c() is not defined as lexical env of c is attached to a
// as the global execution context during creation phase only looked for a and not inside it
//c();

//Scope Chain
//global <- a <- c
//global <- b