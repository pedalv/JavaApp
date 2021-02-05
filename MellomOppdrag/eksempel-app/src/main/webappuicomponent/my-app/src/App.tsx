import React from "react";
import { Heading, Heading2 } from "./heading/Heading";
import Counter from "./counter/Counter";
import RenderTsx from "./render/RenderTsx";
import RenderHtml from "./render/RenderHtml";
import StarMatch from './StarMatch';

export function label(name: string) {
    return `Hello ${name.toLocaleUpperCase()}`;
}

const initialState = { count: 0 };
export type CounterSate = Readonly<typeof initialState>;

class App extends React.Component<object, CounterSate> {
    readonly state: CounterSate = initialState;

    increment = (isShift: boolean) => {
        const inc: number = isShift ? 10 : 1;
        this.setState({ count : this.state.count + inc });
    };

    render() {

        //this.state.count = 99; Attempt to assign to const or readonly variable

        return (
            <div>
                <h1>{label("React")}</h1>
                <Heading2 />
                <Heading />
                <hr />
                <Counter
                    label={"Current"}
                    count={this.state.count}
                    onCounterIncrease={this.increment}
                />
                <hr />
                <RenderHtml />
                <RenderTsx />
                <hr />
                <StarMatch />
            </div>
        );
    }

}

/*
function App() {
    return (
        <div>
            <h1>{label("React")}</h1>
            <Heading2 />
            <Heading />
            <Counter label={"Current"}/>
        </div>
    );
}
*/

export default App;


/*
React Hook: a, b = useState() results:
a) state object (getter)
b) updater function (setter)

const [currentStateValue, functionTosetNewStateValue] = useState(initialStateValue)
 */

/*
Example React Hook and one-way Data Flow works:
- https://jscomplete.com/playground/rgs1.6
- https://jscomplete.com/playground/rgs1.8
- https://jscomplete.com/playground/rgs2.7
*/

/*
JS ES6

const PI = Math.PI;
const E = Math.E;
const SQRT2 = Math.SQRT2
===
const {PI, E, SQRT2} = Math;

const {Component, Fragment, useState} = require('react');
useState();
 */


/*
const resetGame = () => {
    setStars(utils.random(1, 9));
    setAvailableNums(utils.range(1, 9));
    setCandidateNums([0]);
};
 */