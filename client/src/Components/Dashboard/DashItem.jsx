import React from "react";
import { NavLink } from "react-router-dom";

const DashItem = ({ active, item, handleActive, onClick }) => {
  return (
    <NavLink
      to={item.url}
      className={`dashboard__item  ${active && "dashboard__item--active"}`}
      onClick={() => {
        handleActive(item.identif);
        onClick && onClick();
      }}
    >
      <item.Icon
        className={`dashboard__icon  ${active && "dashboard__icon--active"}`}
      />
      <span
        className={`dashboard__link  ${active && "dashboard__link--active"}`}
      >
        {item.name}
      </span>
    </NavLink>
  );
};

export default DashItem;
