module.exports = [
    {
        test: /\.jsx?$/,
        loader: 'babel-loader',
        options: {
            presets: ['react', ["es2015", {"modules": false}], 'stage-0'],
            plugins: ['react-html-attrs', 'transform-class-properties', 'transform-decorators-legacy'],
        },
        exclude: [/(node_modules|bower_components)/, "webpack_v1"]
    },
    {
        test: /\.css$/,
        loader: 'style-loader!css-loader'
    },
    {
        test: /\.eot(\?v=\d+\.\d+\.\d+)?$/,
        loader: "file"
    },
    {
        test: /\.woff(\?v=\d+\.\d+\.\d+)?$/,
        loader: "url?prefix=font/&limit=5000"
    },
    {
        test: /\.ttf(\?v=\d+\.\d+\.\d+)?$/,
        loader: "url?limit=10000&mimetype=application/octet-stream"
    },
    {
        test: /\.svg(\?v=\d+\.\d+\.\d+)?$/,
        loader: "url?limit=10000&mimetype=image/svg+xml"
    },
    {
        test: /\.gif/,
        loader: "file?name=./images/[sha512:hash:base64:7].[ext]"
    },
    {
        test: /\.jpg/,
        loader: "file?name=./images/[sha512:hash:base64:7].[ext]"
    },
    {
        test: /\.png/,
        loader: "file?name=./images/[sha512:hash:base64:7].[ext]"
    }
];