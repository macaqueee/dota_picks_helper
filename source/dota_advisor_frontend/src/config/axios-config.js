//const API_URL = "http://localhost:3000/"
const ENDPOINTS = {
    GET_HERO_INFO: {
        URL: "/heroes",
        HEADERS: {}
    }
};

const API_URL = process.env.API_URL;
const HTTP_IP_ADDRESS = API_URL.substr(0, API_URL.lastIndexOf(":"));
const ASSETS_PORT = 8085;
const FRONT_RESOURCES_URL = HTTP_IP_ADDRESS + ':' + ASSETS_PORT;

const AxiosConfig = {
    url: '',
    method: 'get',
    baseURL: API_URL ? API_URL : "http://localhost:8080",
    withCredentials: true,
    front_url : FRONT_RESOURCES_URL
};


export {ENDPOINTS, AxiosConfig}