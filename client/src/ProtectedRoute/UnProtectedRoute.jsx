import React from "react";

import { Route, Redirect } from "react-router-dom";

const UnProtectedRoute = ({
  component: Component,
  setNotification,
  ...rest
}) => {
  const user = JSON.parse(localStorage.getItem("user"));

  const redirectRole = () => {
    if (user) {
      if (user.role.some((auths) => auths.authority === "ROLE_USER"))
        return <Redirect to="/user/games" />;
      else if (user.role.some((auths) => auths.authority === "ROLE_ADMIN"))
        return <Redirect to="/admin/games" />;
      return <Redirect to="/login" />;
    }
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
