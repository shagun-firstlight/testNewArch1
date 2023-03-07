import { NativeModules } from 'react-native';

const nativeAdvanceCalculator = NativeModules.AdvanceCalculator;

class AdvanceCalculator {
  div(a: number, b: number): Promise<number> {
    return nativeAdvanceCalculator.div(a, b);
  }
}

const advCalc = new AdvanceCalculator();


export {advCalc} ;