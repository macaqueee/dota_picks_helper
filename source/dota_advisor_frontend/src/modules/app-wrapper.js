import React, {Component} from "react";
import {withRouter} from "react-router"
import SelectSection from "./components/select-section"
import HeroSection from "./components/hero-section"

class AppWrapper extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                {/*<SelectSection/>*/}
                <HeroSection/>
            </div>
        )
    }
}

export default withRouter(AppWrapper);