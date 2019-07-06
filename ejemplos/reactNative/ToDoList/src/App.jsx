import React from 'react';
import { View, Button } from 'react-native';
import { createSwitchNavigator, createStackNavigator } from 'react-navigation';

import Root from './Root';
import Home from './AppStack/Home';
import SignIn from './LoginStack/SignIn';

const ToDo = props => (
  <View>
    <Button title="goToHome" onPress={() => props.navigation.navigate('Home')} />
  </View>
);

const AppStack = createStackNavigator({ Home, ToDo });
const AuthStack = createStackNavigator({ SignIn });

export default createSwitchNavigator(
  {
    AuthLoading: Root,
    App: AppStack,
    Auth: AuthStack,
  },
  {
    initialRouteName: 'AuthLoading',
  },
);
