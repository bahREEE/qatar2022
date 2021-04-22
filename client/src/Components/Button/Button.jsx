import React from "react";
import "./button.css";
const Button = ({ type, text }) => {
  return (
    <button className="btn btn__submit" type={type}>
      {text}
    </button>
  );
};

export default Button;
