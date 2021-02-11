import {useReducer, useState} from 'react';
import useInterval from './useInterval';

function useEmailValidation(maxSeconds: number) {

    const validateEmail = (email: string) => {
        const re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(email);
    };
    const [emailValid, setEmailValid] = useState(false);
    const emailReducer = (state: any, action: any) => {
        const isValidEmail = validateEmail(action);
        setEmailValid(isValidEmail);
        return action;
    };

    const [email, setEmail] = useReducer(emailReducer, '');
    const [count, setCount] = useState(maxSeconds);

    useInterval(() => {
        setCount(count - 1);
    }, 1000);

    const retObject = { email, setEmail, count, setCount, emailValid };

    return retObject;
}

export default useEmailValidation;
