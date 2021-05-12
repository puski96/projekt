import React, { Component } from "react";
import HirdetesComponent from "./HirdetesComponent";
import "bootstrap/dist/css/bootstrap.min.css";
import img1 from "../img/nature3.jpg";
import MapComponent from "./MapView";

class HirdetesekComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      helysegek: [],
    };
  }
  // componentDidMount() {
  //   axios
  //     .get(`http://localhost:8090/api/helysegek`)
  //     .then((res) => {
  //       this.setState({ helysegek: res.data });
  //     })
  //     .catch(function (ex) {
  //       console.log("Response parsing failed. Error: ", ex);
  //     });
  //   console.log(this.state.helysegek);
  // }
  render() {
    return (
      <div>
        <hr />

        <img src={img1} height="600px" width="100%" alt="img1" />
        <div className="in-left" id="in-leftPic">
          <h1>Udvozollek a hirdeteseknel</h1>
          <div>
            ide is fog jonni szoveg csak meg nem tudom hogy mit tegyek be,
            valamit ami fontos lehet
          </div>
        </div>

        <HirdetesComponent />
        <MapComponent />
      </div>
    );
  }
}

export default HirdetesekComponent;
