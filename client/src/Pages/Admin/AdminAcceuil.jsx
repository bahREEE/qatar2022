import React from "react";
import { Switch, Route } from "react-router-dom";
import AdminContainer from "../../Components/Container/AdminContainer";
import Container from "../../Components/Container/Container";
import Dashboard from "../../Components/Dashboard/Dashboard";
import ListGroup from "./ListGoup";
import ListMatches from "./ListMatches";
import AddGroup from "./AddGroup";
import {
  adminDash,
  adminDefaultIdentif,
} from "../../Constant/Dashboards/AdminDashboard";
import "./admin.css";
import AddMatch from "./AddMatch";
import ListAccounts from "./ListAccounts";
import AddAccount from "./AddAccount";

const AdminAcceuil = () => {
  return (
    <div className="admin">
      <AdminContainer>
        <Dashboard dashboard={adminDash} DefaultIdentif={adminDefaultIdentif} />

        <Switch>
          <Route
            path="/admin/games"
            exact
            render={(props) => (
              <Container {...props} title="Matches">
                <ListMatches />
              </Container>
            )}
          />
          <Route
            path="/admin/addGame"
            exact
            render={(props) => (
              <Container {...props} title="Add Match">
                <AddMatch />
              </Container>
            )}
          />
          <Route
            path="/admin/groups"
            exact
            render={(props) => (
              <Container {...props} title="Groups">
                <ListGroup />
              </Container>
            )}
          />
          <Route
            path="/admin/addGroup"
            exact
            render={(props) => (
              <Container {...props} title="Add Group">
                <AddGroup />
              </Container>
            )}
          />
          <Route
            path="/admin/accounts"
            exact
            render={(props) => (
              <Container {...props} title="Accounts">
                <ListAccounts />
              </Container>
            )}
          />
          <Route
            path="/admin/addAccount"
            exact
            render={(props) => (
              <Container {...props} title="Add account">
                <AddAccount />
              </Container>
            )}
          />
        </Switch>
      </AdminContainer>
    </div>
  );
};

export default AdminAcceuil;
