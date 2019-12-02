import React from 'react';
import { View, StyleSheet } from 'react-native';
import { FlatList } from 'react-native-gesture-handler';
import { SafeAreaView } from 'react-navigation';

import Api from '../../resources/Api';
import Loading from '../../components/loading';
import SearchBar from '../../components/searchBar';
import Movie from '../../components/movie';
import EmptyList from '../../components/emptyList';
import { colors } from '../../components/styles/utils';

class SearchScreen extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      loading: true,
      search: props.navigation.getParam('text'),
    };
  }

  static navigationOptions = {
    title: "Search",
    headerStyle: {
      backgroundColor: colors.pink2,
    },
    headerTintColor: colors.white,
    headerTitleStyle: {
      color: colors.white,
    },
  };

  search = () => {
    this.setState({ loading: true }, () => {
      Api.search(this.state.search)
        .then(data => this.setState({ data, loading: false }));
    });
  }

  componentDidMount() {
    this.search();
  }

  renderMovie = ({ item }) => <Movie id={`movie_${item.id}`} data={item} />

  renderContent() {
    const { loading, data } = this.state;
    if (loading) {
      return <Loading />;
    }
    return (
      <React.Fragment>
        <FlatList
          contentContainerStyle={{ alignSelf: 'center' }}
          data={data}
          renderItem={this.renderMovie}
          keyExtractor={item => `movie_${item.id}`}
          ListEmptyComponent={() => <EmptyList text={this.state.search} />}
        />
      </React.Fragment>
    );
  }

  render() {
    return (
      <SafeAreaView style={styles.safeArea}>
        <View style={styles.container}>
          <SearchBar onChange={search => this.setState({ search })} value={this.state.search} onSubmit={this.search} />
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

export default SearchScreen;
