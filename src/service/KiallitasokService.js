import axios from "axios";

const kiallitasok = "http://localhost:8090/api/kiallitas";

class KiallitasokService {
  getKiallitasok() {
    return axios.get(kiallitasok);
  }

  getKiallitasById(kiallitasId) {
    return axios.get(kiallitasok + "/" + kiallitasId);
  }
  addKiallitas(kiallitas) {
    return axios.post(kiallitasok + "/save", kiallitas);
  }
  updateKiallitas(kiallitas) {
    return axios.post(kiallitasok + "/update", kiallitas);
  }
  deleteKiallitas(kiallitasId) {
    return axios.delete(kiallitasok + "/" + kiallitasId);
  }
}

export default new KiallitasokService();
