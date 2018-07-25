import {applyMiddleware, createStore} from 'redux';
import thunk from 'redux-thunk';
import logger from 'redux-logger';


const RootReducer = (state = {}, action) => {
    return {}
}

// using logger if development
let middleware;
if (`${process.env.NODE_ENV}` !== 'production') {
    middleware = applyMiddleware(thunk, logger());
} else {
    middleware = applyMiddleware(thunk);
}
const Store = createStore(RootReducer,middleware);

export default Store;