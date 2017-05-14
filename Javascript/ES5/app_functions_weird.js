function a() {
    console.log("a ", this); //this points to window
    this.newVar = "blahahaha"; //newVar is attached to Window obj
}

a();

console.log(newVar);

var b = function() {
    console.log("b ", this); //this points to window
}

b();

var c = {
    name: 'The c object',
    log: function() {
        var self = this;
        this.name = 'Updated c object';
        self.name = 'Updated c object';
        console.log(this);
        console.log("self ", self);

        //internal functions have a problem
        var setName = function(newName) {
            this.name = newName; //weird this attaches to global window object
            self.name = newName;
        }
        setName('Updated again c object!');
        console.log(this);
        console.log("self ", self);
    }
}

c.log();