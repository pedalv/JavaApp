import React from 'react';

//Use PropTypes or TypeScript
export type DisplayProps = {
    message: number;
};

//Most developer prefer functions
const Display = (props : DisplayProps) => {
    return <div>{props.message}</div>;
};

{/*
function Display(props : DisplayProps) {
    return <div>{props.message}</div>;
}
 */}

export default Display;