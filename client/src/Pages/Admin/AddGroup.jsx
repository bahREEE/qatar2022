import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import LoginInput from "../../Components/Inputs/LoginInput";
import { addGroup } from "../../services/api";

const AddGroup = () => {
  const history = useHistory();
  const [group, setGroup] = useState({
    groupeName: "",
  });

  const [errors, setErrors] = useState({
    groupeName: "",
  });
  const onSubmit = async (e) => {
    e.preventDefault();
    try {
      await addGroup(group);
      history.push("/admin/groups");
    } catch (error) {
      setErrors({ groupeName: "something is wrong" });
    }
  };

  const handleChange = (champ, value) => {
    setGroup({ groupeName: value });
    setErrors({ groupeName: "" });
  };

  return (
    <form onSubmit={(e) => onSubmit(e)} className="group__form">
      <LoginInput
        name="groupeName"
        type="text"
        id="groupeName"
        placeholder="new Group"
        autoFocus
        changeUser={handleChange}
        errorInput={errors.groupeName}
        required
      />
      <button className="btn-valid" type="submit">
        {" "}
        Save Group
      </button>
    </form>
  );
};

export default AddGroup;
