import React from 'react';
import { getBeers } from '../api/api';
import Beer from './Beer.jsx';

class Home extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      beers: [],
      error: '',
    }
    this.user = this.props.location.state && this.props.location.state.user;
    if(!this.user) {
      this.props.history.push('/');
    }
  }

  componentDidMount() {
    getBeers()
      .then(beers => this.setState({ beers }))
      .catch(error => this.setState({ error }))
  }

  renderBeers() {
    const { beers } = this.state;
    if(beers.length === 0) {
      return <div>Loading!!</div>
    }
    return (
      <div>
        {beers.map(beer => <Beer data={beer} />)}
      </div>
    );

  }

  render() {
    const { name } = this.user || {};
    
    return (
      <div className="container">
        <h1>Hello {name}!!</h1>
        {this.renderBeers()}
      </div>
    );
  }
}

export default Home;
