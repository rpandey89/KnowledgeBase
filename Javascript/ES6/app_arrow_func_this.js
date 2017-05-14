/**
 * Created by rahul.pandey on 5/8/17.
 */
const msg = 'hello';
const a = {
  msg: 'hey',
    // this function is bounded to object a
  greet(firstName, lastName) {
    console.log(`${this.msg} ${firstName} ${lastName}`);
        // gets the context inherited from the parent scope which is this object
    const innerArrowGreet = () => `${this.msg} ${firstName} ${lastName}`;
    console.log('inner Greet ', innerArrowGreet());
        // gets the context from the window object as this is not bound to anything!
    const innerWOArrowGreet = function () {
      return `${this.msg} ${firstName} ${lastName}`;
    };
    console.log('w/o arrow inner ', innerWOArrowGreet());
  },
    // this function gets its context from window or global context
  greet2: (firstName, lastName) => `${this.msg} ${firstName} ${lastName}`,
};

a.greet('Rahul', 'Pandey');
console.log('greet2 ', a.greet2('Rahul', 'Pandey'));
