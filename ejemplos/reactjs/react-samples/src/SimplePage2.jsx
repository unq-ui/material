import React from 'react';
import { withRouter } from 'react-router';

class SimplePage2 extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      email: '',
    };
  }

  componentDidMount() {
    this.setState({ email: this.props.match.params.email });
  }

  render() {
    return <div><h1>Hola ----- {this.state.email}</h1></div>;
  }
}

export default withRouter(SimplePage2);
