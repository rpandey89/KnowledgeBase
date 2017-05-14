console.log("Boolean(undefined) ", Boolean(undefined)); //false
console.log("Boolean(null) ", Boolean(null)); //false
console.log("Boolean('') ", Boolean("")); //false
console.log("Boolean(0) ", Boolean(0)); //false

//the above ogic is used in the if statement
var a;

//goes to internet and looks for a value
a = ""; //nothing
a = "hi"; //something is there
a = 0 //nothing which is wrong

if (a) {
    console.log('Something is there');
}

//false || true
if(a || a === 0) {
    console.log('did not find something above, but after update found it!');
}