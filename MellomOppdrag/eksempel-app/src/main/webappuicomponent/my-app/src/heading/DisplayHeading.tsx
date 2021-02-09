import React, {useContext} from 'react';
import { Heading, Heading2 } from "./Heading";
import {ConfigContext, label} from '../App';

const DisplayHeading = () => {

    const context = useContext(ConfigContext);

    return (
        <div>
            <h1>{label("React")}</h1>
            <Heading2 />
            {context.showHeading === false ? null : (
                <Heading />
            )}
        </div>
    );

};

export default DisplayHeading;