/**
 * Created by rahul.pandey on 5/13/17.
 */
// Promises are often used when we are fetching a JSON API
// and using AJAX

// Promise is something that will happen now and sometime later. It is totally asynchronous.

console.log('Going to fetch the latest posts from Wes\' Blog');
const postsPromise = fetch('http://wesbos.com/wp-json/wp/v2/posts');
console.log(postsPromise);

// only run when the data is present
postsPromise.then(data => data.json(),
).then((data) => {
  console.log('returned json data ', data);
}).catch((err) => {
  console.log(err);
});

// creating your own Promise
const p = new Promise((resolve, reject) => {
  setTimeout(() => {
    resolve('Hello I am resolved');
        // wrapped in error to resolve the line number of error
        // reject(Error("Errored Out"));
  }, 2000);
});

p.then((data) => {
  console.log(data);
}).catch((err) => {
  console.log(err);
});


// chaining Promises
const posts = [
    { title: 'I love JS', author: 'Wes Bos', id: 1 },
    { title: 'CSS!', author: 'Chris Coyer', id: 2 },
    { title: 'Dev tooll tricks!', author: 'Addy Osmani', id: 3 },
];

const authors = [
    { name: 'Wes Bos', twitter: '@wesbos', bio: 'Canadian Developer' },
    { name: 'Chris Coyer', twitter: '@chriscoyer', bio: 'CSS Tricks and CodePen' },
    { name: 'Addy Osmani', twitter: '@addyosmani', bio: 'Googler' },
];

function getPostById(id) {
    // create a new Promise
  return new Promise((resolve, reject) => {
        // using a set timeout to mimick a database
    setTimeout(() => {
            // find the post we want
      const post = posts.find(post => post.id === id);
      if (post) {
        resolve(post);
      } else {
        reject(Error('No Post was found!'));
      }
    }, 200);
  });
}

getPostById(2).then((post) => {
  console.log(post);
  return hydrateAuthor(post);
}).then((post) => {
  console.log('after hydrating ', post);
}).catch((err) => {
  console.log(err);
});

function hydrateAuthor(post) {
    // create a new promise
  return new Promise((resolve, reject) => {
    setTimeout(() => { // find the author
      const authorDetails = authors.find(person => person.name === post.author);
      if (authorDetails) {
                // hydrate the post object with the author object
        post.author = authorDetails;
        resolve(post);
      } else {
        reject(Error('Can not find the author'));
      }
    }, 100);
  });
}

// working with multiple promises
const weather = new Promise((resolve) => {
  setTimeout(() => {
    resolve({ temp: 29, conditions: 'Sunny with Clouds' });
  }, 2000);
});

const tweets = new Promise((resolve) => {
  setTimeout(() => {
    resolve(['I like cake', 'BBQ is good too!']);
  }, 500);
});

Promise.all([weather, tweets]).then((responses) => {
  const [weather, tweets] = responses;
  console.log(weather, ' ', tweets);
});

// fetch only allows a CORS
const postsPromise2 = fetch('http://wesbos.com/wp-json/wp/v2/posts');
const streetCarsPromise = fetch('http://data.ratp.fr/api/datasets/1.0/search/?q=paris');

Promise.all([postsPromise2, streetCarsPromise]).then(responses =>
    // json() A promise that resolves with the result of parsing the body text as JSON.
    // This could be anything that can be represented by JSON — an object, an array, a string, a number...
     Promise.all(responses.map(res => res.json()))).then((responses) => {
       console.log('hey ', responses);
     });
