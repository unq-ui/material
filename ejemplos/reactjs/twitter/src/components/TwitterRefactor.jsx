import React from 'react';
import api from '../api/api';
import { Tweet, FormTweet, WaitingTwitting } from './TwitterComponents'
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

class TwitterRefactor extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      formTweet: this.formComponent(),
      custom: "42",
      tweets: []
    }
  }

  formComponent = (error) => <FormTweet error={error} createTweet={this.createTweetInParent} />

  componentDidMount() {
    api.getTweets()
      .then(data => this.setState({ tweets: data }))
      .catch(this.setState({
        formTweet: this.formComponent("No se pudieron cargar los tweets")
      }));
  }

  createTweetInParent = ({ username, tweet }) => {
    this.setState({ formTweet: <WaitingTwitting /> })
    api.createTweet({ username, tweet })
      .then(data => {
        this.setState(state => ({
          tweets: [{
            username: data.username,
            tweet: data.lastTweet
          }, ...state.tweets],
          formTweet: this.formComponent()
        }))
      })
      .catch(this.setState({
          formTweet: this.formComponent("Ups! Pasaron cosas...")
      }))
  }

  render() {
    const tweets = this.state.tweets.map((tweet, key) => <Tweet key={key} {...tweet} />);
    return (
      <div className="TwitterQ">
        <h1>Twitter Q</h1>
        {this.state.formTweet}
        <div className="QTweets">
          {tweets}
        </div>
      </div>
    );
  }
}

export default TwitterRefactor;
