import React from 'react';
import './ListTODO.css';
import AddTodo from './AddTODO';

const UserImageTodo = () => (
  <div className="col-1 aaa">
    <img className="rounded-circle" src="https://pbs.twimg.com/profile_images/1064465168179085313/YgDr84RZ_bigger.jpg" alt="" />
  </div>
);

const HeaderTodo = props => (
  <div className="row">
    <div className="col-11">
      <h6>UserName - Time</h6>
    </div>
    <div className="col-1">
      <HeaderTodoActions index={props.index} edit={props.edit} delete={props.delete} />
    </div>
  </div>
);

const HeaderTodoActions = props => (
  <div className="dropdown">
    <button className="btn dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" />
    <div className="dropdown-menu" aria-labelledby="dropdownMenu2">
      <button className="dropdown-item" type="button" onClick={() => props.edit(props.index)}>Edit</button>
      <button className="dropdown-item" type="button" onClick={() => props.delete(props.index)}>Delete</button>
    </div>
  </div>
);

export default class ListTODO extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      currentSelected: null,
    };
    this.edit = this.edit.bind(this);
    this.delete = this.delete.bind(this);
  }

  edit(index) {
    this.setState({ currentSelected: index });
  }

  delete(index) {
    this.props.deleteElemList(index);
  }

  renderEditElem(index, text) {
    return (
      <AddTodo
        addElemList={(newText) => {
          this.props.editElemList(index, newText);
          this.setState({ currentSelected: null });
        }}
        text={text}
      />
    );
  }

  renderElem(index, text) {
    return (
      <div key={index} className={index === 0 ? 'list-group-item borderList first' : 'list-group-item borderList'}>
        <div className="row">
          <UserImageTodo />
          <div className="col-11">
            <HeaderTodo index={index} edit={this.edit} delete={this.delete} />
            <p>{text}</p>
          </div>
        </div>
      </div>
    );
  }

  render() {
    return (
      <div className="list-group">
        {this.props.elems.map((elem, index) => {
          if (this.state.currentSelected === index) {
            return this.renderEditElem(index, elem.text);
          }
          return this.renderElem(index, elem.text);
        })}
      </div>
    );
  }
}
