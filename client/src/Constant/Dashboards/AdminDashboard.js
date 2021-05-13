import Footsvg from "../../assets/svgs/Footsvg";
import Logout from "../../assets/svgs/Logout";
import Person from "../../assets/svgs/Person";

const adminDefaultUrl = "/admin";
export const adminDefaultIdentif = "dashboard";
export const adminDash = [
  {
    Icon: Footsvg,
    identif: "dashboard",
    name: "Matches",
    url: `${adminDefaultUrl}/games`,
  },
  {
    Icon: Footsvg,
    identif: "groups",
    name: "Groups",
    url: `${adminDefaultUrl}/groups`,
  },

  {
    Icon: Person,
    identif: "user",
    name: "Accounts",
    url: `${adminDefaultUrl}/accounts`,
  },

  {
    Icon: Logout,
    identif: "Logout",
    name: "Logout",
    url: `/login`,
    onclick: () => {
      localStorage.clear();
    },
  },
];
/*  {
    Icon: DashIcon,
    name: "Options",
    subList: [
      { name: "Option 1", identif: "option1", url: `${adminDefaultUrl}` },
      { name: "Option 2", identif: "option2", url: `${adminDefaultUrl}` },
      { name: "Option 2", identif: "option3", url: `${adminDefaultUrl}` },
    ],
  },*/
