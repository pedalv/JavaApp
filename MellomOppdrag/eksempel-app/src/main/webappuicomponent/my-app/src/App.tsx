import React from "react";
import {Heading, Heading2} from './Heading';
import Counter from "./Counter";

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

        /*
        React Hook: a, b = useState() results:
        a) state object (getter)
        b) updater function (setter)

        const [currentStateValue, functionTosetNewStateValue] = useState(initialStateValue)
         */
    };

    render() {

        //this.state.count = 99; Attempt to assign to const or readonly variable

        return (
            <div>
                <h1>{label("React")}</h1>
                <Heading2 />
                <Heading />
                <Counter
                    label={"Current"}
                    count={this.state.count}
                    onCounterIncrease={this.increment}
                />
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
Example how React Hook and one-way Data Flow works:
- https://jscomplete.com/playground/rgs1.6
- https://jscomplete.com/playground/rgs1.8
 */