import { NativeModules } from 'react-native';
import { IntObj } from '../typings/data';

const nativeCalculator = NativeModules.Calculator;

class Calculator {
  add(a: number, b: number): Promise<number> {
    return nativeCalculator.add(a, b);
  }
  sub(a: number, b: number): Promise<number> {
    return nativeCalculator.sub(a, b);
  }
  mul(intObj:IntObj): Promise<number> {
    return nativeCalculator.mul(intObj);
  }
}

const calc = new Calculator();


export {calc} ;