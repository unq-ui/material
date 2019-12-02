import React from 'react';
import Carousel from 'react-native-snap-carousel';
import { View } from 'react-native';

import Movie from './movie';
import Title from './title';
import SeeMore from './SeeMore';
import { sliderWidth, itemWidth } from './styles/utils';

renderMovie = genre => ({ item, index }) => {
  if (!item.seeMore) {
    return <Movie id={`movie_${genre}_${index}`} data={item} />;
  }
  return <SeeMore genre={genre} />;
};

const CarouselMovies = ({ item: { genre, list } }) => {
  const data = [...list, { seeMore: true }];
  return (
    <View style={{ paddingTop: 20 }}>
      <Title text={genre} />
      <Carousel
        data={data}
        renderItem={this.renderMovie(genre)}
        sliderWidth={sliderWidth}
        itemWidth={itemWidth}
        useScrollView={true}
      />
    </View>
  )
}

export default CarouselMovies;
