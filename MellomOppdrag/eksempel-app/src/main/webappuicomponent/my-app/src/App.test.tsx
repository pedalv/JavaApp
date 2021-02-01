import React from "react";
import { render, screen } from "@testing-library/react";
import App, { label } from "./App";
import userEvent from "@testing-library/user-event";

test("renders 3 headers", () => {
  render(<App />);
  //const linkElement = screen.getByText(/Hello React/i);
  const linkElement = screen.getAllByText(/Hello React/i);
  //(If this is intentional, then use the `*AllBy*` variant of the query (like `queryAllByText`, `getAllByText`, or `findAllByText`)).
  expect(linkElement.length).toEqual(3);
  //expect(linkElement).toBeInTheDocument();
});

test("proof of concept", () => {
  const actual = 1;
  const expected = 1;
  expect(actual).toBe(expected);
});

test("generate a label", () => {
  const result = label("React");
  expect(result).toEqual("Hello REACT");
});

test("should render a label", () => {
  const { getByLabelText } = render(<App />);
  const label = getByLabelText("Current");
  expect(label).toBeInTheDocument();
});

test("should start a zero", () => {
  const { getByRole } = render(<App />);
  const counter = getByRole("counter");
  expect(counter).toHaveTextContent("0");
});

test("update state when increment is called without shift", () => {
  const { getByRole } = render(<App />);
  const counter = getByRole("counter");
  expect(counter).toHaveTextContent("0");
  userEvent.click(counter);
  expect(counter).toHaveTextContent("1");
});

test("update state when increment is called with shift", () => {
  const { getByRole } = render(<App />);
  const counter = getByRole("counter");
  expect(counter).toHaveTextContent("0");
  userEvent.click(counter, { shiftKey: true })
  expect(counter).toHaveTextContent("10");
});