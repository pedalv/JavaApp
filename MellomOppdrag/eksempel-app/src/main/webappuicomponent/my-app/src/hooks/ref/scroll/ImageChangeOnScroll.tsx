import React from "react";
import ImageToggleOnScroll from "./ImageToggleOnScroll";

const ImageChangeOnScroll = () => {
  return (
    <div>
      <ImageToggleOnScroll
        primaryImg={"/static/speakers/bw/Speaker-187.jpg"}
        secondaryImg={"/static/speakers/Speaker-187.jpg"}
      />
      &nbsp;&nbsp;&nbsp;
      <ImageToggleOnScroll
        primaryImg={"/static/speakers/bw/Speaker-1124.jpg"}
        secondaryImg={"/static/speakers/Speaker-1124.jpg"}
      />
    </div>
  );
};

export default ImageChangeOnScroll;
