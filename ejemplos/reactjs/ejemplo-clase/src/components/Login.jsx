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
      this.setState({ success: 'Hello Juan!' })
    } else {
      this.setState({ error: 'Bad username or password (See README.md)' })
    }
  }

  render() {
    return (
      <div className="container">
        <form onSubmit={(ev) => this.login(ev)}>
          <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input className={`form-control ${this.state.error && 'is-invalid'}`} value={this.state.username} onChange={(ev) => this.setState({ username: ev.target.value, error: '' })} />
            {this.state.error && <small class="form-text text-danger">{this.state.error}</small>}
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input className={`form-control ${this.state.error && 'is-invalid'}`} value={this.state.password} onChange={(ev) => this.setState({ password: ev.target.value, error: '' })} />
          </div>
          <button type="submit" class="btn btn-primary" onClick={(ev) => this.login(ev)}>Login</button>
        </form>
        { this.state.success && <h1>{this.state.success}</h1>}
      </div>
    );
  }
}

export default Login;
