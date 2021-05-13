import React from "react";

const Container = ({ children, title }) => {
  return (
    <div className="container">
      <h1 className="container__title">{title}</h1>

      {children}
    </div>
  );
};

export default Container;
