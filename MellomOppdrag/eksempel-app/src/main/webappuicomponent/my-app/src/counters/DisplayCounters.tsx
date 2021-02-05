import React, { useState } from "react";
import Button from "./Button";
import Display from "./Display";


const DisplayCounters = () => {

    const [counter, setCounter] = useState(0);
    const incrementCounter = (incrementValue: number) => setCounter(counter+incrementValue);

    return (
        <div>
            <Button onClickFunction={incrementCounter} increment={1} />
            <Button onClickFunction={incrementCounter} increment={5} />
            <Button onClickFunction={incrementCounter} increment={10} />
            <Button onClickFunction={incrementCounter} increment={100} />
            <Display message={counter}/>
        </div>
    );

};

export default DisplayCounters;