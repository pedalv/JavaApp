import React from "react";

//Most developer prefer functions
const RenderHtml = () => {
  return (
    <div>
      Hello HTML
      <input />
      <pre>{new Date().toLocaleTimeString()}</pre>
    </div>
  );
};

export default RenderHtml;
