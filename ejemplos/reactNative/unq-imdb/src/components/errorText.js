import React from 'react';
import { StyleSheet, Text } from 'react-native';
import { colors } from './styles/utils';

const styles = StyleSheet.create({
  line: {
    color: colors.pink,
    fontSize: 15,
  }
})

const ErrorText = ({ text }) => <Text style={styles.line}>{text}</Text>

export default ErrorText;
