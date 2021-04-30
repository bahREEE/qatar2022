import React from "react";

import { Route, Redirect } from "react-router-dom";

const UnProtectedRoute = ({
  component: Component,
  setNotification,
  ...rest
}) => {
  const user = JSON.parse(localStorage.getItem("user"));
  return (
    <Route
      {...rest}
      render={(props) =>
        !user ? (
          <Component {...props} setNotification={setNotification} />
        ) : (
          <Redirect to="/games" />
        )
      }
    />
  );
};

export default UnProtectedRoute;
