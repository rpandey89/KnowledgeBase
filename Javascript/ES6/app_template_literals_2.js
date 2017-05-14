/**
 * Created by rahul.pandey on 5/8/17.
 */
// usage of rest operator
function highlight(strings, ...values) {
  console.log(arguments);
  let str = '';
  strings.forEach((string, i) => {
        // str += string + (values[i] || '')
    str += `${string} <span contenteditable class="h1">${values[i] || ''}</span>`;
  });
  return str;
}

const name = 'Snickers';
const age = 100;
const sentence = highlight`My dog's name is ${name} and he is ${age} years old`;
console.log(sentence);
document.querySelector('#div1').innerHTML = sentence;

const dict = {
  HTML: 'Hyper Text Markup Language',
  CSS: 'Cascading Style Sheets',
  JS: 'Javascript',
  Java: 'Java',
};

function addAbbreviations(strings, ...values) {
  const abbreviated = values.map((value) => {
    if (dict[value]) {
      return `<abbr title="${dict[value]}">${value}</abbr>`;
    }
    return value;
  });
  console.log(abbreviated);
  return strings.reduce((sentence, string, i) => `${sentence}${string}${abbreviated[i] || ''}`, '');
}

const first = 'Rahul';
const last = 'Pandey';

const sentence1 = addAbbreviations`Hello my name is ${first} ${last} and I am learning to code in ${'HTML'}, ${'CSS'}, ${'JS'}, and ${'Java'}`;

const bio = document.querySelector('#div1');
const p = document.createElement('p');
p.innerHTML = sentence1;
bio.appendChild(p);
// sanitizing html
function sanitize(strings, ...values) {
  const dirty = strings.reduce((prev, next, i) => `${prev}${next}${values[i] || ''}`, '');
  return DOMPurify.sanitize(dirty);
}

const firstName = 'Rahul';
const aboutMe = sanitize`I love to do evil <img src="http://unsplash.it/100/100?random" onload="alert('you got hacked');"/>`;

const html = `
    <h3>${first}</h3>
    <p>${aboutMe}</p>
`;

const bio1 = document.querySelector('#div2');
bio1.innerHTML = html;
