import axios from "axios";

const url = "http://localhost:8080";
const prefix = "Bearer";

export const Matches = async () => {
  return await axios.get(`${url}/matches/`, {
    headers: {
      Authorization: `${prefix} ${localStorage.getItem("token")}`,
    },
  });
};

export const TeamApi = async (id) => {
  return await axios.get(`${url}/equipes/` + id, {
    headers: {
      Authorization: `${prefix} ${localStorage.getItem("token")}`,
    },
  });
};

export const login = async (user) => {
  return await axios.post(`${url}/login/`, user);
};
