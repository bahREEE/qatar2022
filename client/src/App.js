<<<<<<< HEAD
import React from 'react'
import { BrowserRouter, BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import './App.css';
import Navbar from './Components/Navbar/Navbar'
import Landing from './Components/Landing/Landing'
import Footer from './Components/Footer/Footer'
import Signup from './Components/Signup/Signup'
import 'bootstrap/dist/css/bootstrap.min.css';
=======
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
>>>>>>> 9c19a81751de2b820e6f4309417c4b9a86a9b1a9

  return (
<<<<<<< HEAD
    <BrowserRouter>
      <Navbar/>
      <Switch>
      <Route exact path="/" component={Landing}/>
      <Route path="/signup" component={Signup}/>
      </Switch>
      <Footer/>
    </BrowserRouter>
 
=======
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
>>>>>>> 9c19a81751de2b820e6f4309417c4b9a86a9b1a9
  );
};

export default App;
