# Webpack

### Server Side Templating/Rendering
Back end server creates an HTML document and sends it to the user. Less Javascript code is involved.

1. User visits a page
1. HTTP request to server
1. An HTML document
1. User clicks in a link
1. HTTP request to server
1. A new HTML document

### Single Page Applications
Server sends a bare-bones HTML doc to the user. Javascript runs on the users machine to assemble a full webpage. Huge number of Javascript lines of code are involved.

1. User visits a page
1. HTTP request to server
1. An HTML document
1. React/Angular boots up, shows page
1. User clicks link
1. React/Angular shows new content

### Modules
In javascript world, we divide the code amongst a number of smaller files called modules.

- Pros
1. Modular code
1. Easy to read and debug

- Cons
1. Issues with the loading and execution of individual files
1. Decreased performance due to many http requests for small scripts

### Purpose
Merge a pile of tiny js modules into one big bundle in load order, while keeping high performance over an http connection

### Module System

- CommonJS :
Implemented by NodeJS. Syntax - require and module.exports statements

- AMD : 
Asynchronous Module Definition - require and define keywords

- ES2015 : 
import and export statements

### What does bundle.js contain?
A sample

```
//defines the modules as an array of functions
//bundle them together
var myModules = [
    function() {
       const sum = (a, b) => a + b;
       return sum;
    },
    function() {
        //the dependency is being called before the actual module is executed
        const sum = myModules[0]();
        const total = sum(10, 10);
        console.log(total);
    }
]
//define an entry point
var entryPointIndex = 1;
//and call that function
myModules[entryPointIndex]();
```

Some caching also happens, so that the modules which are already loaded can be re-used.

### Module Loaders
Used to do pre-processing on the files before they are merged in the bundle.js file. Loaders are applied from right 
to left when multiple loaders are defined for a file type.

- Babel
Transpiling ES2015 code into ES5
babel-loader - Teaches babel how to work with webpack
babel-core - Knows how to take in code, parse it, and generate some output files
babel-preset-env - Ruleset for telling babel exactly what pieces of ES2015/6/7 syntax to look for, and how to turn it
into ES5 code
react - transpiles jsx to js code

Note: Webpack does not include all the js files in the bundle.js file. A file has to be imported in another js file.

- CSS
css-loader - Knows how to deal with CSS imports
style-loader - Takes CSS imports and adds them to the HTML document

- Plugins
They execute outside the pipeline of webpack. They look at the total sum of input or total sum of output that is going to webpack.

- Image
image-webpack-loader - compacts the image
url-loader - if the image is small, include in bundle.js as raw data otherwise include as a separate file in the output
dir. It emits the url of the file with 'output.publicPath' prepended to the URL.


### Code Splitting
Two buckets:
Our Code - Code written by us
Vendor Code - 3rd party module code

How browser caching of assets works
1st visit - file_z.js -> Have I downloaded this before -> No! -> Download it from server
Next visit - file_z.js -> Have I downloaded this before -> Yes! -> Great, use the cached file. No need to download anything.

Dependency updates happen less frequently than our codebase updates.

- Code Splitting with React Router

### Webpack-Dev-Server
Development server is about developing client side app with zero server side logic
Changes only the module which has changed in the vendor or bundle output. This increases the build time.
Nothing is saved to the dir when we run the server. Files only exist in memory as part of server.
Hence, it is only for development and not for production.

```webpack -p - automatically minifies the js code for prod```