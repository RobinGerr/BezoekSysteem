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
    const {registratieNummer} = useParams();
    const navigate = useNavigate();
    const isBezoekerFormValid = voorNaam && achterNaam && geboorteDatum && woonPlaats;
    const isBezoekerCreated = datum && tijd && typeof bezoeker === 'object';


    useEffect(() => {
        const fetchGedetineerde = async () => {
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
        const bezoeker = {voorNaam, achterNaam, geboorteDatum, woonPlaats};
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

    const fetchBezoeker = async () => {
        const response = await fetch(`http://localhost:8080/bezoeker/last/${achterNaam}`);
        if (!response.ok) {
            throw new Error(`Error: ${response.status}`);
        }
        const data = await response.json();
        setBezoeker(data);
    };

    const handleNieuwBezoek = async (e) => {
        const bezoek = {datum, tijd};
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

            <div className="container mt-4">
                <div className="card p-4">
                    <div className="d-flex justify-content-between align-items-center mb-4">
                        <h1>Registreer bezoek voor: {gedetineerde.voorNaam} {gedetineerde.achterNaam}</h1>
                        <h3>Plan bezoek</h3>
                    </div>
    
                    <div className="card p-4 mb-4">
                        <h4>Registreer Bezoeker</h4>
                        <form>
                            <div className="row">
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="voorNaam" className="form-label">Voornaam</label>
                                    <input
                                        id="voorNaam"
                                        type="text"
                                        value={voorNaam}
                                        onChange={(e) => setVoorNaam(e.target.value)}
                                        className="form-control"
                                    />
                                </div>
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="achterNaam" className="form-label">Achternaam</label>
                                    <input
                                        id="achterNaam"
                                        type="text"
                                        value={achterNaam}
                                        onChange={(e) => setAchterNaam(e.target.value)}
                                        className="form-control"
                                    />
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="geboorteDatum" className="form-label">Geboortedatum</label>
                                    <input
                                        id="geboorteDatum"
                                        type="date"
                                        value={geboorteDatum}
                                        onChange={(e) => setGeboorteDatum(e.target.value)}
                                        className="form-control"
                                    />
                                </div>
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="woonPlaats" className="form-label">Woonplaats</label>
                                    <input
                                        id="woonPlaats"
                                        type="text"
                                        value={woonPlaats}
                                        onChange={(e) => setWoonPlaats(e.target.value)}
                                        className="form-control"
                                    />
                                </div>
                            </div>
                        </form>
                        <div className="d-flex justify-content-end mt-4">
                            <ButtonAction
                                label="Registreer bezoeker"
                                action={handleNieuweBezoeker}
                                disabled={!isBezoekerFormValid}
                            />
                        </div>
                    </div>
                    <form>
                        <div className="mb-3">
                            <label htmlFor="datum" className="form-label">Datum</label>
                            <input
                                id="datum"
                                type="date"
                                value={datum}
                                onChange={(e) => setDatum(e.target.value)}
                                className="form-control"
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="tijd" className="form-label">Tijd</label>
                            <input
                                id="tijd"
                                type="time"
                                value={tijd}
                                onChange={(e) => setTijd(e.target.value)}
                                className="form-control"
                            />
                        </div>
                    </form>

                    <div className="d-flex justify-content-end mt-4">
                        <ButtonAction label="Plan het bezoek" action={handleNieuwBezoek}
                                      disabled={!isBezoekerCreated}/>
                    </div>
                </div>
            </div>
        </>
    );
};

export default NieuweBezoeker;