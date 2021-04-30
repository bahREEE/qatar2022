import React, { useState, useEffect } from "react";
import Card from "../../Components/Card/Card";
import { TeamApi } from "../../services/api";
import { useParams } from "react-router-dom";
import "./team.css";

const Team = () => {
  const { id } = useParams();
  const [equipe, setEquipe] = useState(null);
  useEffect(() => {
    const fetchData = async () => {
      try {
        const { data } = await TeamApi(id);
        setEquipe(data);
      } catch (error) {
        console.log(error.message);
      }
    };
    fetchData();
  }, []);

  const getPlayerWithPositon = (position) => {
    return equipe?.listJoueurs.filter((joueur) => joueur.position === position);
  };

  return (
    <div className="team">
      <div className="team__positions">
        <div className="team__goalkeeper team__position">
          {getPlayerWithPositon("GOALKEEPER")?.map((joueur) => (
            <Card
              key={joueur?.joueurId}
              className="team__player team__goalkeeper--1"
              joueur={joueur}
            />
          ))}
        </div>
        <div className="team__defender team__position">
          {getPlayerWithPositon("DEFENDER")?.map((joueur, index) => (
            <Card
              key={joueur?.joueurId}
              className={`team__player  team__defender--${index + 1}`}
              joueur={joueur}
            />
          ))}
        </div>
        <div className="team__midfielder team__position">
          {getPlayerWithPositon("MIDFIELDER")?.map((joueur, index) => (
            <Card
              key={joueur?.joueurId}
              className={`team__player  team__midfielder--${index + 1}`}
              joueur={joueur}
            />
          ))}
        </div>
        <div className="team__forward team__position">
          {getPlayerWithPositon("FORWARD")?.map((joueur, index) => (
            <Card
              key={joueur?.joueurId}
              className={`team__player  team__forward--${index + 1}`}
              joueur={joueur}
            />
          ))}
        </div>
      </div>
      <div className="team__flag">
        <img
          src={`data:image/png;base64,${equipe?.base64image}`}
          alt="team_flag--img"
          className="team__flag"
        />
        <h6 className="team__name">{equipe?.equipeName}</h6>
      </div>
    </div>
  );
};

export default Team;
