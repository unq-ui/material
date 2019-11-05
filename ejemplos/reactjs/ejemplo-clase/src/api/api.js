import axios from 'axios';

const API_URL = 'https://api.punkapi.com/v2'

export const getBeers = () => {
  return axios.get(`${API_URL}/beers`)
    .then(response => response.data)
    .catch(error => Promise.reject(error.response.data))
}