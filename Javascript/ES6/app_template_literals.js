/**
 * Created by rahul.pandey on 5/8/17.
 */
const name = 'Snickers';
const age = 2;
const sentence = `My dog ${name} is ${age * 7} years old.`;
const sentenceTemplate = `My dog ${name} is ${age * 7} years old.`;
console.log(sentenceTemplate);

const person = {
  name: 'Rahul',
  job: 'Developer',
  city: 'San Francisco',
  bio: 'blah in dev!',
};

// html fragments with template strings
const markup = `
<div class="person">
    <h2>
    ${person.name}
    <span class="job">${person.job}</span>
    </h2>
    <p class="location">${person.city}</p>
    <p class="bio">${person.bio}</p>
    </div>
`;
console.log('markup ', markup);
document.querySelector('#div1').innerHTML = markup;


const dogs = [
    { name: 'Snickers', age: 2 },
    { name: 'Hugo', age: 8 },
    { name: 'Sunny', age: 1 },
];
// template within template
const markupDogs = `
    <ul class="dogs">
        ${dogs.map(dog =>
            `<li>
                ${dog.name} is ${dog.age * 7}
            </li>`)
        .join('')}
    </ul>
`;

document.querySelector('#div2').innerHTML = markupDogs;

console.log(markupDogs);

const songs = [{
  name: 'Hello',
  artist: 'Adele',
}, {
  name: 'Humsafar',
  artist: 'Alia Bhatt',
  featuring: 'Arijit Singh',
}];
// if condition within template
const markupSongs = `
<div class="songs">
    ${songs.map(song =>
        `<li>
            ${song.name} - ${song.artist}
            ${song.featuring ? `(Featuring ${song.featuring})` : ''}
        </li>`)
    .join('')}
</div>
`;

console.log('featuring ', markupSongs);

document.querySelector('#div3').innerHTML = markupSongs;

const beer = {
  name: 'Belgian Wit',
  brewery: 'Steam Whistle Brewery',
  keywords: ['pale', 'cloudy', 'spiced', 'crisp'],
};
// calling a function from a template
const renderKeyWords = keywords =>
    `${keywords.map(keyword => `
        <li>
        ${keyword}
        </li>`)
    .join('')
}`;

const markupBeers = `
<div class="beer">
    <p>
        ${beer.name} - ${beer.brewery}
        ${renderKeyWords(beer.keywords)}
    </p>
</div>
`;

console.log('featuring ', markupBeers);

document.querySelector('#div4').innerHTML = markupBeers;

