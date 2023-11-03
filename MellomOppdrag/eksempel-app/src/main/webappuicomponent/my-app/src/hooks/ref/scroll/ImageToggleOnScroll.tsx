import React, {useEffect, useRef, useState} from 'react';

/**
 * imageRef === img tag === HTMLInputElement => Image === any
 * @param primaryImg
 * @param secondaryImg
 * @constructor
 */
const ImageToggleOnScroll = ({ primaryImg, secondaryImg }: any) => {
  const imageRef = useRef<HTMLInputElement>(null) as any;

  const [isLoading, setIsLoading] = useState(true);

  const isInView = () => {
    const rect = imageRef.current.getBoundingClientRect();
    return rect.top >= 0 && rect.bottom <= window.innerHeight;
  };

  const [inView, setInView] = useState(false);

  const scrollHandler = () => {
    setInView(isInView());
  };

  useEffect(() => {
    setIsLoading(false);
    setInView(isInView());
    window.addEventListener("scroll", scrollHandler);
    return () => {
      return window.removeEventListener("scroll", scrollHandler);
    };
  }, []);

  return (
      <img
          src={
            isLoading
                ? "data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==" // 1x1gif === transparent gif
                : inView
                ? secondaryImg
                : primaryImg
          }
          alt={""}
          ref={imageRef}
      />
  );
};

export default ImageToggleOnScroll;
