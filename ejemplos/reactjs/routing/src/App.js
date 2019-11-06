import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import { BrowserRouter, Switch, Route, NavLink, Redirect }
  from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      <NavBar />
      <Switch>
        <Route exact path="/" children={<Home />} />
        <Route path="/redirect/2"
               render={props => <MyRedirect2 {...props} />} />
        <Route path="/redirect"
               render={props => <MyRedirect {...props} />} />
        <Route path="/page-1" component={Page1} />
        <Route path="/page/:number"
               render={props =>
                  <Page custom='custom-property' {...props} />} />
        <Route path="*"
               render={props => <NotFound {...props} />} />
      </Switch>
    </BrowserRouter>
  );
}

const NavBar = () => {
  return (
    <nav className="nav">
      <NavLink className="nav-link" to="/">Home</NavLink>
      <NavLink className="nav-link" to="/page-1">Page 1</NavLink>
      <NavLink className="nav-link" to="/page/2">Page 2</NavLink>
      <NavLink className="nav-link" to="/page/3">Page 3</NavLink>
      <NavLink className="nav-link" to="/redirect">Redirect</NavLink>
      <NavLink className="nav-link" to="/redirect/2">Redirect 2</NavLink>
    </nav>
  );
}

const Home = () => <h1>Home</h1>;
const Page1 = () => <h1>Page 1</h1>;
const Page = props => {
  console.log(props);
  let number = Number(props.match.params.number);
  if (isNaN(number)) props.history.push("/cualquier-cosa");
  return <h1>Page {props.match.params.number}</h1>
};
const MyRedirect = () => <Redirect push to="/page/3" />;
const MyRedirect2 = props => <button
  type="button"
  className="btn btn-danger"
  onClick={() => props.history.push("/page/42")}>Redirect</button>;
const NotFound = props => <h1>404 Not Found {props.location.pathname}</h1>;

export default App;
