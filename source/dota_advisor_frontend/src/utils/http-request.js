import {AxiosConfig} from '../config/axios-endpoints'
import {getCookie} from 'dashboard-app/utils/common-utils'
import {ENDPOINTS} from 'dashboard-app/config/axios-endpoints'

const getAxiosConfig = (endpoint, method, params = {}, token = '') => {

    let axiosConfig;

    if(!token) token = getCookie('token');
    axiosConfig = Object.assign({}, AxiosConfig);

    axiosConfig.method = method;
    axiosConfig.url = endpoint.URL;

    if (method === 'post') {
        axiosConfig.data = JSON.stringify(params);
    } else {
        axiosConfig.params = (params);
        axiosConfig.data = (params);
    }

    if(endpoint === ENDPOINTS.LOGIN) {
        axiosConfig.headers = {
            'Content-Type': 'text/plain'
        };

    } else {
        axiosConfig.headers = {
            'Content-Type': 'application/json'
        };
    }

    if (token) {
        axiosConfig.headers = Object.assign({},axiosConfig.headers,{
            Authorization: token
        })
    }

    return axiosConfig;
}
export {getAxiosConfig}