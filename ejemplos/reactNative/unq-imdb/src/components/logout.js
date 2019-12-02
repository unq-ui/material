import React from 'react';
import { StyleSheet, Text } from 'react-native';
import { TouchableOpacity } from 'react-native-gesture-handler';
import { withNavigation } from 'react-navigation';

import Storage from '../resources/Storage';

const styles = StyleSheet.create({
  container: {
    height: 50,
    padding: 5,
    justifyContent: 'center',
    alignItems: 'center',
    marginBottom: 10,
  },
  buttonText: {
    fontSize: 23,
  },
})

const Logout = ({ navigation }) => {
  return (
    <TouchableOpacity onPress={() => Storage.removeUserToken().then(() => navigation.navigate('Auth'))}>
      <Text>Logout</Text>
    </TouchableOpacity>
  )
}

export default withNavigation(Logout);
