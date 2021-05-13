import React, { useState } from "react";
import DashItem from "./DashItem";
import "./dashboard.scss";
import { Link } from "react-router-dom/cjs/react-router-dom.min";

const Dashboard = ({ dashboard, DefaultIdentif }) => {
  const [active, setActive] = useState(DefaultIdentif);
  const handleActive = (newActive) => {
    setActive(newActive);
  };
  return (
    <nav className="dashboard">
      <ul className="dashboard__list">
        {dashboard?.map((item, index) => (
          <DashItem
            key={index}
            item={item}
            active={active === item.identif}
            handleActive={handleActive}
            onClick={item.onclick}
          />
        ))}
      </ul>
    </nav>
  );
};

export default Dashboard;
