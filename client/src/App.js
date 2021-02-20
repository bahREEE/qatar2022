import Login from "./Pages/Login/Login";
import { Switch, Route, Redirect } from "react-router-dom";
import Notification from "./Components/notifications/Notifications";
import "./BoostStyles/styles.css";

function App() {
  return (
    <div className="App">
      <Switch>
        <Route path="/" exact component={Login} />
        <Redirect to="/" />
      </Switch>
      <Notification />
    </div>
  );
}

export default App;
