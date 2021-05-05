import { Splide, SplideSlide } from "@splidejs/react-splide";
import React, { Component } from "react";
import kep1 from "../img/album/20200204_113822.jpg";
import kep2 from "../img/album/20200204_113950.jpg";
import kep3 from "../img/album/20200204_114059.jpg";

class SplideComponent extends Component {
  constructor(props) {
    super(props);
    this.primaryRef = React.createRef();
    this.secondaryRef = React.createRef();
  }

  render() {
    return (
      <div>
        <div id="image-slider" className="splide">
          <div className="splide__track">
            <ul className="splide__list">
              <li className="splide__slide">
                <img src={kep1} />
              </li>
              <li className="splide__slide">
                <img src={kep2} />
              </li>
              <li className="splide__slide">
                <img src={kep3} />
              </li>
            </ul>
          </div>
        </div>

        <div id="secondary-slider" className="splide">
          <div className="splide__track">
            <ul className="splide__list">
              <li className="splide__slide">
                <img src={kep1} />
              </li>
              <li className="splide__slide">
                <img src={kep2} />
              </li>
              <li className="splide__slide">
                <img src={kep3} />
              </li>
            </ul>
          </div>
        </div>
      </div>
    );
  }
}

export default SplideComponent;
