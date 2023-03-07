import { requireNativeComponent } from 'react-native'

const isTurboModuleEnabled = global.__turboModuleProxy != null;

export const calculator = isTurboModuleEnabled ?
require("./NativeCalculator").calc :
require("./Calculator").calc;


const isFabricEnabled = global.nativeFabricUIManager != null;

export  const ColoredView = isFabricEnabled ?
      require("./ColoredViewNativeComponent").default :
      requireNativeComponent("ColoredView")


