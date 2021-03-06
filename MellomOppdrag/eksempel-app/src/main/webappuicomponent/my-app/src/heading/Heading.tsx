import React from "react";
import {label} from '../App';

export type HeadingProps = { name?: string };

//Most developer prefer functions
export function Heading({ name = "React" }: HeadingProps) {
  return <h1>Hello {name?.toLocaleUpperCase()}</h1>;
}

//Most developer prefer functions
export class Heading2 extends React.Component {
  render() {
    return <h1>{label("React")}</h1>;
  }
}