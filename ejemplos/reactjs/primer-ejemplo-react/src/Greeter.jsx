import React from 'react';

export default class Greeter extends React.Component {
  constructor(props) {
    super(props);
    this.name = props.name || '...';
  }

  render() {
    return (
      <div>
        Hola {this.props.user.name}
        <button
          type="button"
          onClick={() => this.props.callback()}
        >
            Press!!!
        </button>
      </div>
    );
  }
}
