import React, { Component } from "react";
import axios from "axios";
import FajtaService from "../service/FajtaService.js";
import Chart from "react-apexcharts";

class StatisztikaComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      fajtak: [],
      countedI: [],
      countedG: [],
      eladva: [],
      loaded: false,
      optionsI: {
        chart: {
          id: "apexchart-example",
        },
        xaxis: {
          categories: [""],
        },
      },
      seriesI: [
        {
          name: "series-1",
          data: [3],
        },
      ],
      optionsG: {
        chart: {
          id: "apexchart-example",
        },
        xaxis: {
          categories: [""],
        },
      },
      seriesG: [
        {
          name: "series-1",
          data: [3],
        },
      ],
      options: {
        chart: {
          id: "apexchart-example",
        },
        xaxis: {
          categories: [""],
        },
      },
      series: [
        {
          name: "series-1",
          data: [3],
        },
      ],
    };
  }
  componentDidMount() {
    axios
      .get("http://localhost:8090/api/fajta/counterI")
      .then((response) => {
        this.setState({
          countedI: response.data,
        });
        let chartData = [];
        let chartCategories = [];
        let chartSeries = [];
        for (let i = 0; i < this.state.countedI.length; i++) {
          chartData.push(response.data[i].count);
          chartCategories.push(response.data[i].fajta);
          chartSeries.push({
            data: [response.data[i].count],
            name: response.data[i].fajta,
          });
        }
        this.setState({
          seriesI: chartSeries,
        });
      })
      .catch(function (error) {
        console.log(error);
      });
    axios
      .get("http://localhost:8090/api/fajta/counterG")
      .then((response) => {
        this.setState({
          countedG: response.data,
        });
        console.log(this.state);
        let chartData = [];
        let chartCategories = [];
        let chartSeries = [];
        for (let i = 0; i < this.state.countedG.length; i++) {
          chartData.push(response.data[i].count);
          chartCategories.push(response.data[i].fajta);
          chartSeries.push({
            data: [response.data[i].count],
            name: response.data[i].fajta,
          });
        }
        this.setState({
          seriesG: chartSeries,
        });
        console.log(this.state.seriesG);
      })
      .catch(function (error) {
        console.log(error);
      });
    axios
      .get("http://localhost:8090/api/hirdetesek/counter")
      .then((response) => {
        this.setState({
          eladva: response.data,
        });
        console.log(response);
        let chartData1 = [];
        let chartCategories1 = [];
        let chartSeries1 = [];
        for (let i = 0; i < this.state.eladva.length; i++) {
          chartData1.push(response.data[i][0]);
          chartCategories1.push(response.data[i][1]);
          chartSeries1.push({
            data: [response.data[i][0]],
            name:
              response.data[i][1] == 1
                ? "eladva"
                : response.data[i][1] == 2
                ? "torolve"
                : "aktiv",
          });
        }
        this.setState({
          series: chartSeries1,
        });
      })
      .catch(function (error) {
        console.log(error);
      });

    console.log(this.state.options);
  }

  render() {
    console.log(this.state.fajtak.length);
    console.log(this.state.countedI.length);

    if (this.state.countedI.length != undefined)
      return (
        <div>
          
          <div id="chart">
            <Chart
              options={this.state.optionsI}
              series={this.state.seriesI}
              type="bar"
              width={500}
              height={320}
            />
            <Chart
              options={this.state.optionsG}
              series={this.state.seriesG}
              type="bar"
              width={500}
              height={320}
            />
            <Chart
              options={this.state.options}
              series={this.state.series}
              type="bar"
              width={500}
              height={320}
            />
          </div>
        </div>
      );
    else return null;
  }
}

export default StatisztikaComponent;