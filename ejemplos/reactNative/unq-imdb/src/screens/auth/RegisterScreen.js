import React from 'react';
import { StyleSheet, Image, View } from 'react-native';
import { SafeAreaView } from 'react-navigation';

import Input from '../../components/input';
import Button from '../../components/button';
import ErrorText from '../../components/errorText';
import Icon from './Icon';

import Api from '../../resources/Api';
import Storage from '../../resources/Storage';
import { colors } from '../../components/styles/utils';

export default class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      username: '',
      password: '',
      error: '',
    }
  }

  static navigationOptions = {
    title: 'Register',
    headerStyle: {
      backgroundColor: colors.pink2,
    },
    headerTintColor: colors.white,
    headerTitleStyle: {
      color: colors.white,
    },
  };

  updateField = field => value => this.setState({ [field]: value, error: '' });

  goToRegister = () => this.props.navigation.push('Register');

  executeRegister = () => {
    const { username, password } = this.state;
    Api.register({ username, password })
      .then(() => Storage.setUser(username))
      .then(() => this.props.navigation.navigate('App'))
      .catch(({ message }) => this.setState({ error: message }))
  }

  render() {
    return (
      <SafeAreaView style={styles.safeArea}>
        <View style={styles.container}>
          <View style={styles.logoContainer}>
            <Image source={{ uri: Icon }} style={styles.image} />
          </View>
          <View style={styles.inputsContainer}>
            <Input placeholder="Email" value={this.state.username} onChange={this.updateField('username')} />
            <Input placeholder="Password" value={this.state.password} onChange={this.updateField('password')} password />
            {!!this.state.error && <ErrorText text={this.state.error} />}
          </View>
          <View style={styles.buttonContainer}>
            <Button text="Register" onPress={this.executeRegister} />
          </View>
        </View>
      </SafeAreaView>
    );
  }
}

const styles = StyleSheet.create({
  safeArea: {
    backgroundColor: colors.grey3,
  },
  container: {
    width: '100%',
    height: '100%',
    backgroundColor: colors.grey3,
  },
  logoContainer: {
    flex: 2,
    alignItems: 'center',
    justifyContent: 'center',
  },
  inputsContainer: {
    flex: 1.5,
    alignItems: 'center',
    justifyContent: 'flex-start',
  },
  buttonContainer: {
    flex: 1.5,
    alignItems: 'center',
    justifyContent: 'center',
  },
  image: {
    resizeMode: 'center',
    width: 400,
    height: 400,
  },
});
