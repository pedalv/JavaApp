import React from 'react';
import utils from './utils';

//Use PropTypes or TypeScript
export type StarsDisplayProps = {
    count: number;
};

const StarsDisplay = (props: StarsDisplayProps) => (
    <>
        {utils.range(1, props.count).map(starId => (
            <div key={starId} className="star" />
        ))}
    </>
);

export default StarsDisplay;