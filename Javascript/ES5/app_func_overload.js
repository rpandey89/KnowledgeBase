function greet(name, language) {
    switch (language) {
        default:
        case "en" :
            console.log("hello ", name);
            break;
        case "es" :
            console.log("hola ", name);
            break;
    }
}

function greetEnglish(name) {
    greet(name, 'en');
}

function greetSpanish(name) {
    greet(name, 'es');
}

greetEnglish('John');
greetSpanish('John');