import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import 'open-iconic/font/css/open-iconic-bootstrap.min.css';
import './dist/App.css';

import React, { Component } from 'react';
import { Route, Switch } from 'react-router';
import { BrowserRouter } from 'react-router-dom';
import Login from './Login';
import SimplePage from './SimplePage';
import SimplePage2 from './SimplePage2';

class App extends Component {
  render() {
    return (
      <BrowserRouter>
        <Switch>
          <Route path="/simple" render={props => <SimplePage user={props.location.state} />} />
          <Route path="/:email/simple2" component={SimplePage2} />
          <Route path="/" render={props => <Login {...props} />} />
        </Switch>
      </BrowserRouter>
    );
  }
}


export default App;
