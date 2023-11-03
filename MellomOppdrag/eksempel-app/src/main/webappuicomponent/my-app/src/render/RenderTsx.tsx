import React from "react";

//Most developer prefer functions
const RenderTsx = () => {
  return React.createElement(
    "div",
    null,
    "Hello React",
    React.createElement("input", null),
    React.createElement("pre", null, new Date().toLocaleTimeString())
  );
};

export default RenderTsx;