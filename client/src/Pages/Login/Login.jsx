import React, { useState } from "react";
import { Link } from "react-router-dom";
import Footsvg from "../../assets/svgs/Footsvg";
import Keysvg from "../../assets/svgs/Keysvg";
import Usersvg from "../../assets/svgs/Usersvg";
import Button from "../../Components/Button/Button";
import LoginInput from "../../Components/Inputs/LoginInput";
import "./login.css";

const Login = ({ setNotification }) => {
  const [user, setUser] = useState({ username: "", password: "" });
  const [errorsInputs, setErrorInputs] = useState({
    username: "",
    password: "",
  });

  const changeUser = (champ, data) => {
    setErrorInputs({ ...errorsInputs, [champ]: "" });
    setUser({ ...user, [champ]: data });
  };

  const Submit = (e) => {
    e.preventDefault();

    if (!user.password) {
      setErrorInputs({
        ...errorsInputs,
        password: "Please Verify your Password",
      });
    }
    if (!user.username) {
      setErrorInputs({
        ...errorsInputs,
        username: "Please Verify your Username",
      });
    }

    if (user.username === "Helmy" && user.password === "helmy")
      setNotification("Hey Admin ;)", "Success");
    else {
      setNotification("Verifier votre données", "Error");
    }
  };

  return (
    <div className="login__bg">
      <div className="login__container" onSubmit={(e) => Submit(e)}>
        <Footsvg className="login__logo-icon" />
        <form className="login__form">
          <LoginInput
            name="username"
            id="user"
            type="text"
            placeholder="Username"
            value={user.username}
            changeUser={changeUser}
            autoFocus
            errorInput={errorsInputs.username}
          >
            <Usersvg className="input__icon" />
          </LoginInput>
          <LoginInput
            name="password"
            id="password"
            type="password"
            placeholder="Password"
            value={user.password}
            errorInput={errorsInputs.password}
            changeUser={changeUser}
          >
            <Keysvg className="input__icon" />
          </LoginInput>
          <div className="elem-center">
            <Button type="submit" text="Login" />
          </div>
        </form>
      </div>
    </div>
  );
};

export default Login;
