const React = require('react');
const ReactDom = require('react-dom');

const Hello = require('./hello');

ReactDom.render(<Hello/> , document.querySelector('#root'));