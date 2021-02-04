import React from 'react';

//Use PropTypes or TypeScript
export type DisplayProps = {
    message: number;
};

function Display({ message } : DisplayProps) {
    return <div>{message}</div>;
}

export default Display;