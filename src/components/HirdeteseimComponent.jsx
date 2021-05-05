import React, { Component } from "react";
import HirdetesService from "../service/HirdetesService";
import { Link } from "react-router-dom";

class HirdeteseimComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      hirdetesek: [],
    };
  }

  componentDidMount() {
    HirdetesService.getHirdetesek()
      .then((res) => {
        this.setState({ hirdetesek: res.data });
        console.log(this.state);
      })
      .catch(function (ex) {
        console.log("Response parsing failed. Error: ", ex);
      });
  }

  render() {
    return (
      <div>
        <button className="infoBtnAdd">
          <Link to={`/hirdetesfeladas`}>Adaugă</Link>
        </button>
        <table className="tagokTable">
          <thead>
            <tr>
              <th>Rasa</th>

              <th>Descriere</th>

              <th>Preț</th>

              <th>Bucăți</th>
              <th>Controls</th>
            </tr>
          </thead>
          <tbody>
            {this.state.hirdetesek.map((hirdetes) => (
              <tr key={hirdetes.id}>
                <td>{hirdetes.nev}</td>
                <td>{hirdetes.leiras}</td>
                <td>{hirdetes.ar}</td>
                <td>{hirdetes.db}</td>
                <td>
                  {hirdetes.kep == null ? (
                    <button className="infoBtn" id={hirdetes.id}>
                      <Link to={`/add-image/${hirdetes.id}`}>Images</Link>
                    </button>
                  ) : null}

                  <button
                    className="infoBtn"
                    onClick={() => this.deletehirdetes(hirdetes.id)}
                    id={hirdetes.id}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default HirdeteseimComponent;
