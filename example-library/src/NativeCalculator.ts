import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';

export type IntObj = {
  a:number,
  b:number
}

export interface Spec extends TurboModule {
    // your module methods go here, for example:
    add(a: number, b: number): Promise<number>;
    sub(a: number, b: number): Promise<number>;
    mul(a:IntObj): Promise<number>;
}

const calc = TurboModuleRegistry.get<Spec>('Calculator');


export {calc} ;