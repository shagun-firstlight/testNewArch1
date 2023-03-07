import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';


export enum MediaTypeValue {DASH = "DASH" , HLS= 'HLS' , SMOOTH_STREAMING='SMOOTH_STREAMING' , OTHER='OTHER'};
export enum DrmTypeValue { WIDEVINE='WIDEVINE' , PLAYREADY= 'PLAYREADY' , FAIRPLAY='FAIRPLAY' ,NONE= 'NONE'}



export type PlayerConfig = {
  mediaURL: string;
  mediaType: MediaTypeValue;
  drmLicenseURL?: string | undefined | null;
  drmType?: DrmTypeValue | undefined | null;
}

export interface Spec extends TurboModule {
    createPlayer(playerConfig: PlayerConfig): Promise<number>;
}

const player = TurboModuleRegistry.get<Spec>('Player');


export {player} ;