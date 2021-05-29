const path = require('path');

module.exports = {
    name : 'hello',
    mode : 'development',
    devtool : 'eval',

    // 자바스크립트 합쳐질것을 넣는곳
    resolve : {
        extensions : ['.js','.jsx']
    },

    entry :{
        app : ['./client'],
    },

    module : {
        rules : [{
            test : /\.jsx?$/,
            loader : 'babel-loader',
            options : {
                presets: ['@babel/preset-env' ,'@babel/preset-react'],
            },
        }],
    },
    // 합쳐진 자바스크립 파일이 나올곳
    output : {
        path : path.join(__dirname, 'dist' ),
        filename : 'app.js'
        // 현재폴더에서 dist / app.js 파일을 생성 
    }
}