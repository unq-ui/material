import React from 'react';
import { StyleSheet, View } from 'react-native';
import { colors } from './styles/utils';

const styles = StyleSheet.create({
  line: {
    borderBottomColor: colors.grey,
    borderBottomWidth: 1,
  },
  lineFocus: {
    borderBottomColor: colors.white,
  },
})

const Line = ({ focus }) => <View style={[styles.line, focus && styles.lineFocus]} />

export default Line;
