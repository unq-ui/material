import React from 'react';
import { View, StyleSheet } from 'react-native';
import { FlatList } from 'react-native-gesture-handler';
import { SafeAreaView } from 'react-navigation';

import Api from '../../resources/Api';
import Loading from '../../components/loading';
import CarouselMovies from '../../components/CarouselMovies';
import SearchBar from '../../components/searchBar';
import Loguot from '../../components/logout';
import { colors } from '../../components/styles/utils';

class HomeScreen extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      data: [],
      loading: true,
      search: '',
    };
  }

  static navigationOptions = {
    title: "Unq-Imdb",
    headerRight: () => <Loguot />,
    headerStyle: {
      backgroundColor: colors.pink2,
    },
    headerTintColor: colors.white,
    headerTitleStyle: {
      color: colors.white,
    },
  };

  componentDidMount() {
    Api.getTop()
      .then(data => this.setState({ data, loading: false }));
  }

  onSearch = () => {
    const text = this.state.search;
    this.setState({ search: '' }, () => this.props.navigation.push('Search', { text }));
  }

  renderContent() {
    const { loading, data } = this.state;
    if (loading) {
      return <Loading />;
    }
    return (
      <React.Fragment>
        <SearchBar onChange={search => this.setState({ search })} value={this.state.search} onSubmit={this.onSearch} />
        <FlatList
          data={data}
          renderItem={CarouselMovies}
          keyExtractor={item => item.genre}
          showsVerticalScrollIndicator={false}
        />
      </React.Fragment>
    );
  }

  render() {
    return (
      <SafeAreaView style={styles.safeArea}>
        <View style={styles.container}>
          {this.renderContent()}
        </View>
      </SafeAreaView>
    );
  }
}

const styles = StyleSheet.create({
  safeArea: {
    backgroundColor: colors.grey3,
  },
  container: {
    width: '100%',
    height: '100%',
    backgroundColor: colors.grey3,
  },
  container2: {
    paddingTop: 15,
    width: '100%',
  }
});


export default HomeScreen;
