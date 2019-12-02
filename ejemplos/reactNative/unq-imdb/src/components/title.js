import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { colors } from './styles/utils';

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'flex-start',
    paddingStart: 15,
  },
  title: {
    fontSize: 25,
    color: colors.white,
  }
})

const Title = ({ text }) => <View style={styles.container}><Text style={styles.title}>{text}</Text></View>

export default Title;
