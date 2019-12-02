import React from 'react';
import { StyleSheet, ActivityIndicator, View } from 'react-native';

const styles = StyleSheet.create({
  loadingContainer: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  loading: {
    borderBottomColor: '#1e1e1e',
    borderBottomWidth: 1,
  }
})

const Loading = () => (
  <View style={styles.loadingContainer}>
    <ActivityIndicator />
  </View>
)

export default Loading;
