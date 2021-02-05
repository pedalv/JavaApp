import React from "react";

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