/**
 * Created by rahul.pandey on 5/2/17.
 */
var a;
console.log(a);

//undefined is a special value in JS
//that means the var is not set to a value
//if we never declare a var a and access it, then the engine will throw error 'not defined' as it could not find the var
//in memory
if(a === undefined) {
    console.log('a is undefined');
} else {
    console.log('a is defined');
}

//Not a good practice to do a = undefined, hard to debug whether it was set by us or the engine