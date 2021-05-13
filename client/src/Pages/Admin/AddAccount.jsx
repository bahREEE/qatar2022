import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import LoginInput from "../../Components/Inputs/LoginInput";
import { addUser } from "../../services/api";

const AddAccount = () => {
  const history = useHistory();
  const [user, setUser] = useState({
    username: "",
    password: "",
    email: "",
    confirmedPassword: "",
  });

  const [errors, setErrors] = useState({
    username: "",
    password: "",
    email: "",
    confirmedPassword: "",
  });

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

    setErrors(errors);
    return foundError;
  };

  const onSubmit = async (e) => {
    e.preventDefault();

    if (!checkErrors()) {
      try {
        await addUser({ ...user, role: "ROLE_USER" });
        history.push("/admin/accounts");
      } catch (error) {
        console.log("error");
      }
    }
  };

  const handleChange = (champ, value) => {
    setUser({ ...user, [champ]: value });
    setErrors({ ...errors, [champ]: "" });
  };

  return (
    <form onSubmit={(e) => onSubmit(e)} className="group__form">
      <div className="mb-sm">
        <LoginInput
          name="username"
          type="text"
          id="username"
          placeholder="username"
          autoFocus
          changeUser={handleChange}
          errorInput={errors.username}
          required
        />
      </div>
      <div className="mb-sm">
        <LoginInput
          name="email"
          type="email"
          id="email"
          placeholder="email"
          autoFocus
          changeUser={handleChange}
          errorInput={errors.email}
          required
        />
      </div>
      <div className="mb-sm">
        <LoginInput
          name="password"
          type="password"
          id="password"
          placeholder="password"
          autoFocus
          changeUser={handleChange}
          errorInput={errors.password}
          required
        />
      </div>
      <div className="mb-sm">
        <LoginInput
          name="confirmedPassword"
          type="password"
          id="confirmedPassword"
          placeholder="confirm Password"
          autoFocus
          changeUser={handleChange}
          errorInput={errors.confirmedPassword}
          required
        />
      </div>
      <button className="btn-valid" type="submit">
        {" "}
        Save User
      </button>
    </form>
  );
};

export default AddAccount;
