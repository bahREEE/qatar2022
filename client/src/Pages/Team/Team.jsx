import React from "react";
import team from "../../assets/Images/argentina.jpg";
import "./team.css";

const Team = () => {
  return (
    <div className="team">
      <div className="team__flag">
        <img src={team} alt="team_flag--img" className="team__flag" />
        <h6 className="team__name">Argentina</h6>
      </div>
    </div>
  );
};

export default Team;
