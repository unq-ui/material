import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import Greeter from './Greeter';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      user: {
        name: '...',
      },
      count: 0,
    };
    this.changeNameToSarasa = this.changeNameToSarasa.bind(this);
  }

  changeNameToSarasa() {
    this.setState({ user: { name: 'sarasa' } });
  }

  increaseCount() {
    this.setState(prevState => ({ count: prevState.count + 1 }));
  }

  render() {
    return (
      <div>
        <Greeter user={this.state.user} callback={() => this.increaseCount()} />
        <div>
          <p style={{ color: this.state.count === 10 && 'red' }}>
            {this.state.count}
          </p>
        </div>
        <button type="button" onClick={this.changeNameToSarasa}>Cambiar nombre!</button>
      </div>
    );
  }
}

export default App;
