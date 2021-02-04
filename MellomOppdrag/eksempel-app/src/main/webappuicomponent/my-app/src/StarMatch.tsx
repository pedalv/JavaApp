import React, {useState} from 'react';
import './starmatch.css';
import utils from './utils';
import PlayNumber from './PlayNumber';
import StarsDisplay from './StarsDisplay';

const StarMatch = () => {
    const [stars, setStars] = useState(utils.random(1, 9));
    return (
        <div className="game">
            <div className="help">
                Pick 1 or more numbers that sum to the number of stars
            </div>
            <div className="body">
                <div className="left">
                    {/*
                    {utils.range(1, stars).map(starId =>
                        <div key={starId} className="star" />
                    )}
                    */}
                    <StarsDisplay count={stars}/>
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
                    {utils.range(1, 9).map(number =>
                        <PlayNumber key={number}  number={number} />
                    )}
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
            <div className="timer">Time Remaining: 10</div>
        </div>
    );
};

export default StarMatch;