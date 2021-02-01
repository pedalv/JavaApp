import React, {Component} from 'react';

export type CounterProps = { label? : string };

class Counter extends Component<CounterProps> {
    render() {

        const  { label = "Count" } = this.props;

        return (
          <div>
            <label htmlFor="counter" aria-label={label}>
              {label}
            </label>
            <span id="counter" role="counter">
              1.000.000.000
            </span>
          </div>
        );
    }
}

export default Counter;