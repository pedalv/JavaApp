import React, { useEffect, useState } from "react";
import ImageToggleOnScroll from "./ImageToggleOnScroll";

const ImageChangeOnScroll = () => {
  const [currentSpeakerId, setCurrentSpeakerId] = useState(0);
  const [mouseEventCnt, setMouseEventCnt] = useState(0);

  useEffect(() => {
    window.document.title = `SpearkerId: ${currentSpeakerId}`;
    console.log(`useEffect: setting tittel to ${currentSpeakerId}`);
  }, [currentSpeakerId]);

  return (
    <div>
      <span>mouseEventCnt: {mouseEventCnt}</span>
      {[1124, 187, 823, 1269, 1530].map((speakerId: number) => {
        return (
          <div
            key={speakerId}
            onMouseOver={() => {
              setCurrentSpeakerId(speakerId);
              setMouseEventCnt(mouseEventCnt + 1);
              console.log(`onMouseOver:${speakerId}`);
            }}
          >
            <ImageToggleOnScroll
              primaryImg={`/static/speakers/bw/Speaker-${speakerId}.jpg`}
              secondaryImg={`/static/speakers/Speaker-${speakerId}.jpg`}
            />
          </div>
        );
      })}
    </div>
  );
};

export default ImageChangeOnScroll;
