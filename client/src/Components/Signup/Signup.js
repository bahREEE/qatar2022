import React, { useState } from "react";
import { Link } from "react-router-dom";
const Signup = () => {
  const data = {
    first_name: "",
    last_name: "",
    nationality: "",
    email: "",
    password: "",
    confirmpassword: "",
  };
  const [loginData, setLoginData] = useState(data);
  const handleChange = (e) => {
    setLoginData({ ...loginData, [e.target.id]: e.target.value });
  };
  const {
    first_name,
    last_name,
    nationality,
    email,
    password,
    confirmpassword,
  } = loginData;
  const btn =
    first_name === "" ||
    last_name === "" ||
    nationality === "" ||
    email === "" ||
    password === "" ||
    confirmpassword === "" ? (
      <button disabled className="btnsign">
        Signup
      </button>
    ) : (
      <button className="btnsign">Signup</button>
    );
  return (
    <div className="formBoxRight">
      <div className="regform">
        <h1>Registration</h1>
        <center>
          <img width="100px" src="/author.png" />
        </center>
      </div>
      <div className="mane">
        <form>
          <div id="name">
            <h2 className="name">Name</h2>
            <input
              className="firstname"
              onChange={handleChange}
              value={loginData.first_name}
              type="text"
              name="first_name"
              id="first_name"
              required
            ></input>
            <label className="firstlabel">fisrt name</label>
            <input
              className="lastname"
              type="text"
              name="last_name"
              onChange={handleChange}
              value={loginData.last_name}
              id="last_name"
              required
            ></input>
            <label className="lastlabel">last name</label>
          </div>
          <h2 className="name">Nationality</h2>
          <input
            className="company"
            type="text"
            name="nationality"
            id="nationality"
            onChange={handleChange}
            value={loginData.nationality}
            required
          ></input>
          <h2 className="name">Email</h2>
          <input
            className="email"
            type="text"
            name="email"
            id="email"
            required
            onChange={handleChange}
            value={loginData.email}
          ></input>
          <h2 className="name">Password</h2>
          <input
            className="email"
            type="password"
            name="password"
            id="password"
            onChange={handleChange}
            value={loginData.password}
            required
          ></input>
          <h2 className="name">Confirm Password</h2>
          <input
            className="email2"
            type="password"
            name="confirmpassword"
            id="confirmpassword"
            onChange={handleChange}
            value={loginData.confirmpassword}
            required
          ></input>
        </form>
        {btn}
      </div>
    </div>
  );
};
export default Signup;
