import API from '../service/api';
import Home from './Home';

export default class Search extends Home {
  componentDidMount() {
    this.searchAnimes(this.props.match.params.text);
  }

  componentWillReceiveProps(nextProps) {
    // Se agrega este mensaje dado que si se quiere realizar una nueva busqueda
    // en la pantalla de search no vuelve a ejecutar el componentDidMount dado que ya esta montado.
    this.searchAnimes(nextProps.match.params.text);
  }

  searchAnimes(text) {
    API.get(`/animes/${text}`)
      .then(response => this.setState({ animes: response.data }))
      .catch(console.log);
  }
}
