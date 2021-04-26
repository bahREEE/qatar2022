import React from "react";
import messi from "../../assets/Images/messi.png";
import "./card.css";

const Card = ({ className }) => {
  return (
    <card className={className}>
      <div className="card__fisrt player">
        <img src={messi} alt="player__photo" className="player__img" />
      </div>
      <div className="card__second player">
        <div className="player__container">
          <span className="player__name">Lionnel Messi</span>
          <p className="player__number">- 10 -</p>
        </div>
      </div>
    </card>
  );
};

export default Card;
