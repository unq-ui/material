import React from 'react';
import { withRouter } from 'react-router';

class Header extends React.Component {
  constructor(props) {
    super(props);
    this.state = { search: '' };
  }

  handleChange(event) {
    this.setState({ search: event.target.value });
  }

  handleSubmit() {
    this.props.history.push(`/search/${this.state.search}`);
  }

  goToHome() {
    this.props.history.push('/');
  }

  render() {
    return (
      <nav className="navbar navbar-light bg-light justify-content-between">
        <button type="button" className="navbar-brand btn btn-link" onClick={() => this.goToHome()}> <span className="oi oi-book" /> </button>
        <div className="form-inline">
          <input
            className="form-control"
            placeholder="Search"
            type="text"
            onChange={event => this.handleChange(event)}
          />
          <button className="btn btn-outline-success my-2 my-sm-0" type="submit" onClick={() => this.handleSubmit()}>Search</button>
        </div>
      </nav>
    );
  }
}

export default withRouter(Header);
