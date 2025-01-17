import PropTypes from "prop-types";
import React from "react";
import ButtonOutline from "./ButtonOutline";

const GedetineerdeRij = ({gedetineerde}) => {
    const achterNaam = gedetineerde.achterNaam;
    const voorNaam = gedetineerde.voorNaam;
    const celNummer = gedetineerde.celNummer;

    return (
        <tr key={gedetineerde.registratieNummer}>
            <td>{achterNaam}</td>
            <td>{voorNaam}</td>
            <td>{celNummer}</td>
            <td>
                <ButtonOutline label="Selecteer" link={`/planbezoek/nieuw/${gedetineerde.registratieNummer}`}/>
            </td>
        </tr>
    );
};

GedetineerdeRij.propTypes = {
    gedetineerde: PropTypes.object.isRequired,
};

export default GedetineerdeRij