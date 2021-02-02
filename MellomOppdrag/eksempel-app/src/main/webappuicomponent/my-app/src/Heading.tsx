import React from "react";

export type HeadinggProps = { name?: string };

//Most developer prefer functions
export function Heading({ name = "React" }: HeadinggProps) {
  return <h1>Hello {name}</h1>;
}