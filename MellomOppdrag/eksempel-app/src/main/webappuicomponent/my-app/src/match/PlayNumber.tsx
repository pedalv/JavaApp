import React from 'react';

//Use PropTypes or TypeScript
export type PlayNumberProps = {
    key: number;
    status: string;
    number: number;
    onClick: (number: number, currentStatus: string) => void;
};

const PlayNumber = (props: PlayNumberProps) => (
    <button
        className="number"
        style={{ backgroundColor: colors[props.status] }}
        onClick={() => props.onClick( props.number, props.status)}
    >
        {props.number}
    </button>
);

// Color Theme
const colors : ColorType = {
    available: 'lightgray',
    used: 'lightgreen',
    wrong: 'lightcoral',
    candidate: 'deepskyblue',
};

interface ColorType {
    [key: string]: any;
}

export default PlayNumber;