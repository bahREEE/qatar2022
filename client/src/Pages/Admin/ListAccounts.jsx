import React, { useState, useEffect } from "react";
import List from "../../Components/List/List";
import { accountList } from "../../Constant/Lists/adminLists";
import { deleteUser, getUsers } from "../../services/api";

const ListAccounts = () => {
  const [accounts, setAccounts] = useState([]);
  useEffect(() => {
    const fetchData = async () => {
      try {
        const { data } = await getUsers();
        const users = data.filter((user) =>
          user.roles.some((auth) => auth.roleName === "ROLE_USER")
        );
        setAccounts(
          users.map((user) => ({
            ...user,
            role: user.roles.reduce((prev, curr) => {
              return prev + " " + curr.roleName;
            }, ""),
          }))
        );
      } catch (error) {
        console.log(error.message);
      }
    };

    fetchData();
  }, []);

  const handleDelete = async (id) => {
    try {
      await deleteUser(id);

      setAccounts(accounts.filter((account) => account.id !== id));
    } catch (error) {
      console.log(error.message);
    }
  };
  return (
    <List
      titles={accountList}
      items={accounts}
      handleDelete={handleDelete}
      name="Add Account"
      path="/admin/addAccount"
    />
  );
};

export default ListAccounts;
