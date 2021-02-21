import React, { useState } from "react";
import Navbar from "./Components/Navbar/Navbar";
import Landing from "./Components/Landing/Landing";
import Footer from "./Components/Footer/Footer";
import Signup from "./Components/Signup/Signup";
import Login from "./Pages/Login/Login";
import { Switch, Route, Redirect } from "react-router-dom";
import Notification from "./Components/notifications/Notifications";
import Cross from "./assets/svgs/Cross";
import Check from "./assets/svgs/Check";
import Info from "./assets/svgs/info";
import "./BoostStyles/styles.css";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

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
      <Navbar />
      <Switch>
        <Route
          path="/login"
          exact
          render={(props) => (
            <Login props={props} setNotification={setNotification} />
          )}
        />
        <Route exact path="/" exact component={Landing} />
        <Route path="/signup" exact component={Signup} />
        <Redirect to="/" />
      </Switch>
      <Footer />
      {render && <Notification informations={informations} />}
    </div>
  );
};

export default App;
