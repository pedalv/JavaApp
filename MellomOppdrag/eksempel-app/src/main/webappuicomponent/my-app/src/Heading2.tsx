import React from "react";
import { label } from "./App";

//Most developer prefer functions
export class Heading2 extends React.Component {
  render() {
    return <h1>{label("React")}</h1>;
  }
}