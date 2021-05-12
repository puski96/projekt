import React, { Component } from "react";
import axios from "axios";

class AddImageComponent extends Component {
  constructor(props) {
    super(props);
    this.goBack = this.goBack.bind(this);
    this.state = {
      hirdetesId: this.props.match.params.id,
      uploadfile: null,
      kepek: null,
    };
  }
  goBack() {
    this.props.history.goBack();
  }

  onFileChangeHandler = (e) => {
    e.preventDefault();
    this.setState({
      uploadfile: e.target.files[0],
    });
  };
  saveImg = (e) => {
    e.preventDefault();
    const formData = new FormData();
    formData.append("uploadfile", this.state.uploadfile);
    axios.post(
      `http://localhost:8090/api/file/upload/${this.state.hirdetesId}`,
      formData
    );
    console.log(this.state);
    console.log(formData);
  };
  render() {
    return (
      <div className="uploadDiv">
        <div>
          <h2>Adaugă o poză</h2>
          <input
            type="file"
            className="form-control"
            name="file"
            onChange={this.onFileChangeHandler}
          />
          <label for="file">Choose a file</label>
        </div>
        <div>
          <button className="btnSalvare" onClick={this.saveImg}>
            Trimite
          </button>
        </div>
      </div>
    );
  }
}

export default AddImageComponent;
