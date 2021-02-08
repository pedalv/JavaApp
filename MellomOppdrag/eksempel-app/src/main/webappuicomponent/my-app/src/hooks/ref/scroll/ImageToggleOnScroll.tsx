import React, { useEffect, useRef, useState } from "react";

const ImageToggleOnScroll = ({ primaryImg, secondaryImg }: any) => {
  const imageRef = useRef<HTMLInputElement>(null) as any;

  const isInView = () => {
      const rect = imageRef.current.getBoundingClientRect();
      return rect.top >= 0 && rect.bottom <= window.innerHeight;
  };

  const [inView, setInView] = useState(false);

  const scrollHandler = () => {
      setInView(isInView());
  };

  useEffect(() => {
    window.addEventListener("scroll", scrollHandler);
    return () => {
      return window.removeEventListener("scroll", scrollHandler);
    };
  }, []);

  return <img src={inView ? secondaryImg : primaryImg} alt={""} ref={imageRef} />;
};

export default ImageToggleOnScroll;
