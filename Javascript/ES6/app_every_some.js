/**
 * Created by rahul.pandey on 5/13/17.
 */

const ages = [32, 15, 19, 12];

// is there at least one adult in the group
const adultPresent = ages.some(age => age >= 12);
console.log('greater than 12 ', adultPresent);

// is everyone old enough to drink?
const allOldEnough = ages.every(age => age >= 19);
console.log('all old ', allOldEnough);
