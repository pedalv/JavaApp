import React from 'react'; //effect og state hook
import './starmatch.css';
import utils from './utils';
import PlayNumber from './PlayNumber';
import StarsDisplay from './StarsDisplay';
import PlayAgain from './PlayAgain';
import useGameState from './useGameState';

//Use PropTypes or TypeScript
export type GameProps = {
    startNewGame: () => void;
};

const Game = (props: GameProps) => {
    const {
        stars,
        availableNums,
        candidateNums,
        secondsLeft,
        setGameState
    } = useGameState();

    const calculateGameStatus = () => {
        return availableNums.length === 0
            ? 'won'
            : secondsLeft === 0 ? 'lost' : 'active'
    };

    const gameStatus = calculateGameStatus();

    const candidatesAreWrong = utils.sum(candidateNums) > stars;

    const numberStatus = (number: number) => {
        if (!availableNums.includes(number)) {
            return "used";
        }
        if (candidateNums.includes(number)) {
            return candidatesAreWrong ? "wrong" : "candidate";
        }
        return "available";
    };

    const onNumberClick = (number: number, currentStatus: string) => {
        if (gameStatus !== 'active' || currentStatus === 'used') {
            return;
        }

        const newCandidateNums =
            currentStatus === "available"
                ? candidateNums.concat(number)
                : candidateNums.filter((cn: number) => cn !== number);

        setGameState(newCandidateNums);
    };

    return (
        <div className="game">
            <div className="help">
                Pick 1 or more numbers that sum to the number of stars
            </div>
            <div className="body">
                <div className="left">
                    {gameStatus !== 'active' ? (
                        <PlayAgain onClick={props.startNewGame} gameStatus={gameStatus} />
                    ) : (
                        <StarsDisplay count={stars} />
                    )}

                    {/*
                    {utils.range(1, stars).map(starId =>
                        <div key={starId} className="star" />
                    )}
                    <StarsDisplay count={stars} />
                    */}

                    {/*
                    <div className="star" />
                    <div className="star" />
                    <div className="star" />
                    <div className="star" />
                    <div className="star" />
                    <div className="star" />
                    <div className="star" />
                    <div className="star" />
                    <div className="star" />
                    */}
                </div>
                <div className="right">
                    {/* <button key={number} className="number">{number}</button> */}
                    {utils.range(1, 9).map((number) => (
                        <PlayNumber
                            key={number}
                            status={numberStatus(number)}
                            number={number}
                            onClick={onNumberClick}
                        />
                    ))}
                    {/*
                    <button className="number">1</button>
                    <button className="number">2</button>
                    <button className="number">3</button>
                    <button className="number">4</button>
                    <button className="number">5</button>
                    <button className="number">6</button>
                    <button className="number">7</button>
                    <button className="number">8</button>
                    <button className="number">9</button>
                    */}
                </div>
            </div>
            <div className="timer">Time Remaining: {secondsLeft}</div>
        </div>
    );
};

export default Game;