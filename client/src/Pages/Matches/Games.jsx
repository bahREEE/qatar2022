import React from "react";
import team from "../../assets/Images/argentina.jpg";
import "./games.css";

const Games = () => {
  return (
    <div className="games">
      <h1 className="games__title">FIFA Club World Cup Qatar 2020™</h1>

      <div className="games__list">
        <div className="games__item">
          <div className="games__team ">
            <h2 className="games__team--name">Argentina</h2>
            <img
              src={team}
              alt="team_photo--img"
              className="games__team--img"
            />
          </div>
          <h1 className="games__vs">VS</h1>
          <div className="games__team">
            <img src={team} alt="team_photo-img" className="games__team--img" />
            <h2 className="games__team--name">Argentina</h2>
          </div>
        </div>
        <div className="games__item">
          <div className="games__team ">
            <h2 className="games__team--name">Argentina</h2>
            <img
              src={team}
              alt="team_photo--img"
              className="games__team--img"
            />
          </div>
          <h1 className="games__vs">VS</h1>
          <div className="games__team">
            <img src={team} alt="team_photo-img" className="games__team--img" />
            <h2 className="games__team--name">Argentina</h2>
          </div>
        </div>
        <div className="games__item">
          <div className="games__team ">
            <h2 className="games__team--name">Argentina</h2>
            <img
              src={team}
              alt="team_photo--img"
              className="games__team--img"
            />
          </div>
          <h1 className="games__vs">VS</h1>
          <div className="games__team">
            <img src={team} alt="team_photo-img" className="games__team--img" />
            <h2 className="games__team--name">Argentina</h2>
          </div>
        </div>
        <div className="games__item">
          <div className="games__team ">
            <h2 className="games__team--name">Argentina</h2>
            <img
              src={team}
              alt="team_photo--img"
              className="games__team--img"
            />
          </div>
          <h1 className="games__vs">VS</h1>
          <div className="games__team">
            <img src={team} alt="team_photo-img" className="games__team--img" />
            <h2 className="games__team--name">Argentina</h2>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Games;
