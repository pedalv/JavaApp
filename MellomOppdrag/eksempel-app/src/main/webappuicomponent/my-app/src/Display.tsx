import React from 'react';

//Use PropTypes or TypeScript
export type DisplayProps = {
    message: number;
};

function Display(props : DisplayProps) {
    return <div>{props.message}</div>;
}

export default Display;