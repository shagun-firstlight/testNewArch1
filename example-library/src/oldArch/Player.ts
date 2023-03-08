import { NativeModules } from 'react-native';
import { PlayerConfig } from '../typings/data';

const nativePlayer = NativeModules.Player;

class Player {
  createPlayer(playerConfig:PlayerConfig): Promise<number> {
    return nativePlayer.createPlayer(playerConfig);
  }
}

const player = new Player();


export {player} ;