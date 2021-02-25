import React, { useState, useEffect } from "react";
import { View, TextInput, Text,Button } from "react-native";
import AsyncStorage from '@react-native-community/async-storage';
import { StyleSheet } from "react-native";


const Login = ({ navigation }) => {

    const [userName, setUserName] = useState("");

    useEffect(() => {
        checkAuthentication();
    }, []);

    const checkAuthentication = async () => {
        const User = await AsyncStorage.getItem("userName");
        
        if (User) {
                navigation.reset({
                index: 0,
                routes: [{ name: "list-notes" }],
            });
            
        }
        return;
    }

    

    const loginAccept = async () => {
        await AsyncStorage.setItem("userName", userName);
        
        navigation.reset({
            index: 0,
            routes: [{ name: "list-notes" }],
        });
    }
    return (
        

        <View style={styles.container}>
            <Text style={styles.loginTextStyle}>Login</Text>
            <TextInput onChangeText={(text)=> setUserName(text)} style={styles.textInputStyle} placeholder="enter username..."/>
            <TextInput style={styles.textInputStyle} placeholder="enter password..."/>
            <View style={styles.btn}>
            <Button title="Log in" onPress={loginAccept} />
            </View>
            
        </View>
    )
};

const styles = StyleSheet.create({
    container: {
        height: "100%",
        justifyContent: 'flex-start',
        alignSelf: 'center',
    },
    textInputStyle: {
        borderColor: "black",
        borderWidth: 2,
        borderRadius:0,
        fontSize: 30,
        padding: 5,
        width: "100%",
        marginBottom: 20,

    },
    loginTextStyle: {
        paddingLeft:50,
        paddingBottom:40,
        fontSize: 50,
        fontWeight: "bold",
        marginVertical: 20,
        justifyContent:'center',
        color:'black'
    },
    btn: {
        padding: 5,
        margin: 3,
        backgroundColor: '#2196F3',
        borderRadius: 16,
        width: "60%",
        alignSelf: "center",
    },
    btnText: {
        color: "black",
        fontWeight: "bold",
        textAlign: "center"
    }
});

export default Login;