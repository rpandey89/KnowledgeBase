//node js module
const path = require('path');
const ExtractTextPlugin = require('extract-text-webpack-plugin');

const config = {
    entry: './src/index.js',
    output: {
        path: path.resolve(__dirname, 'build'),
        filename: 'bundle.js',
        publicPath: 'build/'
    },
    module: {
        rules: [
            {
                use: 'babel-loader',
                test: /\.js$/
            }, //{
            //use: ['style-loader', 'css-loader'],
            // test: /\.css$/
            //},
            {
                //falling back to old way of defining loaders to use the plugin
                loader: ExtractTextPlugin.extract({
                    loader: 'css-loader'
                }),
                test: /\.css$/
            },
            {
                test: /\.(jpe?g|png|gif|svg)$/,
                use: [
                    {
                        loader: 'url-loader',
                        // <= 40000 bytes large include in bundle.js
                        options: {limit: 40000}
                    },
                    {
                        loader: 'image-webpack-loader',
                        options: {}
                    }

                ]
            }
        ]
    },
    plugins: [
        //all the css files will be combined to a file named styles.css
        new ExtractTextPlugin('styles.css')
    ]
};

module.exports = config;