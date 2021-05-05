import React, { Component } from "react";
import Slider from "./Slider.js";
import FajtaComponent from "./FajtaComponent";
import { Carousel } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import img1 from "../img/isabel.jpg";
import img2 from "../img/hampshirek.png";
import FajtaService from "../service/FajtaService.js";
import { Link } from "react-router-dom";

class FajtaleirasokComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      fajtak: [],
    };
  }
  state = { osszes: false, tyukok: false, nyulak: false };
  osszes = () => {
    this.setState({
      osszes: !this.state.osszes,
      tyukok: this.setState.tyukok,
      nyulak: this.setState.nyulak,
    });
    FajtaService.getFajtak()
      .then((res) => {
        this.setState({ fajtak: res.data });
        console.log(this.state.data);
      })
      .catch(function (ex) {
        console.log("Response parsing failed. Error: ", ex);
      });
  };
  nyulak = () => {
    this.setState({
      nyulak: !this.state.nyulak,
      osszes: this.setState.osszes,
      tyukok: this.setState.tyukok,
    });
    FajtaService.getNyulak()
      .then((res) => {
        this.setState({ fajtak: res.data });
        console.log(this.state.data);
      })
      .catch(function (ex) {
        console.log("Response parsing failed. Error: ", ex);
      });
  };
  tyukok = () => {
    this.setState({
      tyukok: !this.setState.tyukok,
      nyulak: this.setState.nyulak,
      osszes: this.setState.osszes,
    });
    FajtaService.getTyukok()
      .then((res) => {
        this.setState({ fajtak: res.data });
        console.log(this.state.data);
      })
      .catch(function (ex) {
        console.log("Response parsing failed. Error: ", ex);
      });
  };
  componentDidMount() {
    this.osszes();
  }
  render() {
    const osszes = this.state.osszes ? "show" : "hide";
    const nyulak = this.state.nyulak ? "show" : "hide";
    const tyukok = this.state.tyukok ? "show" : "hide";
    function importAll(r) {
      return r.keys().map(r);
    }

    const images = importAll(require.context("./", false, /\.(png|jpeg|svg)$/));
    return (
      <div>
        <hr />
        <Carousel interval={2000}>
          <Carousel.Item>
            <img src={img1} height="600px" width="100%" alt="img1" />
            <div className="in-left">
              <h1>Udvozollek a fajtaleirasoknal</h1>
              <div>
                ide is fog jonni szoveg csak meg nem tudom hogy mit tegyek be,
                valamit ami fontos lehet
              </div>
            </div>
          </Carousel.Item>
          <Carousel.Item>
            <img src={img2} height="600px" width="100%" alt="img1" />
          </Carousel.Item>
        </Carousel>
        <div className="filter">
          <div className="filterBar">
            <div
              className="navbarFilter"
              style={{ justifyContent: "space-evenly" }}
            >
              <ul>
                <li className={`selected${osszes}`}>
                  <a onClick={this.osszes}>Toate</a>
                </li>
                <li className={`selected${nyulak}`}>
                  <a onClick={this.nyulak}>Iepuri</a>
                </li>
                <li className={`selected${tyukok}`}>
                  <a onClick={this.tyukok}>Găini</a>
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div className="fajtaContainer">
          {this.state.fajtak.map((fajta) => (
            <article className="initialBox" key={fajta.id}>
              <div>
                <img
                  className="fajtaImg"
                  src={"../img/fajtak/" + fajta.kep}
                  alt=""
                />
              </div>
              <div className="leiras">
                <div>
                  <h2>{fajta.fajta}</h2>
                  <div className="szoveg">{fajta.bemutatkozo}</div>
                </div>
                <button id={fajta.rovidites} className="button">
                  <Link to={`/fajtaleirasok/${fajta.rovidites}`}>
                    Citește mai mult
                  </Link>
                </button>
              </div>
            </article>
          ))}
        </div>
      </div>
    );
  }
}

export default FajtaleirasokComponent;
