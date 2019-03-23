import React from 'react';
import API from '../service/api.js';

export default class Anime extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      anime: {
        title: '',
        urlDetails: '',
        image: '',
        type: '',
        episodes: 0,
        startDate: '',
        endDate: '',
        members: 0,
        score: 0,
      },
      defaultImage: 'https://upload.wikimedia.org/wikipedia/commons/a/ac/No_image_available.svg',
      isNew: true,
    };
  }

  componentDidMount() {
    console.log(this.props.match.params.id);
    if (this.props.match.params.id) {
      this.setState({ isNew: false });
      API.get(`/anime/${this.props.match.params.id}`)
        .then(response => this.setState({ anime: response }))
        .catch(console.log);
    }
  }

  change(property, event) {
    const currentAnime = this.state.anime;
    this.setState({ anime: { ...currentAnime, [property]: event.target.value } });
  }

  goBack() {
    this.props.history.goBack();
  }

  sendAnime() {
    console.log(this.props.history);
    (this.state.isNew ? API.put('/anime', { ...this.state.anime }) : API.post('/anime', { ...this.state.anime }))
      .then(() => this.props.history.push('/'))
      .catch(console.log);
  }

  formRow(label, property, propertyName, type = 'text') {
    return (
      <div className="form-group row">
        <label className="col-3 col-form-label">{label}</label>
        <div className="col-9">
          <input type={type} value={property} className="form-control" onChange={event => this.change(propertyName, event)} />
        </div>
      </div>
    );
  }

  render() {
    return (
      <div>
        <h1>{this.state.isNew ? 'New' : 'Edit'} Anime</h1>
        <div className="row">
          <div className="col-4">
            <img src={this.state.anime.image || this.state.defaultImage} alt="Imagen del Anime" className="imageCard" />
          </div>
          <div className="col-6">
            { this.formRow('Title', this.state.anime.title, 'title') }
            { this.formRow('Url Details', this.state.anime.urlDetails, 'urlDetails')}
            { this.formRow('Image', this.state.anime.image, 'image')}
            { this.formRow('Type', this.state.anime.type, 'type')}
            { this.formRow('Episodes', this.state.anime.episodes, 'episodes', 'number')}
            { this.formRow('Start Date', this.state.anime.startDate, 'startDate')}
            { this.formRow('End Date', this.state.anime.endDate, 'endDate')}
            { this.formRow('Members', this.state.anime.members, 'members', 'number')}
            { this.formRow('Score', this.state.anime.score, 'score', 'number')}
          </div>
        </div>
        <div className="btn-group float-right" role="group">
          <button type="button" className="btn btn-secondary" onClick={() => this.goBack()}>Cancel</button>
          <button type="button" className="btn btn-primary" onClick={() => this.sendAnime()}>Accept</button>
        </div>
      </div>
    );
  }
}
