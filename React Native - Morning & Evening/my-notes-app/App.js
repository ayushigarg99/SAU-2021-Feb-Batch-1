import React from 'react';
import { StyleSheet } from 'react-native';
import { createStackNavigator } from '@react-navigation/stack';
import { NavigationContainer } from '@react-navigation/native';

import Login from './components/login';
import ListNotes from './components/listNotes';
import AddNotes from './components/addNotes';

const Stack = createStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="login" component={Login} options={{ title: "Login Page" }} />
        <Stack.Screen name="list-notes" component={ListNotes} options={{ title: "My Notes" }} />
        <Stack.Screen name="add-notes" component={AddNotes} options={{ title: "Add New Note" }} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#5D6D7E',
    alignItems: 'center',
    justifyContent: 'center',
  },
});

