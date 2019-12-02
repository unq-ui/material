import React from 'react';
import { StyleSheet, View, Text } from 'react-native';
import { TouchableOpacity } from 'react-native-gesture-handler';
import { colors } from './styles/utils';

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

const Button = ({ text, onPress, backgroundColor=colors.pink2, color=colors.white }) => {
  return (
    <View style={{ width: '90%' }}>
      <TouchableOpacity onPress={onPress}>
        <View style={[styles.container, { backgroundColor }]}>
          <Text style={[styles.buttonText, { color }]}>{text}</Text>
        </View>
      </TouchableOpacity>

    </View>
  )
}

export default Button;
