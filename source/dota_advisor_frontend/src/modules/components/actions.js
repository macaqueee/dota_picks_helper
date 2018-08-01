import * as ActionTypes from "./action-types";

export const getHeroInfoStarted = (payload) => ({
    type: ActionTypes.GET_HEROES_STARTED,
    payload
});
export const getHeroInfoCompleted = (payload) => ({
    type: ActionTypes.GET_HEROES_COMPLETED,
    payload
});
export const getHeroInfoRejected = (payload) => ({
    type: ActionTypes.GET_HEROES_REJECTED,
    payload
});

export const enemyHeroesSelected = (payload) => ({
    type: ActionTypes.ENEMY_HEROES_SELECTED,
    payload
});


