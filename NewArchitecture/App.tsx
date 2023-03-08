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
Button,
} from 'react-native';
import {ColoredView, player} from 'example-library'
import {MediaTypeValue, DrmTypeValue} from 'example-library/src/newArch/NativePlayer'
const App: () => Node = () => {

return (
    <SafeAreaView>
    <StatusBar barStyle={'dark-content'}/>
    <ColoredView color="#FF0099" style={{marginLeft:10, marginTop:20, width:100, height:100}}/>
    <Button  title="Create Player" onPress={async () => {
            const result = await player?.createPlayer({
                mediaURL: 'https://storage.googleapis.com/wvmedia/clear/h264/tears/tears.mpd',
                mediaType: MediaTypeValue.DASH,
                drmLicenseURL: "",
                drmType: DrmTypeValue.NONE
            });
            
        }} />
    </SafeAreaView>
);
};
export default App;