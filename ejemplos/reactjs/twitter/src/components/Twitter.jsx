import React from 'react';
import axios from 'axios';
import { Tweet, FormTweet, WaitingTwitting } from './TwitterComponents';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

class Twitter extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      formTweet: <FormTweet createTweetFromParent={this.createTweetInParent} />,
      custom: "42",
      tweets: [
        // {
        //   username: "@arya",
        //   tweet: "Not Today"
        // },
        // {
        //   username: "@hodor",
        //   tweet: "Hodor Hodor Hodor Hodor Hodor"
        // },
        // {
        //   username: "@cersei",
        //   tweet: "I choose violence"
        // },
      ]
    }
  }

  componentDidMount() {
    axios.get("http://localhost:7000/tweets")
      .then(response => {
        console.log("GET TWEETS: ", response)
        this.setState({ tweets: response.data })
      })
      .catch(error => console.log("**** ERROR ****", error.toJSON()))
  }

  createTweetInParent = ({ username, tweet }) => {
    this.setState({ formTweet: <WaitingTwitting /> })
    axios.post(`http://localhost:7000/tweets/${username}`, { text: tweet })
      .then(response => {
        console.log("POST TWEET: ", response)
        this.setState(state => ({
          tweets: [{
            username: response.data.username,
            tweet: response.data.lastTweet
          }, ...state.tweets],
          formTweet: <FormTweet createTweetFromParent={this.createTweetInParent} />
        }))
      })
      .catch(error => {
        console.log(error.toJSON())
        this.setState({
          formTweet: <FormTweet error="Ups! Pasaron cosas..." createTweetFromParent={this.createTweetInParent} />
        })
      })
  }

  render() {
    const tweets = this.state.tweets.map((tweet, key) => 
      <Tweet key={key} {...tweet} />
    );
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

export default Twitter;
