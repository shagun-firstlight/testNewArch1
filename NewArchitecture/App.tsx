/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */
import React from 'react';
import type {Node} from 'react';
import {
SafeAreaView,
StatusBar,
Button,
View
} from 'react-native';
import {useState} from "react";

import {player, QpNxgPlaybackView} from 'example-library'
import {MediaTypeValue, DrmTypeValue} from 'example-library/src/newArch/NativePlayer'
const App: () => Node = () => {
    const [playerID, setPlayerID] = useState<number | null>(null);

return (
    <SafeAreaView>
    <StatusBar barStyle={'dark-content'}/>
    <Button  title="Create Player" onPress={async () => {
             let a = await player.initWithConfig({
                mediaURL: 'https://storage.googleapis.com/wvmedia/clear/h264/tears/tears.mpd',
                mediaType: MediaTypeValue.DASH,
                drmLicenseURL: "",
                drmType: DrmTypeValue.NONE
            });
            console.log("shagun", a)
            setPlayerID(a);
            
        }} />
        <Button  title="play" onPress={async () => {
            await player.play();
        }} />
        <Button  title="pause" onPress={async () => {
            await player.pause();
        }} />

<View style= {{marginLeft:10, marginTop:20, width:390, height:200}}>
        <QpNxgPlaybackView
        style= {{width:390, height:200}}
        playerID={playerID}/>
        </View>
    </SafeAreaView>
);
};
export default App;