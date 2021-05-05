import axios from "axios";

const hirdetesek = "http://localhost:8090/api/hirdetesek";

class HirdetesService {
  getHirdetesek() {
    return axios.get(hirdetesek + "/get");
  }
  addHirdetes(hirdetes) {
    return axios.post(hirdetesek + "/save", hirdetes);
  }
  getHirdetesekById(hirdetesId) {
    return axios.get(hirdetesek + "/" + hirdetesId);
  }
  deleteHirdetes(hirdetesId) {
    return axios.delete(hirdetesek + "/" + hirdetesId);
  }
}
export default new HirdetesService();
