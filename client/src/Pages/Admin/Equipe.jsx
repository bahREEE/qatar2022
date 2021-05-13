import React from "react";
import Select from "react-select";
const Equipe = ({ options, setEquipe, equipe, name }) => {
  const handleChange = (eq) => {
    setEquipe(eq.value, name);
  };
  return (
    <div className="equipe">
      <Select
        placeholder="Select a team ..."
        onChange={handleChange}
        options={options}
      />

      {equipe && (
        <img
          src={`data:image/png;base64,${equipe}`}
          alt={name}
          className="equipe__photo"
        />
      )}
    </div>
  );
};

export default Equipe;
