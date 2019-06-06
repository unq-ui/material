import React from 'react';
import { Link } from 'react-router-dom';

import './css/SignIn.css';
import { signUp } from '../api/api';

export default class SignUp extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      username: props.match.params.id || '',
      password: '',
      imageLink: '',
      error: '',
    };
    this.changeUsername = this.changeUsername.bind(this);
    this.changePassword = this.changePassword.bind(this);
    this.changeImageLink = this.changeImageLink.bind(this);
    this.executeSignUp = this.executeSignUp.bind(this);
  }

  changeUsername(event) {
    this.setState({ username: event.target.value });
  }

  changePassword(event) {
    this.setState({ password: event.target.value });
  }

  changeImageLink(event) {
    this.setState({ imageLink: event.target.value });
  }

  executeSignUp() {
    const body = {
      username: this.state.username,
      password: this.state.password,
      imageLink: this.state.imageLink,
    };
    signUp(body)
      .then(userId => this.props.history.push('/home', { userId }))
      .catch(() => this.setState({ error: 'Usuario ya utilizado' }));
  }

  renderInput(label, value, inputType, onChange) {
    return (
      <div className="form-group row">
        <label className="col-sm-3 col-form-label">{label}</label>
        <div className="col-sm-9">
          <input type={inputType} className="form-control" value={value} onChange={onChange} />
        </div>
      </div>
    );
  }

  render() {
    return (
      <div className="container">
        <div className="row centerRow">
          <div className="col-3" />
          <div className="col-6 card newCard">
            <div className="card-body">
              {this.renderInput('Username', this.state.username, 'text', this.changeUsername)}
              {this.renderInput('Password', this.state.password, 'password', this.changePassword)}
              {this.renderInput('ImageLink', this.state.imageLink, 'text', this.changeImageLink)}
              <div className="col-12">
                <button type="button" className="btn btn-primary btn-block" onClick={this.executeSignUp}>Registrarse</button>
              </div>
              <div className="col-12">
                <Link to="/" className="btn btn-link">Cancelar</Link>
              </div>
              <div className="col-12 empty">
                {this.state.error && this.state.error}
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
