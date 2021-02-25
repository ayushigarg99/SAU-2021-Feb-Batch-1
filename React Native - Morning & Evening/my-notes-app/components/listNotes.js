import React, { useEffect, useState } from "react";
import { View, ScrollView, Text, Button} from "react-native";
import AsyncStorage from "@react-native-community/async-storage";
import { useIsFocused } from "@react-navigation/native";
import Note from "./Note";
import { StyleSheet } from "react-native";
import { Dimensions } from "react-native";

const ListNotes = ({ navigation }) => {

    const isFocused = useIsFocused();
    useEffect(() => {
        getNotes();
    }, [isFocused])

    const [notesList, setNotesList] = useState([]);
    const addNotes = () => {
        navigation.navigate("add-notes");
    }

    const getNotes = async () => {
        var allnotes = await AsyncStorage.getItem("notesList");
        if (allnotes !== null) {
            allnotes = JSON.parse(allnotes);
        }
        setNotesList(allnotes);

    }
    
    return (

        <View style={styles.container}>




            {
                notesList ?
                    <ScrollView style={styles.scrollView}>
                        {
                            (notesList.map((item, index) =><Note id={index} noteInfo={item} navigation={navigation}/>))
                        }
                    </ScrollView>
                    :
                    <View styles={styles.emptyContainer}>
                        <Text style={styles.emptySpacer}></Text>
                        <Text style={styles.emptyText}>
                            No Notes Currently! Add New Notes...
                            </Text>
                    </View>
            }
            
                <View style={styles.btn}>
                    <Text title="Add Note" onPress={addNotes} style={styles.btnText}>Add Note</Text>
                </View>
            
           
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        height: Dimensions.get("window").height,
    },
    scrollView: {
        marginBottom: Dimensions.get("window").height * 0.01
    },
    floatingButton: {
        flex: 1,
        justifyContent: 'flex-end'
    },
    btn: {
        position: 'relative',
        width: 50,
        height: 50,
        alignItems: 'center',
        justifyContent: 'center',
        right: 30,
        bottom: 10,
    },
    btnText: {
        color: "blue",
        fontWeight: "bold",
        textAlign: "center"
    },
    FloatingButtonStyle: {
        resizeMode: 'contain',
        width: 50,
        height: 50,
    },
    lineStyle: {
        borderWidth: 0.5,
        borderColor: 'black',
        margin: 10,
    },
    emptyContainer: {
        height: "100%",
        justifyContent: "center",
        alignSelf: "center",
    },
    emptyText: {
        paddingTop: Dimensions.get("window").height*0.1,
        color: "blue",
        fontSize:30,
        fontWeight: "bold",
        textAlign: "center"
    },
    btn: {
        alignContent:"center",
        alignSelf:"center",
        padding: 20,
        margin: 3,
        backgroundColor: '#0ba6ff',
        borderRadius: 60,
        width: Dimensions.get('window').width * 0.5,
        marginBottom:20
    },
    btnText: {
        color: "white",
        fontWeight: "bold",
        textAlign: "center",
        fontSize:20
    }
});

export default ListNotes;