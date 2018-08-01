import * as Actions from "./actions"
import axios from "axios";
import {getAxiosConfig} from "app/utils/http-request"
import {ENDPOINTS} from "app/config/axios-config";

const getHeroInfoThunk = (params) => {
    return function (dispatch) {
        dispatch(Actions.getHeroInfoStarted());
        const axiosConfig = getAxiosConfig(ENDPOINTS.GET_HERO_INFO,'get');
        return axios(axiosConfig)
            .then(reponse => dispatch(Actions.getHeroInfoCompleted(reponse)))
            .catch(response => dispatch(Actions.getHeroInfoRejected()))
    }
}

export default {getHeroInfoThunk}