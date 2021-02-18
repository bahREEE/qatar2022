import React from "react";
import "./input.css";

const LoginInput = ({ name, type, id, placeholder, autoFocus, children }) => {
  return (
    <div className="login__input">
      {children}
      <input
        required
        autoFocus={autoFocus}
        name={name}
        type={type}
        placeholder={placeholder}
        id={id}
        className="input--1"
      />
    </div>
  );
};

export default LoginInput;
