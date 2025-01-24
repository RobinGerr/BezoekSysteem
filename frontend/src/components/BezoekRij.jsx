import PropTypes from "prop-types";
import ButtonOutline from "./ButtonOutline";
import React from "react";

const BezoekRij = ({bezoek}) => {
    const gedetineerde = bezoek.gedetineerde;
    const bezoeker = bezoek.bezoeker;

    return (
        <tr key={bezoek.id}>
            <th scope="row">{gedetineerde.voorNaam} {gedetineerde.achterNaam}</th>
            <td>{bezoeker.voorNaam} {bezoeker.achterNaam} </td>
            <td>{bezoek.datum}</td>
            <td>{bezoek.tijd}</td>
            <td>
                <ButtonOutline label="Selecteer" link={`/aanmeldenBezoek/${bezoek.id}`}/>
            </td>
        </tr>
    );
};

BezoekRij.propTypes = {
    bezoek: PropTypes.object.isRequired,
};

export default BezoekRij
