import React from 'react';

class Home extends React.Component {
  constructor(props) {
    super(props);
    this.user = this.props.location.state && this.props.location.state.user;
    if(!this.user) {
      this.props.history.push('/');
    }
  }

  render() {
    const { name } = this.user || {};
    return (
      <div className="container">
        <h1>Hello {name}!!</h1>
      </div>
    );
  }
}

export default Home;
