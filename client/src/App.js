import React, { Fragment, useEffect, useState } from "react";
import { Switch, Redirect } from "react-router-dom";
import Login from "./Pages/Login/Login";
import Notification from "./Components/notifications/Notifications";
import Cross from "./assets/svgs/Cross";
import Check from "./assets/svgs/Check";
import Info from "./assets/svgs/info";
import "./BoostStyles/styles.css";
import "./App.css";
import Games from "./Pages/Matches/Games";
import Team from "./Pages/Team/Team";
import ProtectedRoute from "./ProtectedRoute/ProtectedRoute";
import UnProtectedRoute from "./ProtectedRoute/UnProtectedRoute";

const App = () => {
  const [render, setRender] = useState(false);
  const [informations, setInformations] = useState({
    message: "",
    color: "",
    styles: {},
    Icon: null,
  });

  const setNotification = (message, status) => {
    if (!render) {
      switch (status) {
        case "Success": {
          setInformations({
            ...informations,
            styles: { color: "green" },
            Icon: <Check />,
            message,
          });
          setRender(true);
          setTimeout(() => {
            setRender(false);
          }, 3000);
          break;
        }

        case "Error": {
          setInformations({
            ...informations,
            styles: { color: "red" },
            Icon: <Cross />,
            message,
          });
          setRender(true);
          setTimeout(() => {
            setRender(false);
          }, 3000);
          break;
        }

        default: {
          setInformations({
            ...informations,
            styles: { color: "blue" },
            Icon: <Info />,
            message,
          });
          setRender(true);
          setTimeout(() => {
            setRender(false);
          }, 3000);
          break;
        }
      }
    }
  };

  return (
    <div className="App">
      <Switch>
        <ProtectedRoute
          component={Team}
          role="ROLE_ADMIN"
          exact
          path="/team/:id"
        />
        <ProtectedRoute
          component={Games}
          role="ROLE_ADMIN"
          exact
          path="/games"
        />

        <UnProtectedRoute
          component={Login}
          setNotification={setNotification}
          exact
          path="/login"
        />
        <Redirect to="/login" />
      </Switch>
      {render && <Notification informations={informations} />}
    </div>
  );
};

export default App;
