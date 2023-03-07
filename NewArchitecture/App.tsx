/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */
import React from 'react';
import {useState} from "react";
import type {Node} from 'react';
import {
SafeAreaView,
StatusBar,
Text,
Button,
} from 'react-native';
import {calculator, ColoredView} from 'example-library/src/index'
const App: () => Node = () => {
const [currentResult, setResult] = useState<number | null>(null);
return (
    <SafeAreaView>
    <StatusBar barStyle={'dark-content'}/>
    <ColoredView color="#FF0099" style={{marginLeft:10, marginTop:20, width:100, height:100}}/>

    <Text style={{marginLeft:20, marginTop:20}}>3+7={currentResult ?? "??"}</Text>
    <Button title="Compute" onPress={async () => {
        const result = await calculator.add(3, 7);
        setResult(result);
    }} />


    </SafeAreaView>
);
};
export default App;