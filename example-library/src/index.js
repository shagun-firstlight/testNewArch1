import { requireNativeComponent } from 'react-native'

const isTurboModuleEnabled = global.__turboModuleProxy != null;
const isFabricEnabled = global.nativeFabricUIManager != null;


export const calculator = isTurboModuleEnabled ?
      require("./newArch/NativeCalculator").calc :
      require("./oldArch/Calculator").calc;

export const advanceCalculator = isTurboModuleEnabled ?
      require("./newArch/NativeAdvanceCalculator").advCalc :
      require("./oldArch/AdvanceCalculator").advCalc;

export const player = isTurboModuleEnabled ?
      require("./newArch/NativePlayer").player :
      require("./oldArch/Player").player;

export  const ColoredView = isFabricEnabled ?
      require("./ColoredViewNativeComponent").default :
      requireNativeComponent("ColoredView")


