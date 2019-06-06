import React from 'react';

import Navbar from './Navbar';
import AddTODO from './AddTODO';
import ListTODO from './ListTODO';

import { getTodos } from '../api/api';

export default class Home extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      user: {
        id: '',
        imageLink: '',
        username: '',
        todos: [],
      },
      error: '',
    };

    this.deleteElemList = this.deleteElemList.bind(this);
    this.editElemList = this.editElemList.bind(this);
    this.addElemList = this.addElemList.bind(this);
  }

  componentDidMount() {
    getTodos(this.props.location.state.userId)
      .then(user => this.setState({ user }))
      .catch(() => this.setState({ error: '??' }));
  }

  editElemList(index, newText) {
    this.setState(prevState => ({
      user: {
        ...prevState.user,
        todos: prevState.user.todos
          .map((text, i) => (i === index ? { description: newText } : text)),
      },
    }));
  }

  deleteElemList(index) {
    this.setState(prevState => ({
      user: {
        ...prevState.user,
        todos: prevState.user.todos.filter((text, i) => i !== index),
      },
    }));
  }

  addElemList(text) {
    this.setState(prevState => ({
      user: {
        ...prevState.user,
        todos: [...prevState.user.todos, { id: '??', description: text, date: new Date() }],
      },
    }));
  }

  render() {
    return (
      <div>
        <Navbar />
        <div className="container">
          <AddTODO addElemList={this.addElemList} />
          <ListTODO
            elems={this.state.user.todos}
            editElemList={this.editElemList}
            deleteElemList={this.deleteElemList}
          />
        </div>
        {this.state.error && <div>{this.state.error}</div>}
      </div>
    );
  }
}
