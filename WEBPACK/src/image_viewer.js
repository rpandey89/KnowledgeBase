//import big from '../assets/big.jpeg';
import small from '../assets/small.jpeg';
import '../styles/image_viewer.css';

export default () => {
    //nothing to do with code splitting, just to see what is going on
    const image = document.createElement('img');
    //image.src = 'http://lorempixel.com/400/400';
    image.src = small;

    document.body.appendChild(image);
}


/*const image1 = document.createElement('img');
 //image.src = 'http://lorempixel.com/400/400';
 image1.src = big;

 document.body.appendChild(image1);*/
