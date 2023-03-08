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
  initWithConfig(playerConfig: PlayerConfig): Promise<number>;
  getNativeID(): Promise<number>;
  load(): Promise<void>;
  play(): Promise<void>;
  pause(): Promise<void>;
  stop(): Promise<void>;
  dispose(): Promise<void>;
  seek(seekPosition: number): Promise<void>;
}

const player = TurboModuleRegistry.get<Spec>('Player');


export {player} ;