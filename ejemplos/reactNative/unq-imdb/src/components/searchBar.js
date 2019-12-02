
import React from 'react';
import { StyleSheet, View } from 'react-native';

import Input from './input';

const styles = StyleSheet.create({
  container: {
    justifyContent: 'center',
    alignItems: 'center',
    paddingTop: 15,
  },
})

const SearchBar = ({ onChange, value, onSubmit }) => (
  <View style={styles.container}>
    <Input value={value} placeholder="Search..." onChange={onChange} onSubmit={onSubmit} />
  </View>
)

export default SearchBar;
