import React from 'react';
import { View, TouchableOpacity, Text, AsyncStorage } from 'react-native';
import { SwipeListView } from 'react-native-swipe-list-view';

import api from '../api/api';
import styles from './HomeStyle';

export default class Home extends React.Component {
  static navigationOptions = ({ navigation }) => ({
    headerTitle: 'ToDo\'s',
    headerRight: (
      <TouchableOpacity onPress={() => navigation.push('ToDo')}>
        <View style={{ paddingRight: 15 }}>
          <Text>+</Text>
        </View>
      </TouchableOpacity>
    ),
    headerLeft: (
      <TouchableOpacity onPress={() => api.removeUser().then(() => navigation.navigate('AuthLoading'))}>
        <View style={{ paddingLeft: 15 }}>
          <Text>LogOut</Text>
        </View>
      </TouchableOpacity>
    ),
  });

  constructor(props) {
    super(props);
    this.state = {
      user: {
        todos: [],
      },
      error: null,
    };
    this.bind();
  }

  componentDidMount() {
    AsyncStorage.getItem('userId')
      .then(userId => api.getTodos(userId))
      .then(user => this.setState({ user }))
      .catch(error => this.setState({ error: error.title }));
  }

  bind() {
    this.renderToDo = this.renderToDo.bind(this);
    this.renderHiddenRow = this.renderHiddenRow.bind(this);
  }

  renderToDo(elem) {
    const toDo = elem.item;
    return (
      <View style={styles.toDoContainer}>
        <View style={styles.toDoTimeContainer}>
          <View style={{ padding: 5 }}>
            <Text>{toDo.time}</Text>
          </View>
          <View style={styles.toDoTextContainer}>
            <Text style={styles.toDoTitle}>{toDo.title}</Text>
            <Text>{toDo.description}</Text>
          </View>
        </View>
        <View style={styles.separator} />
      </View>
    );
  }

  renderHiddenRow(elem) {
    return (
      <View style={styles.hiddenRowContainer}>
        <TouchableOpacity onPress={() => console.warn(`TODO: Go to edit ${elem.item.id}`)}>
          <View style={[styles.hiddenRowButton, styles.firstButton]}>
            <Text>Edit</Text>
          </View>
        </TouchableOpacity>
        <TouchableOpacity onPress={() => console.warn(`TODO: Delete ${elem.item.id}`)}>
          <View style={[styles.hiddenRowButton, styles.secondButton]}>
            <Text>Delete</Text>
          </View>
        </TouchableOpacity>
      </View>
    );
  }

  renderEmptyList() {
    return (
      <View style={styles.emptyListContainer}>
        <Text>T_T</Text>
      </View>
    );
  }

  render() {
    if (this.state.error) {
      return (
        <View style={styles.container}>
          <View style={styles.emptyListContainer}>
            <Text>Error - {this.state.error}</Text>
          </View>
        </View>
      );
    }
    return (
      <View style={styles.container}>
        <SwipeListView
          useFlatList
          data={this.state.user.todos}
          renderItem={this.renderToDo}
          renderHiddenItem={this.renderHiddenRow}
          rightOpenValue={-152}
          keyExtractor={elem => elem.id}
          ListEmptyComponent={this.renderEmptyList}
        />
      </View>
    );
  }
}
