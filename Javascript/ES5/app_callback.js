function sayHiLater() {
    var greeting = 'Hi!';

    setTimeout(function() {
        //usage of closure here
        //the function will have access to greeting which is defined in the outer scope
        console.log(greeting);
    }, 3000);
}

sayHiLater();

//jQuery uses function expressions and first-class functions!

function tellMeWhenDone(callback) {
    var i = 0;
    while(i++ < 100000) {}
    callback();
}

tellMeWhenDone(function() {
    console.log("I am done");
});

tellMeWhenDone(function() {
    console.log("hey hey");
});