import React from "react";

import { Route, Redirect } from "react-router-dom";

const ProtectedRoute = ({ role, component: Component, ...rest }) => {
  const user = JSON.parse(localStorage.getItem("user"));
  console.log(rest.path);
  return (
    <Route
      {...rest}
      render={(props) =>
        user &&
        user?.role.length !== 0 &&
        user?.role.some((auths) => auths.authority === role) ? (
          <Component {...props} />
        ) : (
          <Redirect to="/login" />
        )
      }
    />
  );
};

export default ProtectedRoute;
