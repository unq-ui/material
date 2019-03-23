import React, { Component } from 'react';
import axios from 'axios';

export default class Login extends Component {
  constructor(props) {
    super(props);
    this.state = {
      mail: '',
      password: '',
    };
  }

  handleChange(value, prop) {
    this.setState(prevState => ({ ...prevState, [prop]: value }));
  }

  handleClick() {
    axios.get(`http://localhost:3003/${this.state.mail}`)
      .then(response => this.props.history.push('/simple', response.data))
      .catch(console.log);
  }

  handleClick2() {
    this.props.history.push(`/${this.state.mail}/simple2`);
  }

  render() {
    return (
      <React.Fragment>
        <div>
          <label>Mail:</label>
          <label>{this.state.mail}</label>
        </div>
        <div>
          <label>Password:</label>
          <label>{this.state.password}</label>
        </div>
        <div>
          <label>Mail</label>
          <input
            value={this.state.mail}
            onChange={event => this.handleChange(event.target.value, 'mail')}
          />
          <label>Password</label>
          <input
            value={this.state.password}
            onChange={event => this.handleChange(event.target.value, 'password')}
          />
          <button type="button" onClick={() => this.handleClick()}>Login</button>
          <button type="button" onClick={() => this.handleClick2()}>Login2</button>
        </div>
      </React.Fragment>
    );
  }
}
