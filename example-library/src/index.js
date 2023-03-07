// @flow
import { NativeModules } from 'react-native'
import { requireNativeComponent } from 'react-native'

const isTurboModuleEnabled = global.__turboModuleProxy != null;

export const calculator = isTurboModuleEnabled ?
  require("./NativeCalculator").default :
  NativeModules.Calculator;


const isFabricEnabled = global.nativeFabricUIManager != null;

export  const ColoredView = isFabricEnabled ?
      require("./ColoredViewNativeComponent").default :
      requireNativeComponent("ColoredView")


