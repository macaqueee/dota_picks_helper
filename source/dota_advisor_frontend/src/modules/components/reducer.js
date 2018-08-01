import * as ActionTypes from "./action-types"

const initialState = {
    heroes: [],
    selectedEnemyHeroes: []
};

export default (state = initialState, action) => {
    switch (action.type) {
        case ActionTypes.GET_HEROES_STARTED: {
            return Object.assign({}, state)
        }

        case ActionTypes.GET_HEROES_COMPLETED: {
            return Object.assign({}, state, {
                heroes: action.payload.data
            })
        }
        case ActionTypes.GET_HEROES_REJECTED: {
            return Object.assign({}, state)
        }

        case ActionTypes.ENEMY_HEROES_SELECTED: {
            return Object.assign({}, state, {
                selectedEnemyHeroes: action.payload
            })
        }
        default:
            return state
    }

}