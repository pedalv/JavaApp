import React from 'react';

//Use PropTypes or TypeScript
export type ButtonProps = {
    increment: number;
    onClickFunction: (incrementCounter: number) => void;
};

function Button( {increment, onClickFunction} : ButtonProps) {
    const handleClick = () => onClickFunction(increment);
    return (
        <button onClick={handleClick}>
            +{increment}
        </button>
    );
}

export default Button;
