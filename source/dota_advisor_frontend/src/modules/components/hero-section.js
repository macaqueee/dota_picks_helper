import React, {Component} from "react";
import axios from "axios";
import Gallery from "react-grid-gallery"

class HeroSection extends Component {

    constructor(props) {
        super(props);
        this.state = {
            images: []
        }
    }

    componentWillMount() {
        let heroes = [];
        axios.get('http://localhost:8080/heroes')
            .then((response) => {
                heroes = response.data.map(hero => {
                    let heroLink = 'http://localhost:8085/assets/images/' + hero.heroName + '.jpg';
                    return {
                        src: heroLink,
                        caption: hero.heroName,
                        thumbnail: heroLink,
                        thumbnailWidth: 128,
                        thumbnailHeight: 72,
                        isSelected: true
                    }
                });

                this.setState({
                    images: heroes
                })
            })
            .catch((response) => {
                console.log(error);
            });
    }

    // componentDidMount() {
    //     let heroes = [];
    //     axios.get('http://localhost:8080/heroes')
    //         .then(function (response) {
    //             console.log(response);
    //             heroes = response.data;
    //             this.setState({
    //                 images: heroes.map(heroName => {
    //                     let heroLink = '/assets/images/' + heroName + '.jpg';
    //                     return {
    //                         src: heroLink,
    //                         caption: heroName
    //                     }
    //                 })
    //             })
    //         })
    //         .catch(function (error) {
    //             console.log(error);
    //         });
    // }


    render() {
        let images = this.state.images;
        return (<div>
                <Gallery images={images}></Gallery>
            </div>
        )
    }
}

export default HeroSection;
