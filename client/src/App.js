import Login from "./Pages/Login/Login";
import { Switch, Route, Redirect } from "react-router-dom";
import "./BoostStyles/styles.css";
function App() {
  return (
    <div className="App">
      <Switch>
        <Route path="/" exact component={Login} />
        <Redirect to="/" />
      </Switch>
    </div>
  );
}

export default App;
