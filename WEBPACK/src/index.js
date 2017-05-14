const button = document.createElement('button');
button.innerText = 'Click me!';

button.onclick = () => {
    //When we use System.import, webpack will split the code into files and add all the additional code into another file
    System.import('./image_viewer.js').then(module => {
        module.default();
    });
};

document.body.appendChild(button);