import { requireNativeComponent } from 'react-native'

const isTurboModuleEnabled = global.__turboModuleProxy != null;
const isFabricEnabled = global.nativeFabricUIManager != null;


export const calculator = isTurboModuleEnabled ?
      require("./NativeCalculator").calc :
      require("./Calculator").calc;

export const advanceCalculator = isTurboModuleEnabled ?
      require("./NativeAdvanceCalculator").advCalc :
      require("./AdvanceCalculator").advCalc;


export  const ColoredView = isFabricEnabled ?
      require("./ColoredViewNativeComponent").default :
      requireNativeComponent("ColoredView")


