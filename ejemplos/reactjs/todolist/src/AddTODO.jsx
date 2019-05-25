import React from 'react';
import './AddTODO.css';

export default class AddTodo extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      text: this.props.text || '',
    };
    this.changeText = this.changeText.bind(this);
    this.addElement = this.addElement.bind(this);
  }

  addElement() {
    this.props.addElemList(this.state.text);
    this.setState({ text: '' });
  }

  changeText(event) {
    this.setState({ text: event.target.value });
  }

  render() {
    return (
      <div className="addTODO">
        <div className="row">
          <div className="col-1 fix-possition text-right">
            <img className="rounded-circle small" src="https://pbs.twimg.com/profile_images/1064465168179085313/YgDr84RZ_bigger.jpg" alt="" />
          </div>
          <div className="col-11">
            <textarea value={this.state.text} onChange={this.changeText} className="form-control" aria-label="With textarea" />
          </div>
        </div>
        <div className="buttonContainer text-right">
          <button type="button" className="btn btn-primary" onClick={this.addElement}>Add</button>
        </div>
      </div>
    );
  }
}
