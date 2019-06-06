import React from 'react';
import { Link } from 'react-router-dom';

import './css/SignIn.css';
import { signIn } from '../api/api';

export default class SignIn extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      username: props.match.params.id || '',
      password: '',
      error: '',
    };
    this.changeUsername = this.changeUsername.bind(this);
    this.changePassword = this.changePassword.bind(this);
    this.executeSignIn = this.executeSignIn.bind(this);
  }

  changeUsername(event) {
    this.setState({ username: event.target.value });
  }

  changePassword(event) {
    this.setState({ password: event.target.value });
  }

  executeSignIn() {
    signIn({ username: this.state.username, password: this.state.password })
      .then(userId => this.props.history.push('/home', { userId }))
      .catch(() => this.setState({ error: 'Usuario o contraseña incorrecta' }));
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
              <div className="col-12">
                <button type="button" className="btn btn-primary btn-block" onClick={this.executeSignIn}>Ingresar</button>
              </div>
              <div className="col-12">
                <Link to="/register" className="btn btn-link">No tenes cuenta, registrate!</Link>
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
