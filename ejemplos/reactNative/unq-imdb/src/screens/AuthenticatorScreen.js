import React from 'react';
import { ActivityIndicator, StatusBar } from 'react-native';
import { SafeAreaView } from 'react-navigation';
import Storage from '../resources/Storage';

const AuthLoadingScreen = (props) => {
  Storage.getUser()
    .then(userToken => props.navigation.navigate(userToken ? 'App' : 'Auth'))
    .catch(() => props.navigation.navigate('Auth'));

  return (
    <SafeAreaView>
      <ActivityIndicator />
      <StatusBar barStyle="default" />
    </SafeAreaView>
  )
}

export default AuthLoadingScreen;