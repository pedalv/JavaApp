import React from "react";

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
