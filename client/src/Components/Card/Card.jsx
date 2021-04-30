import React from "react";
import "./card.css";

const Card = ({ className, joueur }) => {
  return (
    <card className={className}>
      <div className="card__fisrt player">
        <img
          src={`data:image/png;base64,${joueur && joueur["64baseImage"]}`}
          alt="player__photo"
          className="player__img"
        />
      </div>
      <div className="card__second player">
        <div className="player__container">
          <span className="player__name">{`${joueur?.jfirst} ${joueur?.jlast}`}</span>
          <p className="player__number">- {joueur?.jnumber} -</p>
        </div>
      </div>
    </card>
  );
};

export default Card;
