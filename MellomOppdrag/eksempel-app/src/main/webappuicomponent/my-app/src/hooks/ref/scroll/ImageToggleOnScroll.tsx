import React, {useRef} from 'react';


const ImageToggleOnScroll = ({ primaryImg , secondaryImg} : any)  => {

    const imageRef = useRef<HTMLInputElement>(null) as any;

    return (
        <img
            onMouseOver={() => {
                imageRef.current.src = secondaryImg;
            }}
            onMouseOut={() => {
                imageRef.current.src = primaryImg;
            }}
            src={primaryImg}
            alt={""}
            ref={imageRef}
        />
    );
};

export default ImageToggleOnScroll;
