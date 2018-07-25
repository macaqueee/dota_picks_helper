//const API_URL = "http://localhost:3000/"
//const API_URL = this._http.get(process.env.API_URL);
const ENDPOINTS = {
    GET_HERO_INFO: {
        URL: "/heroes",
        HEADERS: {}
    }
};

const AxiosConfig = {
    url: '',
    method: 'get',
    baseURL: (`${process.env.API_URL}`) ? `${process.env.API_URL}` : "https://localhost:8080",
    withCredentials: true//, // default
    /*transformResponse: [function (data) {
        if (data == 'Unauthorized') {
            window.location.href = '/login';
        }
        else {
            return JSON.parse(data);
        }
    }],*/
};
export { ENDPOINTS, AxiosConfig}