/**
 * Created by rahul.pandey on 5/5/17.
 */
var arr1 = [1, 2, 3];
console.log(arr1);

var arr2 = [];
for (var i = 0; i < arr1.length; i++) {
    arr2.push(arr1[i] * 2);
}
console.log(arr2);

function mapForEach(arr, fn) {
    var newArr = [];
    for (var i = 0; i < arr.length; i++) {
        newArr.push(fn(arr[i]));
    }
    return newArr;
}

var arr3 = mapForEach(arr1, function (item) {
    return item * 2;
});

console.log("func prog new arr ", arr3);

var arr4 = mapForEach(arr1, function (item) {
    return item > 2;
});

console.log("func prog new arr1 ", arr4);

var checkPartLimit = function (limiter, item) {
    return item > limiter;

}

var returnBoundMethod = function (limiter) {
    //return checkPartLimit.bind(this, limiter);
    return function (limiter, item) {
        return item > limiter;
    }.bind(this, limiter);
}

var arr5 = mapForEach(arr1, returnBoundMethod(1));

console.log("func prog new arr2 ", arr5);

var arr6 = _.map(arr1, function (item) {
    return item * 3;
});
console.log("map from underscore ", arr6);

var arr7 = _.filter([2, 3, 4, 5, 6, 7], function (item) {
    return item % 2 === 0;
});
console.log("filter from underscore ", arr7);