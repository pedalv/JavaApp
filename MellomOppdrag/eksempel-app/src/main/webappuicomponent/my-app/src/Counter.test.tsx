import React from "react";
import { render } from "@testing-library/react";
import Counter from "./Counter";

test("should render a label and counter", () => {
    const { getByLabelText, getByRole } = render(<Counter />);
    const label = getByLabelText("Count");
    expect(label).toBeInTheDocument();
    const counter = getByRole("counter");
    expect(counter).toBeInTheDocument();
});

test("should a counter with a custom label", () => {
    const { getByLabelText, getByRole } = render(<Counter label={'Current'} />);
    const label = getByLabelText("Current");
    expect(label).toBeInTheDocument();
    const counter = getByRole("counter");
    expect(counter).toBeInTheDocument();
});

test("should start a zero", () => {
    const { getByRole } = render(<Counter />);
    const counter = getByRole("counter");
    expect(counter).toHaveTextContent("0");
});

test("should start at anothe value", () => {
    const { getByRole } = render(<Counter start={10}/>);
    const counter = getByRole("counter");
    expect(counter).toHaveTextContent("10");
});