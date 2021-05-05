import React, { Component, Route, Router } from "react";
import logo from "../img/logook.jpg";
import HirdetesekComponent from "./HirdetesekComponent";
import { NavLink } from "react-router-dom";
import jwtDecode from "jwt-decode";

class Header extends Component {
  constructor(props) {
    super(props);
    this.state = {
      activated: false,
      activatedLogin: false,
      body: null,
      headers: null,
      userData: {},
      authorities: [],
      username: "",
      password: "",
    };
  }
  componentDidMount() {
    let token = localStorage.getItem("user");
    const { authorities } = jwtDecode(token);
    this.setState({ authorities: authorities });
    console.log(this.state.authorities);
    // let token = localStorage.getItem("user");
    // const { exp } = jwtDecode(token);
    // const expirationTime = exp * 1000 - 60000;
    // if (Date.now() >= expirationTime) {
    //   localStorage.clear();
    // }
    // console.log(expirationTime, " / ", Date.now());
  }

  loginClk() {
    // this.setState({ userData: JSON.parse(localStorage.getItem("testL")) });
    // console.log(JSON.parse(localStorage.getItem("testL")));
    var xhttp = new XMLHttpRequest();
    console.log("1");
    console.log(this.state.authorities);

    // console.log(this.state.email, this.state.password);
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        console.log("response:", this);
        localStorage.setItem("user", this.response);
        alert("login success");
      }
    };
    let data =
      "grant_type=password&username=" +
      this.state.username +
      "&password=" +
      this.state.password;
    xhttp.open("POST", "http://localhost:8090/oauth/token", true);
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhttp.setRequestHeader("Authorization", "Basic " + btoa("CLIENTID:SECRET"));
    xhttp.send(data);
    console.log("4");

    // let saved = JSON.parse(localStorage.getItem("user"));
    // console.log(saved.expires_in);
    // console.log(saved.expires_in, " / ", Date.now);
    // if (saved.expires_in < Date.now)
    //   console.log(saved.expires_in, " / ", Date.now);
    // that.forceUpdate();
    // this.setState({ userData: JSON.parse(localStorage.getItem("testL")) });
    // this.setState({ userData: valami });
    // console.log(this.state.userData);
  }
  changeEmailHandler = (event) => {
    this.setState({ username: event.target.value });
    console.log(this.state.username);
  };

  changePasswordHandler = (event) => {
    this.setState({ password: event.target.value });
    console.log(this.state.password);
  };

  loginMenu = () => {
    this.setState({
      activatedLogin: !this.state.activatedLogin,
    });
  };
  toggleMenu = () => {
    this.setState({
      activated: !this.state.activated,
    });
  };
  render() {
    const activat = this.state.activated ? "show" : "";
    const activated = this.state.activatedLogin ? "show-login" : "";
    return (
      <div className="header-container">
        <div className="header-row">
          <div id="logo">
            <img src={logo} alt="logo" className="header-pic" />
          </div>

          <div id="menu">
            <nav id="navbar">
              <ul className="menu-items">
                <li>
                  <NavLink activeClassName="active" to={"/"}>
                    Pagina principală
                  </NavLink>
                </li>
                <li>
                  <NavLink activeClassName="active" to={"/fajtaleirasok"}>
                    Descrieri de rasă
                  </NavLink>
                </li>
                <li>
                  <NavLink activeClassName="active" to={"/hirdetesek"}>
                    Anunțuri
                  </NavLink>
                </li>
                <li>
                  <NavLink activeClassName="active" to={"/rolunk"}>
                    Despre noi
                  </NavLink>
                </li>
                <li>
                  <NavLink activeClassName="active" to={"/kapcsolat"}>
                    Contact
                  </NavLink>
                </li>
              </ul>
            </nav>
          </div>
          <div id="right-navbar">
            <i
              className="fa fa-bars"
              id="mobilmenu"
              onClick={this.toggleMenu}
              aria-hidden="true"
            ></i>
            <ul className={`mobil-menu-items${activat}`}>
              <li>
                <NavLink activeClassName="active" to={"/"}>
                  Pagina principală
                </NavLink>
              </li>
              <li>
                <NavLink activeClassName="active" to={"/fajtaleirasok"}>
                  Descrieri de rasă
                </NavLink>
              </li>
              <li>
                <NavLink activeClassName="active" to={"/hirdetesek"}>
                  Anunțuri
                </NavLink>
              </li>
              <li>Despre noi</li>
              <li>
                <NavLink activeClassName="active" to={"/kapcsolat"}>
                  Contact
                </NavLink>
              </li>
            </ul>

            <i
              className="fa fa-user"
              aria-hidden="true"
              id="userIcon"
              onClick={this.loginMenu}
            ></i>
            <ul className={`login-items${activated}`}>
              <div className="loginDiv">
                <div>
                  <input
                    type="text"
                    name="userName"
                    id=""
                    placeHolder="email"
                    onChange={this.changeEmailHandler}
                  />
                </div>
                <div>
                  <input
                    type="password"
                    name="password"
                    id=""
                    placeHolder="Password"
                    onChange={this.changePasswordHandler}
                  />
                </div>
                <div>
                  <button
                    onClick={this.loginClk.bind(this)}
                    className="loginBtn"
                  >
                    Login
                  </button>
                </div>
              </div>
              {this.state.authorities.map((auth) => {
                if (auth === "ROLE_SUPERADMIN")
                  return (
                    <ul style={{ paddingLeft: 0 }}>
                      <li>
                        <NavLink activeClassName="active" to={"/hirdeteseim"}>
                          Adaugă un anunț
                        </NavLink>
                      </li>
                      <li>
                        <NavLink activeClassName="active" to={"/tagok"}>
                          Membri
                        </NavLink>
                      </li>
                      <li>
                        <NavLink activeClassName="active" to={"/kereskuld"}>
                          Trimite cerere
                        </NavLink>
                      </li>
                      <li>
                        <NavLink activeClassName="active" to={"/keresek"}>
                          Cereri
                        </NavLink>
                      </li>
                      <li>
                        <NavLink activeClassName="active" to={"/adminpanel"}>
                          Actualizare date
                        </NavLink>
                      </li>
                    </ul>
                  );
                if (auth === "ROLE_ADMIN")
                  return (
                    <ul style={{ paddingLeft: 0 }}>
                      <li>
                        <NavLink activeClassName="active" to={"/hirdeteseim"}>
                          Adaugă un anunț
                        </NavLink>
                      </li>
                      <li>
                        <NavLink activeClassName="active" to={"/tagok"}>
                          Membri
                        </NavLink>
                      </li>
                      <li>
                        <NavLink activeClassName="active" to={"/kereskuld"}>
                          Trimite cerere
                        </NavLink>
                      </li>
                      <li>
                        <NavLink activeClassName="active" to={"/keresek"}>
                          Cereri
                        </NavLink>
                      </li>
                    </ul>
                  );
                if (auth === "ROLE_SUPERUSER")
                  return (
                    <ul style={{ paddingLeft: 0 }}>
                      <li>
                        <NavLink activeClassName="active" to={"/hirdeteseim"}>
                          Adaugă un anunț
                        </NavLink>
                      </li>
                      <li>
                        <NavLink activeClassName="active" to={"/tagok"}>
                          Membri
                        </NavLink>
                      </li>
                      <li>
                        <NavLink activeClassName="active" to={"/kereskuld"}>
                          Trimite cerere
                        </NavLink>
                      </li>
                    </ul>
                  );
                if (auth === "ROLE_USER")
                  return (
                    <ul style={{ paddingLeft: 0 }}>
                      <li>
                        <NavLink activeClassName="active" to={"/hirdeteseim"}>
                          Adaugă un anunț
                        </NavLink>
                      </li>
                      <li>
                        <NavLink activeClassName="active" to={"/tagok"}>
                          Membri
                        </NavLink>
                      </li>
                    </ul>
                  );
              })}
              <div>
                <button className="logoutBtn">Logout</button>
              </div>
            </ul>
          </div>
        </div>
      </div>
    );
  }
}

export default Header;
