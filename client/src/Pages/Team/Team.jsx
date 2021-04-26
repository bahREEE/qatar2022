import React from "react";
import Card from "../../Components/Card/Card";
import team from "../../assets/Images/argentina.jpg";
import messi from "../../assets/Images/messi.png";
import "./team.css";

const Team = () => {
  return (
    <div className="team">
      <div className="team__positions">
        <div className="team__goalkeeper team__position">
          <Card className="team__player team__goalkeeper--1" />
        </div>
        <div className="team__defender team__position">
          <Card className="team__player team__defender--1" />
          <Card className="team__player team__defender--2" />
          <Card className="team__player team__defender--3" />
        </div>
        <div className="team__midfielder team__position">
          <Card className="team__player team__midfielder--1" />
          <Card className="team__player team__midfielder--2" />
          <Card className="team__player team__midfielder--3" />
        </div>
        <div className="team__forward team__position">
          <Card className="team__player team__forward--1" />
          <Card className="team__player team__forward--2" />
          <Card className="team__player team__forward--3" />
          <Card className="team__player team__forward--4" />
        </div>
      </div>
      <div className="team__flag">
        <img src={team} alt="team_flag--img" className="team__flag" />
        <h6 className="team__name">Argentina</h6>
      </div>
    </div>
  );
};

export default Team;
