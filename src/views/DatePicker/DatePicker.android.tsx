import { requireNativeViewManager } from "expo-modules-core";
import * as React from "react";
import { ViewStyle } from "react-native";
import { Modifier } from "../../utils/modifier";

export type DatePickerProps = {
  style?: ViewStyle;
  confirmText?: string;
  dismissText?: string;
  tonalElevation?: number;
  showModeToggle?: boolean;
  modifier?: typeof Modifier;
};

const NativeView: React.ComponentType<DatePickerProps> =
  requireNativeViewManager("DatePickerView");

export function DatePicker({ style, ...rest }: DatePickerProps) {
  return (
    <NativeView
      {...rest}
      style={{ height: "auto", width: "auto", ...(style as any) }}
      modifier={(rest.modifier as any)?.build()}
    />
  );
}
