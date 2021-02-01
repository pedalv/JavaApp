import React from "react";

export function label(name: string ) {
  return `Hello ${name.toLocaleUpperCase()}`;
}

function App() {
  return (
    <div>
      <h1>{label("React")}</h1>
    </div>
  );
}

export default App;
