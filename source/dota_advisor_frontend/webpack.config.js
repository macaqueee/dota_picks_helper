var loaders = require('./webpackv2.loaders.js');
var HtmlWebpackPlugin = require('html-webpack-plugin');
var path = require('path');

module.exports = {
    devServer: {
        disableHostCheck: true
    },
    target: 'web',
    context: path.join(__dirname, "src"),
    devtool: 'source-map',
    entry: {
        app: "./app.js",
    },
    resolve: {
        modules: [
            path.resolve(__dirname),
            "node_modules"
        ],
        extensions: ['.js', '.jsx']
    },
    module: {
        rules: loaders
    },
    output: {
        path: path.join(__dirname, 'dist'),
        filename: "[name].js",
        publicPath: "/"
    },
    plugins: [
        new HtmlWebpackPlugin({
            template: __dirname + "/src/index.html"
        }),
    ]
};