import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import ButtonOutline from "../components/ButtonOutline";

const NieuweBezoeker = () => {
    const [voornaam, setVoornaam] = useState('');
    const [achternaam, setAchternaam] = useState('');
    const [geboortedatum, setGeboortedatum] = useState('');
    const [woonplaats, setWoonplaats] = useState('');
    const [gedetineerde, setGedetineerde] = useState([]);
    const { registratieNummer } = useParams();

    useEffect(() => {
        const fetchGedetineerde = async() => {
            const response = await fetch(`http://localhost:8080/gedetineerde/find/${registratieNummer}`);
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
            <h1>Registreer bezoeker voor: {gedetineerde.voorNaam} {gedetineerde.achterNaam}</h1>
            <h3>Plan bezoek</h3>
        </div>
            <form>
                <div>
                    <p className="form-label">Voornaam</p>
                    <input
                        type="text"
                        value={voornaam}
                        onChange={(e) => setVoornaam(e.target.value)}
                        className="form-control"/>
                </div>
                <div>
                    <p className="form-label">Achternaam</p>
                    <input
                        type="text"
                        value={achternaam}
                        onChange={(e) => setAchternaam(e.target.value)}
                        className="form-control"/>
                </div>
                <div>
                    <p className="form-label">Geboortedatum</p>
                    <input
                        type="text"
                        value={geboortedatum}
                        onChange={(e) => setGeboortedatum(e.target.value)}
                        className="form-control"/>
                </div>
                <div>
                    <p className="form-label">Woonplaats</p>
                    <input
                        type="text"
                        value={woonplaats}
                        onChange={(e) => setWoonplaats(e.target.value)}
                        className="form-control"/>
                </div>
            </form>
        <div>
            <ButtonOutline label="Bevestig" link="/"/>
        </div>
        </>
    );
};

export default NieuweBezoeker;