const React = require('react');
const { Component } = React;

class Hello extends Component{
    constructor(props){
        super(props)

        this.state ={
            hello : `안녕하세요`,
        }
    }

    render(){
        return <h1>{this.state.hello}</h1>
    }
}

module.exports = Hello;