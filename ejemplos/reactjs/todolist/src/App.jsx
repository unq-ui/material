import React from 'react';

import Navbar from './Navbar';
import AddTODO from './AddTODO';
import ListTODO from './ListTODO';

export default class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      list: [
        {
          text: 'Pasando a la década de 1960, el Lorem Ipsum fue popularizado por el fabricante de tipografía Letraset, que lo utilizó en sus campañas publicitarias.Letraset ofrecía páginas de Lorem Ipsum como hojas de transferencia, que fueron ampliamente utilizadas en la era anterior a los ordenadores para los diseños.Estas páginas de transferencia, conocidas como Letraset Body Type, se incluyeron en la publicidad de la compañía y en su popular catálogo.',
        },
        {
          text: 'Pasando a la década de 1960, el Lorem Ipsum fue popularizado por el fabricante de tipografía Letraset, que lo utilizó en sus campañas publicitarias.Letraset ofrecía páginas de Lorem Ipsum como hojas de transferencia, que fueron ampliamente utilizadas en la era anterior a los ordenadores para los diseños.Estas páginas de transferencia, conocidas como Letraset Body Type, se incluyeron en la publicidad de la compañía y en su popular catálogo.',
        },
        {
          text: 'Pasando a la década de 1960, el Lorem Ipsum fue popularizado por el fabricante de tipografía Letraset, que lo utilizó en sus campañas publicitarias.Letraset ofrecía páginas de Lorem Ipsum como hojas de transferencia, que fueron ampliamente utilizadas en la era anterior a los ordenadores para los diseños.Estas páginas de transferencia, conocidas como Letraset Body Type, se incluyeron en la publicidad de la compañía y en su popular catálogo.',
        },
      ],
    };

    this.deleteElemList = this.deleteElemList.bind(this);
    this.editElemList = this.editElemList.bind(this);
    this.addElemList = this.addElemList.bind(this);
  }

  editElemList(index, newText) {
    this.setState(prevState => ({
      list: prevState.list.map((text, i) => (i === index ? { text: newText } : text)),
    }));
  }

  deleteElemList(index) {
    this.setState(prevState => ({
      list: prevState.list.filter((text, i) => i !== index),
    }));
  }

  addElemList(text) {
    this.setState(prevState => ({ list: [...prevState.list, { text }] }));
  }

  render() {
    return (
      <div>
        <Navbar />
        <div className="container">
          <AddTODO addElemList={this.addElemList} />
          <ListTODO
            elems={this.state.list}
            editElemList={this.editElemList}
            deleteElemList={this.deleteElemList}
          />
        </div>
      </div>
    );
  }
}
