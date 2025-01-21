import { useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {useNavigate} from "react-router-dom";
import ButtonAction from "../components/ButtonAction";

const NieuweBezoeker = () => {
    const [bezoeker, setBezoeker] = useState([]);
    const [datum, setDatum] = useState('');
    const [tijd, setTijd] = useState('');
    const [voorNaam, setVoorNaam] = useState('');
    const [achterNaam, setAchterNaam] = useState('');
    const [geboorteDatum, setGeboorteDatum] = useState('');
    const [woonPlaats, setWoonPlaats] = useState('');
    const [gedetineerde, setGedetineerde] = useState([]);
    const { registratieNummer } = useParams();
    const navigate = useNavigate();

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

    const handleNieuweBezoeker = async (e) => {
        const bezoeker = { voorNaam, achterNaam, geboorteDatum, woonPlaats };
        const response = await fetch(`http://localhost:8080/bezoeker`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(bezoeker),
        });
        if (!response.ok) {
            throw new Error(`Error: ${response.status}`);
        }
        alert("Bezoeker succesvol toegevoegd!");
        fetchBezoeker();
    };

    const fetchBezoeker = async() => {
        const response = await fetch(`http://localhost:8080/bezoeker/last/${achterNaam}`);
        if (!response.ok) {
            throw new Error(`Error: ${response.status}`);
        }
        const data = await response.json();
        setBezoeker(data);
    };

    const handleNieuwBezoek = async (e) => {
        const bezoek = { datum, tijd };
        const response = await fetch(`http://localhost:8080/bezoek/${registratieNummer}/${bezoeker.id}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(bezoek),
        });
        if (!response.ok) {
            throw new Error(`Error: ${response.status}`);
        }
        navigate('/');
        alert("Bezoek succesvol geregistreerd")
    };

    return (
        <>
            <div className="d-flex p-4 justify-content-between">
                <h1>Registreer bezoek voor: {gedetineerde.voorNaam} {gedetineerde.achterNaam}</h1>
                <h3>Plan bezoek</h3>
            </div>
            <form>
                <div>
                    <p className="form-label">Datum</p>
                    <input
                        type="date"
                        value={datum}
                        onChange={(e) => setDatum(e.target.value)}
                        className="form-control"/>
                </div>
                <div>
                    <p className="form-label">Tijd</p>
                    <input
                        type="time"
                        value={tijd}
                        onChange={(e) => setTijd(e.target.value)}
                        className="form-control"/>
                </div>
            </form>
            <form>
                <div>
                    <p className="form-label">Voornaam</p>
                    <input
                        type="text"
                        value={voorNaam}
                        onChange={(e) => setVoorNaam(e.target.value)}
                        className="form-control"/>
                </div>
                <div>
                    <p className="form-label">AchterNaam</p>
                    <input
                        type="text"
                        value={achterNaam}
                        onChange={(e) => setAchterNaam(e.target.value)}
                        className="form-control"/>
                </div>
                <div>
                    <p className="form-label">GeboorteDatum</p>
                    <input
                        type="date"
                        value={geboorteDatum}
                        onChange={(e) => setGeboorteDatum(e.target.value)}
                        className="form-control"/>
                </div>
                <div>
                    <p className="form-label">Woonplaats</p>
                    <input
                        type="text"
                        value={woonPlaats}
                        onChange={(e) => setWoonPlaats(e.target.value)}
                        className="form-control"/>
                </div>
            </form>
            <div>
                <ButtonAction label='Bevestig' action={handleNieuweBezoeker}/>
            </div>
            <div>
                <ButtonAction label="Volgende" action={handleNieuwBezoek}/>
            </div>
        </>
    );
};

export default NieuweBezoeker;