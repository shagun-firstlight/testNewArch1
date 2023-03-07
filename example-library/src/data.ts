export type IntObj = {
    a:number,
    b:number
}

export type MediaTypeValue = 'DASH' | 'HLS' | 'SMOOTH_STREAMING' | 'OTHER';
export type DrmTypeValue = 'WIDEVINE' | 'PLAYREADY' | 'FAIRPLAY' | 'NONE';


export interface PlayerConfig {
  mediaURL: string;
  mediaType: MediaTypeValue;
  drmLicenseURL?: string | undefined | null;
  drmType?: DrmTypeValue | undefined | null;
}