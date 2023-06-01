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
import Slider from '@react-native-community/slider';
import {calculator, ColoredView} from 'example-library/src/index'
const App: () => Node = () => {
const [currentResult, setResult] = useState<number | null>(null);
const [currentResult1, setResult1] = useState<number | null>(null);
const [currentResult2, setResult2] = useState<number | null>(null);
const [sliderValue, setSliderValue] = useState(0);
return (
    <SafeAreaView>
    <StatusBar barStyle={'dark-content'}/>

    <Slider
  style={{width: "100%", height: 40, marginTop:100}}
  minimumValue={0}
  maximumValue={100}
  minimumTrackTintColor="#307ecc"
  maximumTrackTintColor="#000000"
  step={1}
  value={sliderValue}
onValueChange={
(sliderValue) => {setSliderValue(sliderValue)
console.log("shagun", sliderValue)
}
}
/>

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


    </SafeAreaView>
);
};
export default App;