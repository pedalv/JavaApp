import React, { Component } from "react";

export type CounterProps = { label?: string; start? : number };

const initialState = { count: 0 }

export type CounterSate = Readonly<typeof initialState>;

class Counter extends Component<CounterProps, CounterSate> {
  readonly state: CounterSate = initialState;

  componentDidMount() {
      if(this.props.start) {
          this.setState({
              count : this.props.start
          })
      }
  }

  render() {
    //this.state.count = 99; Attempt to assign to const or readonly variable

    const { label = "Count" } = this.props;

    return (
      <div>
        <label htmlFor="counter" aria-label={label}>
          {label}
        </label>
        <span id="counter" role="counter">
          {this.state.count}
        </span>
      </div>
    );
  }
}

export default Counter;