export type IntObj = {
    a:number,
    b:number
}

export enum MediaTypeValue {DASH = "DASH" , HLS= 'HLS' , SMOOTH_STREAMING='SMOOTH_STREAMING' , OTHER='OTHER'};
export enum DrmTypeValue { WIDEVINE='WIDEVINE' , PLAYREADY= 'PLAYREADY' , FAIRPLAY='FAIRPLAY' ,NONE= 'NONE'}


export interface PlayerConfig {
  mediaURL: string;
  mediaType: MediaTypeValue;
  drmLicenseURL?: string | undefined | null;
  drmType?: DrmTypeValue | undefined | null;
}