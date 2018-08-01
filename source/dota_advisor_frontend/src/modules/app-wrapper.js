import React, {Component} from "react";
import {withRouter} from "react-router"
import {connect} from "react-redux"
import SelectSection from "./components/select-section"
import HeroSection from "./components/hero-section"
import Thunks from "./components/thunks"
import * as Actions from "./components/actions"

class AppWrapper extends Component {

    constructor(props) {
        super(props);
        this.selectHero = this.selectHero.bind(this);
        this.extractHeroesWeakEnemyNames = this.extractHeroesWeakEnemyNames.bind(this);
    }

    componentDidMount() {
        let heroes = [];
        this.props.dispatch(Thunks.getHeroInfoThunk())
    }

    selectHero(selectedHeroes) {
        this.props.dispatch(Actions.enemyHeroesSelected(selectedHeroes))
    }

    extractHeroesWeakEnemyNames(selectedEnemyHeroes) {
        if (selectedEnemyHeroes.length === 0) {
            return []
        }
        let map = selectedEnemyHeroes.map(hero => hero.heroWeakEnemyNames);
        let reduce = map.reduce((a, b) => a.concat(b));

        console.log('lol');
        return reduce;
    }

    render() {
        return (
            <div className={"center"}>
                <SelectSection heroes={this.props.heroes}
                               selectHero={this.selectHero}
                               selectedEnemies={this.props.heroesEnemies}/>
                <br/><br/>
                <HeroSection heroEnemyNames={this.extractHeroesWeakEnemyNames(this.props.heroesEnemies)}/>
            </div>
        )
    }
}

const mapStateToProps = (state) => {
    return {
        heroes: state.root.heroes,
        heroesEnemies: state.root.selectedEnemyHeroes
    }
}

export default withRouter(connect(mapStateToProps, null)(AppWrapper));