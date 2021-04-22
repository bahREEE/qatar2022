import React from "react";
import "./input.css";

const LoginInput = ({
  value,
  name,
  type,
  id,
  placeholder,
  autoFocus,
  changeUser,
  errorInput,
}) => {
  return (
    <input
      autoFocus={autoFocus}
      name={name}
      type={type}
      placeholder={placeholder}
      id={id}
      className={`input--1 ${errorInput && "input--1-error"}`}
      value={value}
      onChange={(e) => changeUser(name, e.target.value)}
    />
  );
};

export default LoginInput;
