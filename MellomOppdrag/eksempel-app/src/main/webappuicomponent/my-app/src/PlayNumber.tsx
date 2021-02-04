import React from 'react';

//Use PropTypes or TypeScript
export type PlayNumberProps = {
    number: number;
};

const PlayNumber = (props: PlayNumberProps) => (
    <button className="number" onClick={() => console.log('Num', props.number)}>
        {props.number}
    </button>
);

export default PlayNumber;