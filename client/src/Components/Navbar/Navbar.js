import React from 'react'
const Navbar = () => {
    return (
        <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark scrolling-navbar">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">            
          <img src="logo.png" alt="" width="48" height="48"/>
           Qatar world cup 2022</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Login</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="signup">Signup</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    )
}
export default Navbar