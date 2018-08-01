import {AxiosConfig} from 'app/config/axios-config'

const getAxiosConfig = (endpoint, method, params = {}, token = '') => {

    let axiosConfig;
    axiosConfig = Object.assign({}, AxiosConfig);

    axiosConfig.method = method;
    axiosConfig.url = endpoint.URL;

    if (method === 'post') {
        axiosConfig.data = JSON.stringify(params);
    } else {
        axiosConfig.params = (params);
        axiosConfig.data = (params);
    }

       if (token) {
        axiosConfig.headers = Object.assign({},axiosConfig.headers,{
            Authorization: token
        })
    }

    return axiosConfig;
}
export {getAxiosConfig}