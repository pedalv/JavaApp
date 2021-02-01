import React from "react";
import { Heading } from "./Heading";
import { Heading2 } from "./Heading2";
import Counter from "./Counter";

export function label(name: string) {
  return `Hello ${name.toLocaleUpperCase()}`;
}

function App() {
    return (
        <div>
            <h1>{label("React")}</h1>
            <Heading2 />
            <Heading />
            <Counter label={"Current"}/>
        </div>
    );
}

export default App;
