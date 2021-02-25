import React from "react";
import { View } from "react-native";
import AddNewNote from './addNewNote'
const AddNotes = ({ navigation }) => {
    return (
        <View>
            <AddNewNote navigation={navigation} />
        </View>
    );
}

export default AddNotes;