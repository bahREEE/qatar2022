import React, { useState, useEffect } from "react";
import List from "../../Components/List/List";
import { groupList } from "../../Constant/Lists/adminLists";
import { deleteGroups, getGroups } from "../../services/api";

const ListGroup = () => {
  const [groups, setGroups] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const { data } = await getGroups();
        setGroups(data);
      } catch (error) {
        console.log(error.message);
      }
    };

    fetchData();
  }, []);

  const handleDelete = async (id) => {
    try {
      await deleteGroups(id);

      setGroups(groups.filter((group) => group.id !== id));
    } catch (error) {
      console.log(error.message);
    }
  };
  return (
    <List
      titles={groupList}
      items={groups}
      handleDelete={handleDelete}
      name="Add Group"
      path="/admin/addGroup"
    />
  );
};

export default ListGroup;
