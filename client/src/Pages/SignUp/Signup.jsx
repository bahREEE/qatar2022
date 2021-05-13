import React, { useState } from "react";
import Footsvg from "../../assets/svgs/Footsvg";
import Button from "../../Components/Button/Button";
import LoginInput from "../../Components/Inputs/LoginInput";
import { Link } from "react-router-dom";
import { signup } from "../../services/api";
import "./signup.css";

const Signup = ({ setNotification }) => {
  const [user, setUser] = useState({
    username: "",
    password: "",
    email: "",
    confirmedPassword: "",
  });
  const [errorsInputs, setErrorInputs] = useState({
    username: "",
    password: "",
    email: "",
    confirmedPassword: "",
  });

  const changeUser = (champ, data) => {
    setErrorInputs({ ...errorsInputs, [champ]: "" });
    setUser({ ...user, [champ]: data });
  };

  const checkErrors = () => {
    const errors = {
      username: "",
      password: "",
      confirmedPassword: "",
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
    if (!user.confirmedPassword) {
      errors.confirmedPassword = "Please Verify your Username";
      foundError = true;
    }

    if (user.confirmedPassword !== user.password) {
      errors.password = "Please Verify your password";
      errors.confirmedPassword = "Please Verify your password";
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
      //  console.log({ ...user, role: "ROLE_USER" });
      const { data } = await signup({ ...user, role: "ROLE_USER" });
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
      setErrorInputs({
        username: "username",
        password: "password",
        confirmedPassword: "confirm",
        email: "email",
      });
      setNotification("Verifier votre données", "Error");
      console.log(error.message);
    }
  };

  return (
    <div className="login__bg">
      <div className="login__container">
        <Footsvg className="login__logo-icon" />
        <form className="sign__form" onSubmit={(e) => Submit(e)}>
          <LoginInput
            name="username"
            id="user"
            type="text"
            placeholder="Username"
            value={user.username}
            changeUser={changeUser}
            autoFocus
            errorInput={errorsInputs.username}
          />
          <LoginInput
            name="email"
            id="email"
            type="email"
            placeholder="Email"
            value={user.email}
            changeUser={changeUser}
            autoFocus
            errorInput={errorsInputs.email}
            required
          />
          <LoginInput
            name="password"
            id="password"
            type="password"
            placeholder="Password"
            value={user.password}
            errorInput={errorsInputs.password}
            changeUser={changeUser}
          />
          <LoginInput
            name="confirmedPassword"
            id="confirm"
            type="password"
            placeholder="Confirm password"
            value={user.confirmedPassword}
            changeUser={changeUser}
            autoFocus
            errorInput={errorsInputs.confirmedPassword}
          />
          <div className="elem-center">
            <Button type="submit" text="Sign up" />
          </div>
        </form>
        <Link to="/login" className="login__sign">
          login
        </Link>
      </div>
    </div>
  );
};

export default Signup;
