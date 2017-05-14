/**
 * Created by rahul.pandey on 5/8/17.
 */

function calculateBill(total, tax = 0.13, tip = 0.15) {
  return total + (total * tax) + (total * tip);
}

const totalBill = calculateBill(100);
console.log('the bill is!! ', totalBill);

const totalBill2 = calculateBill(100, undefined, 0.25);
console.log('the bill2 is!! ', totalBill2);
