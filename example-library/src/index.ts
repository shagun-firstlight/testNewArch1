import { requireNativeComponent } from 'react-native'

const isTurboModuleEnabled = global.__turboModuleProxy != null;
const isFabricEnabled = global.nativeFabricUIManager != null;


const calculator = isTurboModuleEnabled ?
      require("./newArch/NativeCalculator").calc :
      require("./oldArch/Calculator").calc;

const advanceCalculator = isTurboModuleEnabled ?
      require("./newArch/NativeAdvanceCalculator").advCalc :
      require("./oldArch/AdvanceCalculator").advCalc;

const player = isTurboModuleEnabled ?
      require("./newArch/NativePlayer").player :
      require("./oldArch/Player").player;

const ColoredView = isFabricEnabled ?
      require("./ColoredViewNativeComponent").default :
      requireNativeComponent("ColoredView")


export { calculator, advanceCalculator, player, ColoredView };
export * from './typings/data';
