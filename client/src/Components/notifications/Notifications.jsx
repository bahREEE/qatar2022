import React from "react";

import "./notification.css";

const Notification = ({ informations }) => {
  return (
    <div className="notif__bg" style={informations.styles}>
      <div className="notif__container">
        {informations.Icon}
        <p className="notif__para">{informations.message}</p>
      </div>
    </div>
  );
};

export default Notification;
