import React from "react";
import { ScrollView, StyleSheet, Text } from "react-native";
import { Button, DatePicker } from "jetpack-compose-react-native";

export default function DialogsExample() {
  const [datePickerVisible, setDatePickerVisible] = React.useState(false);

  return (
    <ScrollView style={{ flex: 1 }} contentContainerStyle={{ padding: 20 }}>
      <Text style={styles.header}>Dialogs Example</Text>
      {datePickerVisible && (
        <DatePicker showModeToggle confirmText="Confirm" dismissText="Cancel" />
      )}
      <Button
        text="Show Date picker"
        onClick={() => {
          setDatePickerVisible(true);
        }}
      />
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  header: {
    fontSize: 30,
    fontWeight: "bold",
    marginVertical: 20,
  },
});
