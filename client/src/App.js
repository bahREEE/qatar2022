import Login from "./Pages/Login/Login";
import React, { useState } from "react";
import { Switch, Route, Redirect } from "react-router-dom";
import Notification from "./Components/notifications/Notifications";
import Cross from "./assets/svgs/Cross";
import Check from "./assets/svgs/Check";
import Info from "./assets/svgs/info";
import "./BoostStyles/styles.css";

const App = () => {
  const [render, setRender] = useState(false);
  const [informations, setInformations] = useState({
    message: "",
    color: "",
    styles: {},
    Icon: null,
  });

  const setNotification = (message, status) => {
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
        }, 2000);
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
  };

  return (
    <div className="App">
      <Switch>
        <Route
          path="/"
          exact
          render={(props) => (
            <Login props={props} setNotification={setNotification} />
          )}
        />
        <Redirect to="/" />
      </Switch>
      {render && <Notification informations={informations} />}
    </div>
  );
};

export default App;
