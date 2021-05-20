import React, { useEffect, useState } from "react";
import { useHistory } from "react-router-dom";
import { Matches } from "../../services/api";
import "./games.css";

const Games = () => {
  const history = useHistory();
  const [matches, setMatches] = useState([]);
  useEffect(() => {
    const fetchData = async () => {
      try {
        const { data } = await Matches();
        setMatches(data);
      } catch (error) {
        console.log(error.message);
      }
    };
    fetchData();
  }, []);

  const CheckTeam = (id) => {
    console.log(id);
    history.push(`/user/team/${id}`);
  };

  return (
    <div className="games">
      <h1 className="games__title">FIFA Club World Cup Qatar 2020™</h1>

      <div className="games__list">
        {matches.length !== 0 &&
          matches.map((match) => (
            <div key={match.matchId} className="games__item">
              <div
                className="games__team "
                onClick={() => CheckTeam(match.equipe1.id)}
              >
                <h2 className="games__team--name">
                  {match.equipe1.equipeName}
                </h2>
                <img
                  src={`data:image/png;base64,${match.equipe1.base64image}`}
                  alt="team_photo--img"
                  className="games__team--img"
                />
              </div>
              <h1 className="games__vs">VS</h1>
              <div
                className="games__team"
                onClick={() => CheckTeam(match.equipe2.id)}
              >
                <img
                  src={`data:image/png;base64,${match.equipe2.base64image}`}
                  alt="team_photo-img"
                  className="games__team--img"
                />
                <h2 className="games__team--name">
                  {match.equipe2.equipeName}
                </h2>
              </div>
            </div>
          ))}
      </div>
    </div>
  );
};

export default Games;
