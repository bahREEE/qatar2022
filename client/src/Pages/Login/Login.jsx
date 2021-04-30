import React, { useState } from "react";
import Footsvg from "../../assets/svgs/Footsvg";
import Keysvg from "../../assets/svgs/Keysvg";
import Usersvg from "../../assets/svgs/Usersvg";
import Button from "../../Components/Button/Button";
import LoginInput from "../../Components/Inputs/LoginInput";
import { login } from "../../services/api";
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

  const checkErrors = () => {
    const errors = {
      username: "",
      password: "",
    };
    let foundError = false;

    if (!user.password) {
      errors.password = "Please Verify your Password";
      foundError = true;
    }
    if (!user.username) {
      errors.username = "Please Verify your Username";
      foundError = true;
    }

    setErrorInputs(errors);
    return foundError;
  };

  const Submit = async (e) => {
    e.preventDefault();

    if (checkErrors()) {
      setNotification("Saisir votre données", "Error");
      return;
    }

    try {
      const { data } = await login(user);
      localStorage.setItem(
        "user",
        JSON.stringify({
          username: data.user.username,
          role: data.user.authorities,
        })
      );
      localStorage.setItem("token", data.token);

      setNotification("Welocome Home", "Success");
    } catch (error) {
      setErrorInputs({ username: "a", password: "5" });
      setNotification("Verifier votre données", "Error");
      console.log(error.message);
    }
    /*  if (user.username === "Helmy" && user.password === "helmy")
      setNotification("Hey Admin ;)", "Success");*/
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
