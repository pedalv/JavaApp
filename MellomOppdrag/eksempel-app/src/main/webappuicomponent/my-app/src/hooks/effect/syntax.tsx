import React, {useEffect, useState} from 'react';
import RenderTsx from '../../render/RenderTsx';
import RenderHtml from '../../render/RenderHtml';

const Syntax = () => {
    const [checkBoxValue, setCheckBoxValue] = useState(false);

    /*
    useEffect(() => {
        console.log('in useEffect');
        return () => {
            console.log('in useEffect Cleanup');
        }
    }, [checkBoxValue]);
    */

    useEffect(() => {
        const timerId = setTimeout(() => {
            setCheckBoxValue(!checkBoxValue);
            console.log('in useEffect ' + checkBoxValue);
        }, 1000);
        return () => {
            console.log('in useEffect Cleanup');
            clearTimeout(timerId); // Clean always timer for prevent site affects
        }
    });

    return (
        <div>
            <RenderHtml />
            <RenderTsx />
        </div>);
};

export default Syntax;