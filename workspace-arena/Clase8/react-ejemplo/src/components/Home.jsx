import React from 'react';
import { Link } from 'react-router-dom';

import API from '../service/api';

class Home extends React.Component {
  constructor(props) {
    super(props);
    this.state = { animes: [] };
  }

  componentDidMount() {
    API.get('/animes')
      .then(response => this.setState({ animes: response.data }))
      .catch(console.log);
  }

  createAnimeRow() {
    return this.splitAnimesOn(3).map((list, i) => (
      <div className="card-deck" key={`card_${i}`}>
        {list.map(anime => this.createCard(anime))}
      </div>
    ));
  }

  createCard(anime) {
    return (
      <div className="card mb-3" key={anime.id}>
        <img className="card-img-top imageCard" src={anime.image} alt="asd" />
        <div className="card-body">
          <h5 className="card-title">{anime.title}</h5>
          <div className="card-text">
            {this.renderType(anime)}
            {this.renderAmountOfEpisodes(anime)}
            {this.renderOnEmision(anime)}
          </div>
          <a href={anime.urlDetails} className="btn btn-primary">See more details</a>
          <Link to={`/anime/${anime.id}`}><span className="oi oi-pencil" /></Link>
        </div>
      </div>
    );
  }

  splitAnimesOn(number) {
    const numberOfRows = Math.ceil((this.state.animes ? this.state.animes.length : 0) / number);
    const splitedAnimes = [];
    for (let i = 0; i < numberOfRows; i += 1) {
      splitedAnimes.push(this.state.animes.slice(i * number, number * (i + 1)));
    }
    return splitedAnimes;
  }

  renderAmountOfEpisodes(anime) {
    return anime.episodes !== null ? <span className="badge badge-pill badge-info badgeMargin">{anime.episodes}</span> : '';
  }

  renderOnEmision(anime) {
    if (anime.endDate !== null) {
      return <span className="badge badge-pill badge-secondary badgeMargin">Finalizado</span>;
    }
    return <span className="badge badge-pill badge-warninig badgeMargin">En emisión</span>;
  }

  renderType(anime) {
    return <span className="badge badge-pill badge-success badgeMargin">{anime.type}</span>;
  }

  render() {
    return (
      <main>
        <h1>Lista de animes</h1>
        {this.createAnimeRow()}
        <div className="fixedAdd">
          <Link to="/newAnime" className="btn btn-primary btn-circle btn-xl">+</Link>
        </div>

      </main>
    );
  }
}

export default Home;
