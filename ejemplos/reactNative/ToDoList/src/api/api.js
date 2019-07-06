import axios from 'axios';
import { AsyncStorage } from 'react-native';
import Config from 'react-native-config';

const server = `http://${Config.HOST}:7000`;

const request = (type, path, body) => axios
  .request({ url: `${server}${path}`, method: type, data: body })
  .then(req => req.data);

export default {
  signIn: body => request('post', '/login', body).then(userId => AsyncStorage.setItem('userId', userId)),
  getTodos: userId => request('get', `/${userId}/todos`),
  removeUser: () => AsyncStorage.removeItem('userId'),
};
