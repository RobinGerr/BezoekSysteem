import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import GedetineerdeRij from "../components/GedetineerdeRij";

const AfdelingsOverzicht = () => {
    const [gedetineerde, setGedetineerde] = useState([]);
    const { afdeling } = useParams();

    useEffect(() => {
        const fetchGedetineerde = async() => {
            const response = await fetch(`http://localhost:8080/gedetineerde/${afdeling}`);

            if (!response.ok) {
                throw new Error(`Error: ${response.status}`);
            }
            const data = await response.json();
            setGedetineerde(data);
        };
        fetchGedetineerde();
    }, []);


    return (
        <>
            <div className="d-flex p-4 justify-content-between">
                <h1>Afdelingsoverzicht {afdeling}</h1>
                <h3>Plan bezoek</h3>
            </div>
            <div>
                <table className="table">
                    <thead>
                    <tr>
                        <th scope="col">Gedetineerde</th>
                    </tr>
                    </thead>
                    <tbody>
                    {gedetineerde.length === 0 ? (
                        <tr>
                            <td colSpan="2">Geen gegevens beschikbaar</td>
                        </tr>
                    ) : (
                        gedetineerde.map((gedetineerde) => (
                            <GedetineerdeRij gedetineerde={gedetineerde}/>
                        ))
                    )}
                    </tbody>
                </table>
            </div>
        </>
    );
};

export default AfdelingsOverzicht;
