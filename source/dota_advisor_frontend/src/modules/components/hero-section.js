import React, {Component} from "react";
import Gallery from "react-grid-gallery"
import {AxiosConfig} from "app/config/axios-config"

class HeroSection extends Component {

    constructor(props) {
        super(props);

        this.createHeroImageLinks = this.createHeroImageLinks.bind(this);
    }

    createHeroImageLinks(heroes) {
        return heroes.map(heroName => {
            let heroLink = AxiosConfig.front_url + '/assets/images/' + heroName + '.jpg';
            return {
                src: heroLink,
                caption: heroName,
                thumbnail: heroLink,
                thumbnailWidth: 128,
                thumbnailHeight: 72,
                isSelected: false
            }
        })
    }

    prepareHeroSection(heroEnemies) {

    }
    render() {
        return (
            <Gallery images={this.createHeroImageLinks(this.props.heroEnemyNames)}
                     rowHeight={50}
                     enableImageSelection={false}
                     enableLightbox={false}
                     showCloseButton={false}
                     margin={3}>
            </Gallery>
        )
    }
}

export default HeroSection;
