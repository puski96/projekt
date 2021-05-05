import axios from "axios";

const fajtak = "http://localhost:8090/api/fajta";
const egyesulet = "http://localhost:8090/api/fajta";
const tulaj = "http://localhost:8090/api/tulaj";
const kiallitas = "http://localhost:8090/api/fajta";
const resztvesz = "http://localhost:8090/api/fajta";
const kisallat = "http://localhost:8090/api/fajta";

class AdminPanelService {
  getFajtak() {
    return axios.get(fajtak);
  }
  getEgyesuletek() {
    return axios.get(egyesulet);
  }
  getEmployees() {
    return axios.get(egyesulet);
  }

  createEmployee(employee) {
    return axios.post(egyesulet, employee);
  }

  getTulajById(tulajId) {
    return axios.get(tulaj + "/" + tulajId);
  }

  updateEmployee(employee, employeeId) {
    return axios.put(egyesulet + "/" + employeeId, employee);
  }

  deleteEmployee(employeeId) {
    return axios.delete(egyesulet + "/" + employeeId);
  }
}
export default new AdminPanelService();
