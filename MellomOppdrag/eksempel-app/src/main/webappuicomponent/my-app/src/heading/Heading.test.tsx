import React from "react";
import { render } from "@testing-library/react";
import {Heading, Heading2} from './Heading';

test("renders heading", () => {
  const { getByText } = render(<Heading />);
  const linkElement = getByText(/Hello/i);
  expect(linkElement).toBeInTheDocument();
});

test("renders heading with argument", () => {
  const { getByText } = render(<Heading name={'World'} />);
  const linkElement = getByText(/Hello World/i);
  expect(linkElement).toBeInTheDocument();
});

test("renders heading2", () => {
  const { getByText } = render(<Heading2 />);
  const linkElement = getByText(/Hello/i);
  expect(linkElement).toBeInTheDocument();
});