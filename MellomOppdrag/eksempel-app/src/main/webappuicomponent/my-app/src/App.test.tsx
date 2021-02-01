import React from "react";
import { render, screen } from "@testing-library/react";
import App, {label} from "./App";

test("renders Hello React", () => {
  render(<App />);
  const linkElement = screen.getByText(/Hello React/i);
  expect(linkElement).toBeInTheDocument();

  const actual = 1;
  const expected = 1;
  expect(actual).toBe(expected);
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