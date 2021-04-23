import React, { useState } from "react";
import { Switch, Route, Redirect } from "react-router-dom";
import Login from "./Pages/Login/Login";
import Notification from "./Components/notifications/Notifications";
import Cross from "./assets/svgs/Cross";
import Check from "./assets/svgs/Check";
import Info from "./assets/svgs/info";
import "./BoostStyles/styles.css";
import "./App.css";
import Games from "./Pages/Matches/Games";
import Team from "./Pages/Team/Team";

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
          console.log("erro");
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
        <Route
          path="/login"
          exact
          render={(props) => (
            <Login props={props} setNotification={setNotification} />
          )}
        />
        <Route path="/games" component={Games} />
        <Route path="/team" component={Team} />
        <Redirect to="/login" />
      </Switch>
      {render && <Notification informations={informations} />}
    </div>
  );
};

export default App;
