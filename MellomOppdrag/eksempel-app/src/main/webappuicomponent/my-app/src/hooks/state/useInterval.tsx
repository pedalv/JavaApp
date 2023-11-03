// https://overreacted.io/making-setinterval-declarative-with-react-hooks/
import { useEffect, useRef } from 'react';

//Use PropTypes or TypeScript
type IntervalFunction = () => ( unknown | void );

export type useIntervalProps = {
    callback: IntervalFunction;
    delay: number;
}

const useInterval = (callback: IntervalFunction, delay: number) => {
//const useInterval = (props: useIntervalProps) => {
    //const savedCallback = useRef(null);
    const savedCallback = useRef<IntervalFunction| null>( null );

    // Remember the latest function.
    useEffect(() => {
        savedCallback.current = callback;
    }, [callback]);

    // Set up the interval.
    useEffect(() => {
        function tick() {
            if(savedCallback && savedCallback.current !==   null) {
                savedCallback.current();
            }
        }
        if (delay !== null) {
            let id = setInterval(tick, delay);
            return () => clearInterval(id);
        }
    }, [delay]);
};
export default useInterval;
