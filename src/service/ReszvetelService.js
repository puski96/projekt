import axios from "axios";

const reszvetel = "http://localhost:8090/api/kresztvesz";

class FajtaService {
  getResztvetelek() {
    return axios.get(reszvetel);
  }

  getResztvetelById(reszvetelId) {
    return axios.get(reszvetel + "/" + reszvetelId);
  }
  addResztvetel(resztvesz) {
    return axios.post(reszvetel + "/save", resztvesz);
  }
  updateResztvetel(resztvesz) {
    return axios.post(reszvetel + "/update", resztvesz);
  }
  deleteResztvetel(resztvesz) {
    return axios.delete(reszvetel + "/" + resztvesz);
  }
  getResztvetelByKisallatId(reszvetelId) {
    return axios.get(reszvetel + "/get/" + reszvetelId);
  }
}

export default new FajtaService();
