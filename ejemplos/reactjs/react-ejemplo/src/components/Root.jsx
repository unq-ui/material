import React from 'react';
import Header from './Header.jsx';

export default class Root extends React.Component {
  render() {
    return (
      <div>
        <Header />
        <div className="container">
          {this.props.children}
        </div>
      </div>
    );
  }
}
