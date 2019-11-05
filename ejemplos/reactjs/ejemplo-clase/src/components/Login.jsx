import React from 'react';

class Login extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      username: '',
      password: '',
      error: '',
      success: '',
    }
  }

  login(ev) {
    ev && ev.preventDefault();
    const { username, password } = this.state;
    if(username === 'juan' && password === 'juan') {
      this.props.history.push('/home', { user: { name: 'Juan' } })
    } else {
      this.setState({ error: 'Bad username or password (See README.md)' })
    }
  }

  render() {
    return (
      <div className="container">
        <form onSubmit={(ev) => this.login(ev)}>
          <div className="form-group">
            <label htmlFor="email">Email address</label>
            <input id="email" className={`form-control ${this.state.error && 'is-invalid'}`} value={this.state.username} onChange={(ev) => this.setState({ username: ev.target.value, error: '' })} />
            {this.state.error && <small className="form-text text-danger">{this.state.error}</small>}
          </div>
          <div className="form-group">
            <label htmlFor="password">Password</label>
            <input id="password" className={`form-control ${this.state.error && 'is-invalid'}`} value={this.state.password} onChange={(ev) => this.setState({ password: ev.target.value, error: '' })} />
          </div>
          <button type="submit" className="btn btn-primary" onClick={(ev) => this.login(ev)}>Login</button>
        </form>
      </div>
    );
  }
}

export default Login;
