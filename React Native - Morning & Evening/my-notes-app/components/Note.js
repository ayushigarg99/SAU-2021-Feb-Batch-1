import React from "react";
import { TouchableOpacity, View, Text } from "react-native";
import AsyncStorage from '@react-native-community/async-storage';
import { StyleSheet } from "react-native";


const Note = ({ noteInfo, navigation }) => {
    const deleteNote = async (id) => {
        let noteList = JSON.parse(await AsyncStorage.getItem("notesList"));
        for (var i in noteList) {
            if (noteList[i].id == id) {
                noteList.splice(parseInt(i), 1);
            }
        }
        await AsyncStorage.setItem("notesList", JSON.stringify(noteList));
        noteList = JSON.parse(await AsyncStorage.getItem("notesList"));
        navigation.reset({
            index: 0,
            routes: [{ name: "list-notes" }],
        });
    }

    return (
        <View style={styles.lineStyle}>
            <View style={styles.detailsContainer}>
                <Text style={styles.noteTitle}> {noteInfo.note.title} </Text>
            </View>
            <Text style={styles.contentContainer}> {noteInfo.note.content} </Text>
            <TouchableOpacity onPress={() => deleteNote(noteInfo.id)} >
                    <Text style={styles.deleteBtn}>Delete</Text>
                </TouchableOpacity>

        </View>
    );
}

const styles = StyleSheet.create({
    detailsContainer: {
        flex: 1,
        flexDirection: 'row',
        flexWrap: 'wrap',
    },
    contentContainer: {
        flex: 1,
        flexWrap: 'wrap',
        borderColor: "black",
        borderStyle:  'solid',
        marginTop:20,
        padding: 5,
        marginLeft: 7,
        marginRight: 7,
        fontSize:20
    },
    noteTitle: {
        width: '60%',
        fontSize: 30,
        color: "black",
        fontWeight: "bold",
        padding: 5,
        marginLeft: 5,
        
    },
    lineStyle: {
        marginTop:10,
        width:'95%',
        borderColor: "black",
        borderStyle:  'solid',
        borderColor: "black",
        borderWidth: 3,
        borderRadius: 10,
        backgroundColor:"#f5dace",
        marginLeft:10
    },
    deleteBtn: {
        
        backgroundColor: "#ed6324",
        borderRadius: 30,
        marginLeft: 250,
        marginTop: 10,
        marginRight:10,
        padding: 5,
        textAlign: "center",
        fontWeight: "bold",
        color: "white",
        marginBottom:10,
        display:'flex'        
    }

});


export default Note;