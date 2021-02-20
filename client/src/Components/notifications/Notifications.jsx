import React, { useEffect, useState } from "react";
import Cross from "../../assets/svgs/Cross";
import Check from "../../assets/svgs/Check";
import Info from "../../assets/svgs/info";
import "./notification.css";

const Notification = () => {
  const [render, setRender] = useState(true);
  const [informations, setInformations] = useState({
    message: "",
    color: "",
    styles: {},
    Icon: null,
  });

  return (
    render && (
      <div className="notif__bg" style={styles}>
        <div className="notif__container">
          <Cross />
          <p className="notif__para">{message}</p>
        </div>
      </div>
    )
  );
};

export default Notification;
export function setNotification(message, status) {
  switch (status) {
    case "Success": {
      setInformations({
        ...informations,
        styles: { color: "green" },
        Icon: <Check />,
        message,
      });
      setRender(true);
      break;
    }

    case "Error": {
      setInformations({
        ...informations,
        styles: { color: "red" },
        Icon: <Cross />,
        message,
      });
      break;
    }

    default: {
      setInformations({
        ...informations,
        styles: { color: "blue" },
        Icon: <Info />,
        message,
      });
      break;
    }
  }
}
