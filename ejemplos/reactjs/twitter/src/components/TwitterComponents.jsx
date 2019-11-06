import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

export const Tweet = ({ username, tweet }) => {
  return (
    <div className="Tweet">
      <h5>{username}</h5>
      <p>{tweet}</p>
    </div>
  );
}

export class FormTweet extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      error: props.error,
      username: "",
      tweet: ""
    }
  }

  createTweet = () => {
    if (this.state.username.trim().length < 2 
          || !this.state.username.trim().startsWith("@")) {
      this.setState({ error: "Usuario mal formado, escribir: @username" });
      return;
    }
    if (this.state.tweet.trim().length < 1) {
      this.setState({ error: "Tweet vacío..." });
      return;
    }
    this.props.createTweetFromParent(this.state)
  }

  updateUsername = (event) => this.setState({ username: event.target.value })
  updateTweet = (event) => this.setState({ tweet: event.target.value })

  render() {
    console.log("STATE:", this.state)
    return (
      <div className="FormTweet">
        <ErrorMessage error={this.state.error} />
        <form>
          <div className="form-group">
            <label htmlFor="username">Username </label>
            <input
              type="text"
              className="form-control"
              placeholder="@username"
              name="username"
              value={this.state.username}
              onChange={this.updateUsername}
            />
          </div>
          <div className="form-group">
            <textarea
              className="form-control"
              rows="3" placeholder="¿Qué está pasando?"
              onChange={this.updateTweet}
              value={this.state.tweet} />
          </div>
          <div className="form-group">
            <button
              type="button"
              className="btn btn-info"
              onClick={this.createTweet}
            >
              Twittear
              </button>
          </div>
        </form>
      </div>
    )
  }
}

export const WaitingTwitting = () => {
  return (
    <div className="spinner-border" role="status">
      <span className="sr-only">Loading...</span>
    </div>
  )
}

const ErrorMessage = props => {
  return (
    props.error
      ? <div className="alert alert-danger" role="alert">{props.error}</div>
      : null
  );
}