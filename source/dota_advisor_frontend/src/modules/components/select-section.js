import React, {Component} from "react";
import {Creatable} from 'react-select';
import * as Actions from './actions'
import 'react-select/dist/react-select.css';

class SelectSection extends Component {

    constructor(props) {
        super(props);
        this.onSelectItem = this.onSelectItem.bind(this);
        this.state = {
            heroNames: [],
            selectedHeroes: []
        }
    }

    componentWillReceiveProps(nextProps) {
        const {heroes,selectedEnemies} = nextProps;

        this.setState(Object.assign({}, this.state, {
            heroNames: heroes.map(hero => {
                    let heroName = hero.heroName;
                    return Object.assign({}, hero, {
                        value: heroName,
                        label: heroName,
                    })
                }
            ),
            selectedHeroes: selectedEnemies
        }));
        // this.setState(Object.assign({}, this.state, {
        //     heroNames: heroes.map(hero => {
        //             let heroName = hero.heroName;
        //             return {
        //                 value: heroName,
        //                 label: heroName,
        //             }
        //         }
        //     )
        // }));
    }

    onSelectItem(selectedHeroes) {
        this.setState(Object.assign({}, this.state, {
            selectedHeroes: selectedHeroes
        }));

        this.props.selectHero(selectedHeroes);
    }

    render() {
        return (
            <div>
                <Creatable ref="_selectEnemyHeroes"
                           style={{width: "100%"}}
                           multi={true}
                           options={this.state.heroNames}
                           autoFocus={true}
                           value={this.state.selectedHeroes}
                           onChange={this.onSelectItem}
                >
                </Creatable>
                {/*<Select ref="_selectEnemyHero"*/}
                {/*style={{width: "100%"}}*/}
                {/*multi={true}*/}
                {/*options={this.state.heroNames}*/}
                {/*autoFocus={true}*/}
                {/*value={this.state.selectedHeroes}*/}
                {/*onChange={this.onSelectItem}*/}
                {/*isSearchable={true}*/}
                {/*blurInputOnSelect={true}*/}
                {/*hideSelectedOptions={true}>*/}
                {/*</Select>*/}
            </div>
        )
    }

}

export default SelectSection;
