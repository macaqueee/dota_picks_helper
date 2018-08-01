import {applyMiddleware, createStore} from 'redux';
import thunk from 'redux-thunk';
import logger from 'redux-logger';
import reducer from './components/reducer'

const RootReducer = (state = {}, action) => {
    return {
        root: reducer(state['root'],action)
    }
}

// using logger if development
let middleware;
if (`${process.env.NODE_ENV}` !== 'production') {
    middleware = applyMiddleware(thunk, logger());
} else {
    middleware = applyMiddleware(thunk, logger());
}
const Store = createStore(RootReducer,middleware);

export default Store;