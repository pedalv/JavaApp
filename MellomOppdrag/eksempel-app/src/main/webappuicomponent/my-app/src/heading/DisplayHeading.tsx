import React from "react";
import { Heading, Heading2 } from "./Heading";
import { label } from "../App";

const DisplayHeading = () => {

    return (
        <div>
            <h1>{label("React")}</h1>
            <Heading2 />
            <Heading />
        </div>
    );

};

export default DisplayHeading;