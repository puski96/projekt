import React, { Component } from "react";
import img1 from "../img/nature3.jpg";

class KapcsolatComponent extends Component {
  render() {
    return (
      <div>
        <img src={img1} height="600px" width="100%" alt="img1" />
        <div className="in-left" id="in-leftPic">
          <h1>Ai nevoie de ajutor?</h1>
          <div>
            ide is fog jonni szoveg csak meg nem tudom hogy mit tegyek be,
            valamit ami fontos lehet
          </div>
        </div>
        <div className="msgContainer">
          <div className="titleMsg">
            <h3>Putem sa te ajutăm?</h3>
            <p>
              Ide is jon majd egy szoveg, kb hogy miben segithetunk ird meg
              nekunk es mihamarabb valaszolunk
            </p>
          </div>
          <div className="inputDiv">
            <div>
              <input type="text" name="firstName" id="" value="Csaladnev" />
            </div>
            <div>
              <input type="text" name="lastName" id="" value="Keresztnev" />
            </div>
            <div>
              <input type="text" name="email" id="" value="Email" />
            </div>
            <div>
              <input type="text" name="telefon" id="" value="Telefon" />
            </div>
          </div>
          <div className="textDiv">
            <textarea
              name="szoveg"
              id=""
              cols="30"
              rows="10"
              value="Szoveg"
            ></textarea>
          </div>
          <div className="msgBtn">
            <button>Trimite un mesaj</button>
          </div>
        </div>
      </div>
    );
  }
}

export default KapcsolatComponent;
