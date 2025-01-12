import { ScrollView, StyleSheet, Text } from "react-native";
import { TextField } from "jetpack-compose-react-native";
import React from "react";

export default function TextFieldsExample() {
  const [text, setText] = React.useState("Hello");

  return (
    <ScrollView style={{ flex: 1 }} contentContainerStyle={{ padding: 20 }}>
      <Text style={styles.header}>Text Fields Example</Text>
      <TextField
        value={text}
        onValueChange={(v) => {
          console.log("new value", v);
          setText(v);
        }}
        label="Enter text"
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
