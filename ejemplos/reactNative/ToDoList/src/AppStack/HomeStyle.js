import { StyleSheet } from 'react-native';
import Utilities from '../helpers/Utilities';

export default StyleSheet.create({
  headerContainer: {
    height: 30,
    justifyContent: 'center',
    alignContent: 'center',
    flexDirection: 'row',
  },
  headerIconContainer: {
    width: Utilities.widthPercentageToDP(15),
    alignItems: 'center',
  },
  headerTitleContainer: {
    width: Utilities.widthPercentageToDP(70),
    alignItems: 'center',
  },
  headerText: {
    fontSize: 22,
  },

  container: {
    width: Utilities.widthPercentageToDP(100),
    height: Utilities.heightPercentageToDP(100),
    backgroundColor: 'white',
  },
  emptyListContainer: {
    justifyContent: 'center',
    alignItems: 'center',
    height: Utilities.heightPercentageToDP(80),
  },

  toDoContainer: {
    backgroundColor: 'white',
    height: Utilities.heightPercentageToDP(15),
    paddingTop: 10,
  },
  toDoTimeContainer: {
    flex: 1,
    flexDirection: 'row',
    justifyContent: 'center',
    paddingBottom: 4,
  },
  toDoTextContainer: {
    width: Utilities.widthPercentageToDP(85),
    flexWrap: 'wrap',
  },
  toDoTitle: {
    fontSize: 20,
    fontWeight: 'bold',
    color: '#707070',
  },

  hiddenRowContainer: {
    position: 'absolute',
    right: 0,
    flexDirection: 'row',
  },
  hiddenRowButton: {
    width: 75,
    alignItems: 'center',
    justifyContent: 'center',
    height: Utilities.heightPercentageToDP(15),
  },
  firstButton: {
    backgroundColor: 'red',
  },
  secondButton: {
    backgroundColor: 'blue',
  },
  separator: {
    alignSelf: 'flex-end',
    width: Utilities.widthPercentageToDP(90),
    height: 1,
    backgroundColor: '#DADADA',
  },
});
