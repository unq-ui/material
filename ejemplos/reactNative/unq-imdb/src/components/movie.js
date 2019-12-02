import React, { Component } from 'react';
import { View, Text, Image, TouchableOpacity, StyleSheet } from 'react-native';
import { IS_IOS, itemWidth, slideHeight, colors } from './styles/utils';

const styles = StyleSheet.create({
  slideInnerContainer: {
    width: itemWidth,
    height: slideHeight,
  },
  imageContainer: {
    flex: 1,
    marginBottom: IS_IOS ? 0 : -1, // Prevent a random Android rendering issue
    backgroundColor: 'transparent',
  },
  image: {
    ...StyleSheet.absoluteFillObject,
    resizeMode: 'center',
  },
  textContainer: {
    position: 'absolute',
    bottom: IS_IOS ? 20 : 12,
    width: itemWidth,
    justifyContent: 'center',
    alignItems: 'center',
    padding: 10,
    backgroundColor: colors.black,
  },
  title: {
    color: colors.white,
    fontSize: 13,
    fontWeight: 'bold',
    letterSpacing: 0.5
  },
});

export default class Movie extends Component {
  constructor(props) {
    super(props);
    this.state = {
      showTitle: false,
    };
  }

  showTitle = () => this.setState({ showTitle: true })

  goToDetails = () => {
    const { data: { title } } = this.props;
    alert(`You've clicked '${title}'`);
  }

  renderImg = (withoutTouch) => {
    const { data: { title, img } } = this.props;
    const uppercaseTitle = <Text style={styles.title}>{title.toUpperCase()}</Text>;
    const content = (
      <React.Fragment>
        <View style={styles.imageContainer}>
          <Image source={{ uri: img }} style={styles.image} />
        </View>
        {this.state.showTitle && <View style={styles.textContainer}>{uppercaseTitle}</View>}
      </React.Fragment>
    )
    return (withoutTouch ? content :
      <TouchableOpacity activeOpacity={1} style={styles.slideInnerContainer} onPress={!this.state.showTitle && this.showTitle}>
        {content}
      </TouchableOpacity>
    );
  }

  render () {
    return this.state.showTitle ? (
      <TouchableOpacity activeOpacity={1} style={styles.slideInnerContainer} onPress={this.goToDetails}>
        {this.renderImg(true)}
      </TouchableOpacity>
    ):
    this.renderImg();
  }
}