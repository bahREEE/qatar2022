import React from "react";
import "./input.css";

const LoginInput = ({
  value,
  name,
  type,
  id,
  placeholder,
  autoFocus,
  children,
  changeUser,
  errorInput,
}) => {
  return (
    <div
      className="login__input"
      style={{
        color: errorInput && "red",
        borderBottom: errorInput && "3px solid red",
      }}
    >
      {children}
      <input
        required
        autoFocus={autoFocus}
        name={name}
        type={type}
        placeholder={placeholder}
        id={id}
        className="input--1"
        value={value}
        onChange={(e) => changeUser(name, e.target.value)}
      />
    </div>
  );
};

export default LoginInput;
