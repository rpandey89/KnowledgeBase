var objectLiteral = {
    firstName: 'Mary',
    isAProgrammer: true
};

console.log("json obj ", JSON.stringify(objectLiteral));

var jsonValue = JSON.parse('{"firstName": "Mary", "isAProgrammer": true}');

console.log("json value ", jsonValue);