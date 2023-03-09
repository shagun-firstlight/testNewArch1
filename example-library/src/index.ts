import { requireNativeComponent } from 'react-native'

const isTurboModuleEnabled = global.__turboModuleProxy != null;
const isFabricEnabled = global.nativeFabricUIManager != null;


const player = isTurboModuleEnabled ?
      require("./newArch/NativePlayer").player :
      require("./oldArch/Player").player;

const ColoredView = isFabricEnabled ?
      require("./ColoredViewNativeComponent").default :
      requireNativeComponent("ColoredView")

const QpNxgPlaybackView = isFabricEnabled ?
      require("./newArch/QpNxgPlaybackViewNativeComponent").default :
      requireNativeComponent('QpNxgPlaybackView');


export { player, ColoredView, QpNxgPlaybackView };
export * from './typings/data';
