// eslint-disable-next-line import/no-extraneous-dependencies
import Reactotron from 'reactotron-react-native';
import Config from 'react-native-config';

Reactotron
  .configure({ host: `${Config.HOST}` })
  .useReactNative()
  .connect();

console.log = Reactotron.log;
