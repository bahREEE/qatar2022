import React, { Fragment, useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { Matches } from "../../services/api";

const ListMatches = () => {
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
  return (
    <Fragment>
      {matches?.map((match) => (
        <Fragment>
          <h1>{match.groupe.groupeName}</h1>
          <div className="games__list">
            <div className="games__item">
              <div className="games__team">
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
              <div className="games__team">
                <img
                  src={`data:image/png;base64,${match.equipe2.base64image}`}
                  alt="team_photo-img"
                  className="games__team--img"
                />
                <h2 className="games__team--name">
                  {" "}
                  {match.equipe2.equipeName}
                </h2>
              </div>
            </div>
          </div>
        </Fragment>
      ))}

      <Link to="/admin/addGame" className="addList">
        ADD Match
      </Link>
    </Fragment>
  );
};

export default ListMatches;
