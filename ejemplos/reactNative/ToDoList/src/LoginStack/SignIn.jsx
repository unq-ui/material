import React from 'react';
import { View, TextInput, StyleSheet, TouchableOpacity, SafeAreaView, Text } from 'react-native';

import Utilities from '../helpers/Utilities';
import api from '../api/api';

const styles = StyleSheet.create({
  container: {
    width: Utilities.widthPercentageToDP(100),
    height: Utilities.heightPercentageToDP(100),
    paddingTop: 200,
  },

  separator: {
    height: 1,
    backgroundColor: '#DADADA',
  },
});


export default class SignIn extends React.Component {
  static navigationOptions = () => ({
    header: null,
  });

  constructor(props) {
    super(props);
    this.state = {
      username: '',
      password: '',
      error: null,
    };
    this.executeLogin = this.executeLogin.bind(this);
  }

  executeLogin() {
    const { username, password } = this.state;
    api.signIn({ username, password })
      .then(() => this.props.navigation.navigate('App'))
      .catch(console.log);
  }

  render() {
    return (
      <SafeAreaView style={{ backgroundColor: 'white' }}>
        <View style={{ marginTop: 20, padding: 15, backgroundColor: 'white', height: Utilities.heightPercentageToDP(100) }}>
          <View style={{ marginBottom: 15 }}>
            <TextInput
              autoCapitalize="none"
              style={{ height: Utilities.heightPercentageToDP(6) }}
              value={this.state.username}
              placeholder="Username"
              onChangeText={username => this.setState({ username })}
            />
            <View style={styles.separator} />
          </View>
          <View>
            <TextInput
              style={{ height: Utilities.heightPercentageToDP(6) }}
              secureTextEntry
              autoCapitalize="none"
              value={this.state.password}
              placeholder="Password"
              onChangeText={password => this.setState({ password })}
            />
            <View style={styles.separator} />
          </View>
          <TouchableOpacity onPress={this.executeLogin}>
            <View style={{ marginTop: 15, padding: 15, backgroundColor: '#6620C9', justifyContent: 'center', alignItems: 'center' }}>
              <Text style={{ color: 'white' }}>Sign In</Text>
            </View>
          </TouchableOpacity>

          <TouchableOpacity onPress={() => console.warn('TODO: goTo Create Account')}>
            <View style={{ justifyContent: 'center', alignItems: 'center', marginTop: 15 }}>
              <Text style={{ color: '#DADADA' }}>or</Text>
              <Text style={{ color: '#DADADA' }}>Sign Up</Text>
            </View>
          </TouchableOpacity>
          { this.state.error && <View><Text>{this.state.error}</Text></View>}
        </View>
      </SafeAreaView>
    );
  }
}
