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
View
} from 'react-native';
import {calculator, ColoredView, advanceCalculator, player} from 'example-library/src/index'
const App: () => Node = () => {
const [currentResult, setResult] = useState<number | null>(null);
const [currentResult1, setResult1] = useState<number | null>(null);
const [currentResult2, setResult2] = useState<number | null>(null);
const [currentResult3, setResult3] = useState<number | null>(null);

return (
    <SafeAreaView>
    <StatusBar barStyle={'dark-content'}/>
    <ColoredView color="#FF0099" style={{marginLeft:10, marginTop:20, width:100, height:100}}/>

    <Text style={{marginLeft:20, marginTop:20}}>3+7={currentResult ?? "??"}</Text>
    <Button title="Compute" onPress={async () => {
        const result = await calculator.add(3, 7);
        setResult(result);
    }} />

    <Text style={{marginLeft:20, marginTop:20}}>3-7={currentResult1 ?? "??"}</Text>
        <Button title="Compute" onPress={async () => {
            const result = await calculator.sub(3, 7);
            setResult1(result);
        }} />

    <Text style={{marginLeft:20, marginTop:20}}>3*7={currentResult2 ?? "??"}</Text>
        <Button title="Compute" onPress={async () => {
            const result = await calculator.mul({a:3, b:7});
            setResult2(result);
        }} />

    <Text style={{marginLeft:20, marginTop:20}}>3/7={currentResult3 ?? "??"}</Text>
        <Button title="Compute" onPress={async () => {
            const result = await advanceCalculator.div(3,7);
            setResult3(result);
        }} />

    <View style={{marginTop:20}}>
        <Button  title="Create Player" onPress={async () => {
                const result = await player?.createPlayer({
                    mediaURL: 'https://storage.googleapis.com/wvmedia/clear/h264/tears/tears.mpd',
                    mediaType: "DASH",
                    drmLicenseURL: "",
                    drmType: 'NONE'
                });
                
            }} />
    </View>

    </SafeAreaView>
);
};
export default App;