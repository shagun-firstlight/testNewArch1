import { NativeModules } from 'react-native';
import { PlayerConfig } from '../typings/data';

const nativePlayer = NativeModules.Player;

class Player {

  async initWithConfig(playerConfig:PlayerConfig): Promise<void> {
    return await nativePlayer.initWithConfig(playerConfig);
  }

  async getNativeID(): Promise<number> {
    return await nativePlayer.getNativeID();
  }

  async load(): Promise<void>{
    return await nativePlayer.load();
  }

  async play(): Promise<void>{
    return await nativePlayer.play();
  }

  async pause(): Promise<void>{
    return await nativePlayer.pause();
  }

  async stop(): Promise<void>{
    return await nativePlayer.stop();
  }

  async dispose(): Promise<void>{
    return await nativePlayer.dispose();
  }

  async seek(seekPosition: number): Promise<void>{
    return await nativePlayer.seek(seekPosition);
  }

}

const player = new Player();


export {player} ;