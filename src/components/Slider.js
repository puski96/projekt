import React from "react";
import { Carousel } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import img1 from "../img/isabel.jpg";
import img2 from "../img/eggs10_chicken.jpg";

function imageSlider() {
  return (
    <div>
      <hr />
      <Carousel interval={2000}>
        <Carousel.Item>
          <img src={img1} height="600px" width="100%" alt="img1" />
          <div className="in-left">
            <h1>Udvozollek</h1>
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
    </div>
  );
}

export default imageSlider;
