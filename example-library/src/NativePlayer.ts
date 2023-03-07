import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';

// export type MediaTypeValue = 'DASH' | 'HLS' | 'SMOOTH_STREAMING' | 'OTHER';
// export type DrmTypeValue = 'WIDEVINE' | 'PLAYREADY' | 'FAIRPLAY' | 'NONE';


export type PlayerConfig = {
  mediaURL: string;
  mediaType: string;
  drmLicenseURL?: string | undefined | null;
  drmType?: string | undefined | null;
}

export interface Spec extends TurboModule {
    createPlayer(playerConfig: PlayerConfig): Promise<number>;
}

const player = TurboModuleRegistry.get<Spec>('Player');


export {player} ;