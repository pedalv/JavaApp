import React from "react";
import { render } from "@testing-library/react";
import { Heading2 } from "./Heading2";

test("renders heading", () => {
  const { getByText } = render(<Heading2 />);
  const linkElement = getByText(/Hello/i);
  expect(linkElement).toBeInTheDocument();
});
