import { AsyncStorage } from 'react-native';

export default {
  setUser: (username) => AsyncStorage.setItem('userToken', username),
  getUser: () => AsyncStorage.getItem('userToken'),
  removeUserToken: () => AsyncStorage.removeItem('userToken'),
};
