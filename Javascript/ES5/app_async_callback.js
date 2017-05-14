/**
 * Created by rahul.pandey on 5/3/17.
 */
function waitThreeSeconds() {
    var ms = 3000 + new Date().getTime();
    while (new Date() > ms) {
    }
    console.log('finished function');

}

function clickHandler() {
    console.log('click event!');
}

//execution context for click handler
document.addEventListener('click', clickHandler);

waitThreeSeconds();
console.log('finished execution');