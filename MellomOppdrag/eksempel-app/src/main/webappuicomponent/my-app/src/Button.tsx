import React from 'react';

//Use PropTypes or TypeScript
export type ButtonProps = {
    increment: number;
    onClickFunction: (incrementCounter: number) => void;
};

function Button( props : ButtonProps) {
    const handleClick = () => props.onClickFunction(props.increment);
    return (
        <button onClick={handleClick}>
            +{props.increment}
        </button>
    );
}

export default Button;
