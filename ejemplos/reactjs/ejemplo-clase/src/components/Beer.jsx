import React from 'react';
import './Beer.css';

const Beer = ({ data }) => {
  const { id, name, description, image_url:image } = data;

  return (
    <div id={id} className="card beer-card">
      <div className="card-body">
        <div className="row">
          <div className="col-2 beer-col" style={{ textAlign: 'center' }}>
            <img src={image} alt={name} className="beer-img" />
          </div>
          <div className="col-10">
            <h5 className="card-title">{name}</h5>
            <p className="card-text">{description}</p>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Beer;