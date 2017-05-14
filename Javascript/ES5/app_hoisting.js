/**
 * Created by rahul.pandey on 5/2/17.
 */
//the function ran
b();
//this will show undefined
//if we remove code at line 10 then the engine will throw
console.log(a);

var a = 'Hello World!';

function b() {
    console.log('Called b!');
}