import React, { useState } from "react";

const InputElementHistory = () => {
  const [inputText, SetInputText] = useState(""); // Hook State
  const [historyList, SetHistoryList] = useState([] as string[]); // Hook State

  return (
    <div>
      <input
        onChange={(event: React.ChangeEvent<HTMLInputElement>) => {
          SetInputText(event.target.value);
          SetHistoryList([...historyList, event.target.value]);
        }}
        placeholder="Enter Some Text"
      />
      <br />
      {inputText}
      <br />
      <ul>
        {historyList.map((rec: string) => {
          return <div>{rec}</div>;
        })}
      </ul>
    </div>
  );
};

export default InputElementHistory;
