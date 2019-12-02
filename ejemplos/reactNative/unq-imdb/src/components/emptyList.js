import React from 'react';
import { View, Text } from 'react-native';
import { colors } from './styles/utils';

const EmptyList = ({ text }) => <View><Text style={{ color: colors.pink }}>{`Not found any result of ${text}`}</Text></View>

export default EmptyList;
