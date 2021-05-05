import React, { Component } from "react";
import KeresService from "../service/KeresService";
import { Link } from "react-router-dom";
import FajtaService from "../service/FajtaService";

class KeresekComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      keresek: [],
      fajtak: [],
    };
  }

  componentDidMount() {
    FajtaService.getFajtak()
      .then((res) => {
        this.setState({ fajtak: res.data });
      })
      .catch(function (ex) {
        console.log("Response parsing failed. Error: ", ex);
      });

    KeresService.getKeresek()
      .then((res) => {
        this.setState({ keresek: res.data });
      })
      .catch(function (ex) {
        console.log("Response parsing failed. Error: ", ex);
      });
  }

  render() {
    return (
      <div>
        <table className="keresekTable">
          <thead>
            <tr>
              <th>U.D. mama</th>
              <th>U.S. mama</th>
              <th>U.D. tata</th>
              <th>U.S. tata</th>
              <th>masculi</th>
              <th>femele</th>
              <th>rasa</th>
              <th>data nașterii</th>
              <th>crescător</th>
            </tr>
          </thead>
          <tbody>
            {this.state.keresek.map((keres) => (
              <tr key={keres.id}>
                <td>{keres.anyajobbful}</td>
                <td>{keres.anyabalful}</td>
                <td>{keres.apajobbful}</td>
                <td>{keres.apabalful}</td>
                <td>{keres.bakok}</td>
                <td>{keres.nostenyek}</td>
                <td>{keres.fajta}</td>
                <td>{keres.szuldat}</td>
                <td>{keres.nev}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default KeresekComponent;
