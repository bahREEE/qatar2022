import React, { Fragment } from "react";
import Trash from "../../assets/svgs/Trash";
import { useHistory } from "react-router-dom";
import { Link } from "react-router-dom";
import "./list.scss";

const List = ({ items, titles, name, path, handleDelete }) => {
  const history = useHistory();

  return (
    <Fragment>
      <Link className="list__add" to={path}>
        {name}
      </Link>
      <table className="list">
        <thead>
          <tr>
            {titles?.map((title, index) => (
              <th key={index}>{title.name}</th>
            ))}
            <th className="list__action">action</th>
          </tr>
        </thead>
        <tbody>
          {items?.map((item) => (
            <tr key={item.id}>
              {titles.map((title, index) => (
                <td key={index}>{item[title.label]}</td>
              ))}
              <td className="list__icons">
                <Trash
                  className=" list__icon list__icon--trash"
                  handleDelete={handleDelete}
                  id={item.id}
                />
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </Fragment>
  );
};

export default List;
