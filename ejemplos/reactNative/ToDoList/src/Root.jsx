import React from 'react';
import { ActivityIndicator, View, AsyncStorage } from 'react-native';
import Utilities from './helpers/Utilities';

export default class App extends React.Component {
  componentDidMount() {
    AsyncStorage.getItem('userId')
      .then(userId => this.props.navigation.navigate(userId ? 'App' : 'Auth'))
      .catch(() => this.props.navigation.navigate('Auth'));
  }

  render() {
    return (
      <View style={{ height: Utilities.heightPercentageToDP(90), justifyContent: 'center', alignItems: 'center' }}>
        <ActivityIndicator color="#6620C9" />
      </View>
    );
  }
}
