// @flow

import type {ViewProps} from 'react-native/Libraries/Components/View/ViewPropTypes';
import type {HostComponent} from 'react-native';
import { ViewStyle } from 'react-native';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';

type NativeProps = $ReadOnly<{|
...ViewProps,
backgroundColour: string,
playerID:Int32
|}>;

export default (codegenNativeComponent<NativeProps>(
    'QpNxgPlaybackView',
): HostComponent<NativeProps>);
