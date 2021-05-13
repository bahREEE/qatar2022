import React, { Fragment, useEffect, useState } from "react";
import Equipe from "./Equipe";
import Select from "react-select";
import { addMatch, getEquipes, getGroups } from "../../services/api";
import { useHistory } from "react-router-dom";
const AddMatch = () => {
  const history = useHistory();
  const [equipes, setEquipes] = useState([]);
  const [groupes, setGroupes] = useState([]);
  const [selectedEquipes, setSelectedEquipes] = useState({
    equipe1: null,
    equipe2: null,
    groupe: null,
  });

  const handleGroupeChange = (groupe) => {
    setSelectedEquipes({ ...selectedEquipes, groupe: groupe.value });
  };

  const handleEquipeChange = (value, name) => {
    setSelectedEquipes({ ...selectedEquipes, [name]: value });
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        const { data: groups } = await getGroups();
        setGroupes(
          groups.map((group) => ({
            label: group.groupeName,
            value: group,
          }))
        );

        const { data: equips } = await getEquipes();
        setEquipes(
          equips.map((equipe) => ({
            label: equipe.equipeName,
            value: equipe,
          }))
        );
      } catch (error) {
        console.log(error.message);
      }
    };

    fetchData();
  }, []);

  const add = async () => {
    if (
      selectedEquipes.equipe2 &&
      selectedEquipes.equipe1 &&
      selectedEquipes.equipe1 !== selectedEquipes.equipe2 &&
      selectedEquipes.groupe
    ) {
      const match = {
        equipe1: selectedEquipes.equipe1,
        e1goals: null,
        equipe2: selectedEquipes.equipe2,
        e2goals: null,
        horaire: "2021-06-20T20:00:00",
        matchPlayed: false,
        matchPlayoffs: false,
        groupe: selectedEquipes.groupe,
        terrain: "Rades Stadium",
      };

      try {
        await addMatch(match);
        history.push("/admin/games");
      } catch (error) {
        console.log(error.message);
      }
    }
  };

  return (
    <div className="addM">
      <div className="addM__container">
        <Equipe
          equipe={selectedEquipes.equipe1?.base64image}
          options={equipes}
          setEquipe={handleEquipeChange}
          name="equipe1"
        />
        <h1 className="games__vs equipe__vs">VS</h1>
        <Equipe
          equipe={selectedEquipes.equipe2?.base64image}
          options={equipes}
          setEquipe={handleEquipeChange}
          name="equipe2"
        />
      </div>
      <Select
        placeholder="Select a group ..."
        options={groupes}
        onChange={handleGroupeChange}
      />
      <button
        className="btn-valid equipe__btn"
        type="submit"
        onClick={() => add()}
      >
        Save Group
      </button>
    </div>
  );
};

export default AddMatch;
