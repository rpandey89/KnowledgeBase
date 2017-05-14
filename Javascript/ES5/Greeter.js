/**
 * Created by rahul.pandey on 5/7/17.
 */
(function (global, $) {
    //we will return an object from here
    //but not in a way that we write new every time we access the library
    var Greeter = function (firstName, lastName, language) {
        return new Greeter.init(firstName, lastName, language);
    }

    //do not want to give access to outside code
    //hidden within the scope of the IIFE and never directly accessible
    var supportedLangs = ['en', 'es'];

    //informal greetings
    var greetings = {
        en: 'Hello',
        es: 'Hola'
    }

    //formal greetings
    var formalGreetings = {
        en: 'Greetings',
        es: 'Saludos'
    }

    //logger messages
    var logMessage = {
        en: 'Logged in',
        es: 'Inició sesión'
    }

    //real prototype of the object returned
    Greeter.prototype = {
        fullName: function () {
            return this.firstName + ' ' + this.lastName
        },
        validate: function () {
            if (supportedLangs.indexOf(this.language) === -1) {
                throw "Invalid Language"
            }
        },
        greeting: function () {
            return greetings[this.language] + ' ' + this.firstName + '!';
        },
        formalGreeting: function () {
            return formalGreetings[this.language] + ', ' + this.fullName();
        },
        greet: function (formal) {
            var msg;
            //if undefined or null it will be coerced to false
            if (formal) {
                msg = this.formalGreeting();
            } else {
                msg = this.greeting();
            }
            if (console) {
                console.log(msg);
            }
            //this refers to the calling object at execution time makes the method chainable
            return this;
        },
        log: function () {
            if (console) {
                console.log(logMessage[this.language] + ": " + this.fullName())
            }
            return this;
        },
        setLang: function (lang) {
            this.language = lang;
            this.validate();
            return this;
        },
        updateHTMLGreeting: function (selector, formal) {
            if (!$) {
                throw "jQuery not loaded";
            }

            if (!selector) {
                throw "Missing jQuery Selector";
            }
            var msg;
            if (formal) {
                msg = this.formalGreeting();
            } else {
                msg = this.greeting();
            }

            $(selector).html(msg);
            return this;

        }
    };

    Greeter.init = function (firstName, lastName, language) {
        var self = this;
        self.firstName = firstName || '';
        self.lastName = lastName || '';
        self.language = language || 'en';
        self.validate();
    }

    //this will represent the prototype of the object returned
    Greeter.init.prototype = Greeter.prototype;

    //attach our Greeter to the global object, and provide a shorthand '$G' for ease of usage
    global.Greeter = global.G$ = Greeter;
}(window, $));
