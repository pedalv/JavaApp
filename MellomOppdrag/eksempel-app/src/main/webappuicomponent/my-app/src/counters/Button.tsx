import React from 'react';

//Use PropTypes or TypeScript
export type ButtonProps = {
    increment: number;
    onClickFunction: (incrementCounter: number) => void;
};

//Most developer prefer functions
const Button = (props : ButtonProps) => {
    const handleClick = () => props.onClickFunction(props.increment);
    return (
        <button onClick={handleClick}>
            +{props.increment}
        </button>
    );
};


{/*
function Button( props : ButtonProps) {
    const handleClick = () => props.onClickFunction(props.increment);
    return (
        <button onClick={handleClick}>
            +{props.increment}
        </button>
    );
}
*/}

export default Button;
