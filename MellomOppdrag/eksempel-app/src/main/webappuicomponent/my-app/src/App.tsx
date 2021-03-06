import React, {useReducer} from 'react';
import Counter from './counter/Counter';
import StarMatch from './match/StarMatch';
import DisplayHeading from './heading/DisplayHeading';
import DisplayCounters from './counters/DisplayCounters';
import DisplayGithub from './github/DisplayGithub';
import InputElementHistory from './hooks/state/InputElementHistory';
import ImageChangeOnMouseOver from './hooks/ref/mouseover/ImageChangeOnMouseOver';
import ImageChangeOnScroll from './hooks/ref/scroll/ImageChangeOnScroll';
import Syntax from './hooks/effect/syntax';
import EmailValidatingForm from './hooks/state/EmailValidatingForm';

export function label(name: string) {
    return `Hello ${name.toLocaleUpperCase()}`;
}

export const ConfigContext = React.createContext({
    showHeading: true
});

const configValue = {
    showHeading: false
};

/*
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
*/

/*
export type AppProps = { pageName?: string };
{pageName = "Basic"} : AppProps
*/

const App = ( )=> {

    //const [count, setCount] = useState(0);
    //Reducer Defined: (previousState, action) => newState
    const [count, setCount] = useReducer( (state: any, action: any) => action,0);

    const increment = (isShift: boolean) => {
        const inc: number = isShift ? 10 : 1;
        setCount(count + inc);
    };

    return (
        <div>
            <ConfigContext.Provider value={ configValue } >
                <DisplayHeading />
            </ConfigContext.Provider>
            <hr />
            <DisplayGithub title="The GitHub Cards App" />
            <hr />
            <Counter
                label={"Current"}
                count={count}
                onCounterIncrease={increment}
            />
            <hr />
            <DisplayCounters />
            <hr />
            <Syntax />
            <hr />
            <StarMatch />
            <hr />
            <EmailValidatingForm />
            <hr />
            <InputElementHistory />
            <hr />
            <ImageChangeOnMouseOver />
            <ImageChangeOnScroll />
        </div>
    );
};

/*
function App() {
    return (
        <div>
            <h1>{label("React")}</h1>
            <Heading2 />
            <Heading />
            <StarMatch label={"Current"}/>
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