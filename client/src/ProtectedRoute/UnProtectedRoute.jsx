import React from "react";

import { Route, Redirect } from "react-router-dom";

const UnProtectedRoute = ({
  component: Component,
  setNotification,
  ...rest
}) => {
  const user = JSON.parse(localStorage.getItem("user"));

  const redirectRole = () => {
    return user.role.some((auths) => auths.authority === "ROLE_ADMIN") ? (
      <Redirect to="/games" />
    ) : (
      <Redirect to="/user" />
    );
  };
  return (
    <Route
      {...rest}
      render={(props) =>
        !user ? (
          <Component {...props} setNotification={setNotification} />
        ) : (
          redirectRole()
        )
      }
    />
  );
};

export default UnProtectedRoute;
