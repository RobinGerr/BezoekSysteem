import PropTypes from "prop-types";

const BezoekRij = ({bezoek}) => {
    const gedetineerde = bezoek.gedetineerde;
    const bezoeker = bezoek.bezoeker;

    return (
        <tr>
            <th scope="row">{gedetineerde.voorNaam} {gedetineerde.achterNaam}</th>
            <td>{bezoeker.voorNaam} {bezoeker.achterNaam} </td>
            <td>{bezoek.datum}</td>
            <td>{bezoek.tijd}</td>
        </tr>
    );
};

BezoekRij.propTypes = {
    bezoek: PropTypes.object.isRequired,
};

export default BezoekRij