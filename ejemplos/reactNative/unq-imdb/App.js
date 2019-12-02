import { createAppContainer, createSwitchNavigator } from 'react-navigation';
import { createStackNavigator } from 'react-navigation-stack';

import AuthenticatorScreen from './src/screens/AuthenticatorScreen';
import LoginScreen from './src/screens/auth/LoginScreen';
import RegisterScreen from './src/screens/auth/RegisterScreen';

import HomeScreen from './src/screens/home/HomeScreen';
import SearchScreen from './src/screens/home/SearchScreen';


const AppStack = createStackNavigator({ Home: HomeScreen, Search: SearchScreen });
const AuthStack = createStackNavigator({ Login: LoginScreen, Register: RegisterScreen });

export default createAppContainer(
  createSwitchNavigator(
    {
      AuthLoading: AuthenticatorScreen,
      App: AppStack,
      Auth: AuthStack,
    },
    {
      initialRouteName: 'AuthLoading',
    }
  )
);
