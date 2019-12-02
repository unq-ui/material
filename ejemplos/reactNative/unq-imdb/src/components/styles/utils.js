import { Dimensions, Platform } from 'react-native';

export const IS_IOS = Platform.OS === 'ios';
const { width: viewportWidth, height: viewportHeight } = Dimensions.get('window');

function wp (percentage) {
    const value = (percentage * viewportWidth) / 100;
    return Math.round(value);
}

export const slideHeight = viewportHeight * 0.26;
const slideWidth = wp(75);
const itemHorizontalMargin = wp(2);

export const sliderWidth = viewportWidth;
export const itemWidth = slideWidth + itemHorizontalMargin * 2;


export const colors = {
    black: "#000000",
    grey3: "#282722",
    grey2: "#6C6C6A",
    grey: "#C0C0C0",
    white: "#FFFFFF",
    pink: "#C9646A",
    pink2: "#B82C36",
    red: "#53121A",
    red2: "#3F0F14",
    red3: "#2E100E",
}