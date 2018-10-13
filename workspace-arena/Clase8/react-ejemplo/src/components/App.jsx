import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import 'open-iconic/font/css/open-iconic-bootstrap.min.css';
import '../dist/css/App.css';

import React from 'react';
import { Switch, Route } from 'react-router';
import { BrowserRouter } from 'react-router-dom';

import Anime from './Anime.jsx';
import Home from './Home.jsx';
import Root from './Root.jsx';
import Search from './Search.jsx';

export default class App extends React.Component {
  render() {
    return (
      <BrowserRouter>
        <Root>
          <Switch>
            <Route path="/newAnime" component={Anime} />
            <Route path="/anime/:id" component={Anime} />
            <Route path="/search/:text" component={Search} />
            <Route exact path="/" component={Home} />
          </Switch>
        </Root>
      </BrowserRouter>
    );
  }
}
