import React from 'react';

//Use PropTypes or TypeScript
export type PlayAgainProps = {
    onClick: (resetGame: React.MouseEvent<HTMLElement>) => void;
};

const PlayAgain = (props: PlayAgainProps) => (
    <div className="game-done">
        <button onClick={props.onClick}>Play Again</button>
    </div>
);

export default PlayAgain;
