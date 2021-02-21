import React from 'react'
import { BrowserRouter, BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import './App.css';
import Navbar from './Components/Navbar/Navbar'
import Landing from './Components/Landing/Landing'
import Footer from './Components/Footer/Footer'
import Signup from './Components/Signup/Signup'
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    <BrowserRouter>
      <Navbar/>
      <Switch>
      <Route exact path="/" component={Landing}/>
      <Route path="/signup" component={Signup}/>
      </Switch>
      <Footer/>
    </BrowserRouter>
 
  );
}

export default App;
