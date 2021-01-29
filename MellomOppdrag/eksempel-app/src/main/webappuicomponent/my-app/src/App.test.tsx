import React from "react";
import { render, screen } from "@testing-library/react";
import App from "./App";

test("renders learn react link", () => {
  render(<App />);
  const linkElement = screen.getByText(/Hello React/i);
  expect(linkElement).toBeInTheDocument();

  const actual = 1;
  const expected = 1;
  expect(actual).toBe(expected);
});

test("test best pratics", () => {
  const actual = 1;
  const expected = 1;
  expect(actual).toBe(expected);
});