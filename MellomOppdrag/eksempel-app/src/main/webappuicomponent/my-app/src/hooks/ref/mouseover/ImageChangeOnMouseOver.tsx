import React from "react";
import ImageToggleOnMouseOver from "./ImageToggleOnMouseOver";

const ImageChangeOnMouseOver = () => {
  return (
    <div>
      <ImageToggleOnMouseOver
        primaryImg={"/static/speakers/bw/Speaker-187.jpg"}
        secondaryImg={"/static/speakers/Speaker-187.jpg"}
      />
      &nbsp;&nbsp;&nbsp;
      <ImageToggleOnMouseOver
        primaryImg={"/static/speakers/bw/Speaker-1124.jpg"}
        secondaryImg={"/static/speakers/Speaker-1124.jpg"}
      />
    </div>
  );
};

export default ImageChangeOnMouseOver;
