import axios from "axios";
//const token = localStorage.getItem("token");
const instance = axios.create({
  // baseURL: "/",
  // baseURL: "/api/v1",
  //baseURL: "http://localhost:8080",
  baseURL: "http://k5c101.p.ssafy.io/api",
  headers: {
    "Content-type": "application/json",
    Authorization: "Bearer " + localStorage.getItem("token"),
  },
});

export default instance;
