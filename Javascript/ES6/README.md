# Var Scoping

- var variables are either scoped in the function or globally via window object if defined globally.
- They can be accessed outside a block that is not a function. For e.g. if/else, while, for-loop

# Let/Const

- let and const variables are block scoped, that means functions, if-else, loops etc.
- let variables can't be re-declared in the same scope.
- const variables can't be re-assigned a value.
- Properties of a const object can be changed.

- use const by default
- use var only when re-binding is required
- var should be used for top level vars that have to be shared across scopes

# Temporal Dead Zone

Where you cannot access the variable where it is not yet defined.

- var can be accessed. Hint - Hoisting
- let and const cannot be accessed

# Arrow Functions

They are anonymous functions

- Concise
- Implicit Returns
- Does not re-bind the value of this

### When not to use Arrow Functions

- really need 'this'
- need a method to bind to an object
- need to add a prototype method
- need arguments object

```js
var x = 100;
console.log(x);
```
