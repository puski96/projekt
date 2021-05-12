import React, { Component } from "react";
import FajtaService from "../service/FajtaService.js";

class FajtaComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      fajtak: [],
    };
  }

  componentDidMount() {
    FajtaService.getFajtak()
      .then((res) => {
        this.setState({ fajtak: res.data });
        console.log(this.state.data);
      })
      .catch(function (ex) {
        console.log("Response parsing failed. Error: ", ex);
      });
  }

  render() {
    return <div></div>;
  }
}

export default FajtaComponent;
