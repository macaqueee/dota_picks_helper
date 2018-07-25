import React from 'react'
import {render} from 'react-dom'
import {Provider} from 'react-redux'
import Store from './modules/app-store'
import Routes from './modules/routes'

render(
<Provider store={Store}>
    <Routes/>
    </Provider>,
document.getElementById('root')
)