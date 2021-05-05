import React, { Component } from "react";
import HirdetesService from "../service/HirdetesService";
import KepService from "../service/KepService";
import axios from "axios";

class KeresKuldComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      ar: "",
      db: "",
      nev: "",
      leiras: "",
      tulajId: "",
    };
  }

  
  saveHirdetes = (e) => {
    e.preventDefault();
    let hirdetes = {
      ar: this.state.ar,
      db: this.state.db,
      nev: this.state.nev,
      leiras: this.state.leiras,
      tulajId: 1,
    };
    
    HirdetesService.addHirdetes(hirdetes).then((res) => {});
    console.log(hirdetes);
    // bekerni a hirdetes ID-t
    //itt menteni ki a kepet
  };

  changeNevHandler = (event) => {
    this.setState({ nev: event.target.value });
    console.log(this.state.nev);
  };

  changeArHandler = (event) => {
    this.setState({ ar: event.target.value });
    console.log(this.state.ar);
  };

  changeDbHandler = (event) => {
    this.setState({ db: event.target.value });
  };

  changeLeirasHandler = (event) => {
    this.setState({ leiras: event.target.value });
  };

  render() {
    return (
      <div className="keresContainer">
        <div className="keresDiv">
          <div>
            <h2>hirdetes feladasa</h2>
            <div className="hirdetDiv">
              <input
                type="text"
                name="nev"
                id=""
                placeholder="Rasa"
                onChange={this.changeNevHandler}
              />
            </div>
            <div className="hirdetDiv">
              <input
                type="text"
                name="ar"
                id=""
                placeholder="Preț"
                onChange={this.changeArHandler}
              />
            </div>
            <div className="hirdetDiv">
              <input
                type="text"
                name="db"
                id=""
                placeholder="Buc disponibili"
                onChange={this.changeDbHandler}
              />
            </div>
            <div>
              <textarea
                name=""
                id=""
                cols="30"
                rows="10"
                placeholder="Descriere"
                onChange={this.changeLeirasHandler}
              ></textarea>
            </div>
          </div>
          <div>
            <button className="btnSalvare" onClick={this.saveHirdetes}>Trimite</button>
          </div>
          
        </div>
      </div>
    );
  }
}

export default KeresKuldComponent;
