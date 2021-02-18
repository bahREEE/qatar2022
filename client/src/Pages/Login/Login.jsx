import React from "react";
import { Link } from "react-router-dom";
import Footsvg from "../../assets/svgs/Footsvg";
import Keysvg from "../../assets/svgs/Keysvg";
import Usersvg from "../../assets/svgs/Usersvg";
import LoginInput from "../../Components/LoginInput";

import "./login.css";

const Login = () => {
  return (
    <div className="login__bg">
      <div className="login__container">
        <Footsvg />

        <form className="login__form">
          <LoginInput
            
            name="user"
            id="user"
            type="text"
            placeholder="Username"
            autoFocus
          >
            <Usersvg />
          </LoginInput>
          <LoginInput
       
            name="password"
            id="password"
            type="password"
            placeholder="Password"
          >
            <Keysvg />
          </LoginInput>
        </form>

        <Link className="login__btn">Login</Link>
      </div>
    </div>
  );
};

export default Login;
