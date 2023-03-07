import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';



export interface Spec extends TurboModule {
    div(a: number, b: number): Promise<number>;
}

const advCalc = TurboModuleRegistry.get<Spec>('AdvanceCalculator');


export {advCalc} ;