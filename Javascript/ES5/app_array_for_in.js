/**
 * Created by rahul.pandey on 5/7/17.
 */
var obj = [
    {
        "1": "abc",
        "2": {
            "3": "def",
            "4": "ghi",
            "5": {
                "6": "abc",
                "7": "def"
            }
        }
    },
    {
        "1": "jkl",
        "2": {
            "3": "mno",
            "4": "pqr"
        }
    }
];
var flatObj = [];

function createFlatObj(obj, key, flat) {
    for (var prop in obj) {
        if (typeof(obj[prop]) === 'object' && Object.keys(obj[prop]).length > 1) {
            createFlatObj(obj[prop], (key.length > 0 ? key + "." : "") + prop, flat);
        } else {
            flat[(key.length > 0 ? key + "." : "") + prop] = obj[prop];
        }
    }
}

for (var i = 0; i < obj.length; i++) {
    var flat = {};
    createFlatObj(obj[i], "", flat);
    flatObj.push(flat);
}

console.log(flatObj);

//Remember not use for...in for arrays

Array.prototype.myCustomFeature = "cool!";
var arr = ['John', 'Jane', 'Jim'];
//this is not recommended
//as will also print the myCustomFeature which is a property in the prototype chain
for (var i in arr) {
    console.log(i, ": ", arr[i]);
}
//use simple for loop