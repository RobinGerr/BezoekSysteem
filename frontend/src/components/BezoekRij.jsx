import PropTypes from "prop-types";
import ButtonOutline from "./ButtonOutline";
import React from "react";

const BezoekRij = ({bezoek}) => {
    const gedetineerde = bezoek.gedetineerde;
    const bezoeker = bezoek.bezoeker;
    const check = bezoek.status === "Bezoek aanwezig";
    const block = bezoek.status === "Bezoeker geweigerd";

    const formatDate = (dateString) => {
        const options = { year: 'numeric', month: 'long', day: 'numeric' };
        const date = new Date(dateString);
        return date.toLocaleDateString('nl-NL', options);
    };

        return (
            <tr key={bezoek.id}>
                <th scope="row">{gedetineerde.voorNaam} {gedetineerde.achterNaam}</th>
                <td>{bezoeker.voorNaam} {bezoeker.achterNaam} </td>
                <td>{formatDate(bezoek.datum)}</td>
                <td>{bezoek.tijd}</td>
                <td>
                { check ? (
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             className="bi bi-check-circle" viewBox="0 0 16 16" style={{ color: "green" }}>
                            <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
                            <path
                                d="m10.97 4.97-.02.022-3.473 4.425-2.093-2.094a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05"/>
                        </svg>
                ) : block ? (
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             className="bi bi-x-circle" viewBox="0 0 16 16" style={{ color: "red" }}>
                            <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
                            <path
                                d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708"/>
                        </svg>
                ) : (
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             className="bi bi-circle" viewBox="0 0 16 16">
                            <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
                        </svg>
                )}
                </td>
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
