import React, { useState } from "react";
import { Text,TextInput, View,Button } from "react-native";
import AsyncStorage from '@react-native-community/async-storage';
import { StyleSheet } from "react-native";
import { Dimensions } from 'react-native';

const AddNewNote = ({ navigation }) => {
    
    const [noteTitle, setNoteTitle] = useState("");
    const [noteContent, setNoteContent] = useState("");

    const submit = async () => {
        var updatedList = JSON.parse(await AsyncStorage.getItem("notesList"));
        var newNote = {
            "title": noteTitle,
            "content": noteContent
        }
        if (updatedList === null) {
            updatedList = [{id: "1",note: newNote,}]
        } 
        else {
            let nextId = updatedList.length + 1;
            updatedList.push({id: nextId,note: newNote,})
        }
        await AsyncStorage.setItem('notesList', JSON.stringify(updatedList));
        navigation.goBack();
    }
    return (
        <View style={styles.container}>
            <TextInput style={styles.titleTextStyle} placeholder="Add Title" onChangeText={setNoteTitle} />
            <TextInput multiline style={styles.contentTextStyle} placeholder="Add Description" onChangeText={setNoteContent} />
            <View style={styles.btn}>
            <Text title="Add Note" onPress={submit} style={styles.btnText}>Add Note</Text>
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        height: Dimensions.get("window").height * 0.8,
        width: Dimensions.get('window').width * 0.9,
        justifyContent: "flex-start",
        alignSelf: "center"
    },
    titleTextStyle: {
        fontSize: 23,
        fontWeight: "bold",
        borderColor: "black",
        borderWidth: 3,
        borderRadius: 10,
        padding: 10,
        width: "95%",
        marginTop:20,
        backgroundColor:"#dfe7f5",
        marginLeft:10
    },
    contentTextStyle: {
        borderColor: "black",
        borderWidth: 3,
        borderRadius: 10,
        fontSize: 18,
        padding: 5,
        width: "95%",
        height:Dimensions.get('window').height * 0.3,
        marginVertical: 10,
        backgroundColor:"#dfe7f5",
        marginLeft:10
    },

    btn: {
        alignContent:"center",
        alignSelf:"center",
        padding: 20,
        margin: 3,
        backgroundColor: '#0ba6ff',
        borderRadius: 60,
        width: Dimensions.get('window').width * 0.5,
    },
    btnText: {
        color: "white",
        fontWeight: "bold",
        textAlign: "center",
        fontSize:20
    }
});

export default AddNewNote;