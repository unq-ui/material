import React, { useState } from 'react';
import { StyleSheet, TextInput, View } from 'react-native';
import Line from './line';
import { colors } from './styles/utils';

const styles = StyleSheet.create({
  container: {
    height: 50,
    width: '90%',
    paddingHorizontal: 5,
    justifyContent: "flex-end",
    alignContent: 'center',
    paddingBottom: 5,
    marginBottom: 15,
    backgroundColor: colors.grey2,
  },
  inputContainer: {
    height: 35,
    width: '80%',
    paddingHorizontal: 10,
  },
  input: {
    fontSize: 20,
    color: colors.grey,
  },
  inputFocus: {
    color: colors.white,
  },
});

const Input = ({ placeholder, onChange, value, password = false, onSubmit = () => {} }) => {
  const [focus, setFocus] = useState(false)
  return (
    <View style={styles.container}>
      <View style={styles.inputContainer}>
        <TextInput
          onFocus={() => setFocus(true)}
          onEndEditing={() => setFocus(false)}
          placeholder={placeholder}
          style={[styles.input, focus && styles.inputFocus]}
          value={value}
          onChangeText={onChange}
          secureTextEntry={!!password}
          onSubmitEditing={onSubmit}
        />
      </View>
      <Line focus={focus} />
    </View>
  )
}

export default Input;
