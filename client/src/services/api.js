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

export const addMatch = async (match) => {
  return await axios.post(`${url}/matches/`, match, {
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

export const signup = async (user) => {
  return await axios.post(`${url}/signup/`, user);
};

export const addGroup = async (group) => {
  return await axios.post(`${url}/groupes/`, group, {
    headers: {
      Authorization: `${prefix} ${localStorage.getItem("token")}`,
    },
  });
};

export const getGroups = async () => {
  return await axios.get(`${url}/groupes/`, {
    headers: {
      Authorization: `${prefix} ${localStorage.getItem("token")}`,
    },
  });
};

export const deleteGroups = async (id) => {
  return await axios.delete(`${url}/groupes/${id}`, {
    headers: {
      Authorization: `${prefix} ${localStorage.getItem("token")}`,
    },
  });
};

export const getEquipes = async () => {
  return await axios.get(`${url}/equipes/`, {
    headers: {
      Authorization: `${prefix} ${localStorage.getItem("token")}`,
    },
  });
};

export const getUsers = async () => {
  return await axios.get(`${url}/users/`, {
    headers: {
      Authorization: `${prefix} ${localStorage.getItem("token")}`,
    },
  });
};

export const deleteUser = async (id) => {
  return await axios.delete(`${url}/users/${id}`, {
    headers: {
      Authorization: `${prefix} ${localStorage.getItem("token")}`,
    },
  });
};

export const addUser = async (user) => {
  return await axios.post(`${url}/users/`, user, {
    headers: {
      Authorization: `${prefix} ${localStorage.getItem("token")}`,
    },
  });
};
