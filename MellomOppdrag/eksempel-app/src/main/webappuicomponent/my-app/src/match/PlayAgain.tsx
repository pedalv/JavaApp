import React from 'react';

//Use PropTypes or TypeScript
export type PlayAgainProps = {
    gameStatus: string;
    onClick: (resetGame: React.MouseEvent<HTMLElement>) => void;
};

const PlayAgain = (props: PlayAgainProps) => (
    <div className="game-done">
        <div
            className="message"
            style={{ color: props.gameStatus === 'lost' ? 'red' : 'green'}}
        >
            {props.gameStatus === 'lost' ? 'Game Over' : 'Nice'}
        </div>
        <button onClick={props.onClick}>Play Again</button>
    </div>
);

export default PlayAgain;
