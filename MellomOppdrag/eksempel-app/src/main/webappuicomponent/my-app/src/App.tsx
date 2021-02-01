import React from "react";
import { Heading } from "./Heading";
import { Heading2 } from "./Heading2";
import Counter from "./Counter";

export function label(name: string) {
  return `Hello ${name.toLocaleUpperCase()}`;
}

const initialState = { count: 0 }
export type CounterSate = Readonly<typeof initialState>;

class App extends React.Component<object, CounterSate> {
    readonly state: CounterSate = initialState;

    increment = (isShift: boolean) => {
        const inc: number = isShift ? 10 : 1;
        this.setState({ count : this.state.count + inc });
    }

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
