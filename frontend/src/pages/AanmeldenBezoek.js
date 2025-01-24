import { useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {useNavigate} from "react-router-dom";
import ButtonAction from "../components/ButtonAction";

const AanmeldenBezoek = () => {
    const [bezoek, setBezoek] = useState([])
    const [bezoeker, setBezoeker] = useState([]);
    const [gedetineerde, setGedetineerde] = useState([]);
    const [status, setStatus] = useState("");
    const [bsn, setBsn] = useState("");
    const {bezoekId} = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        const fetchBezoek = async () => {
            const response = await fetch(`http://localhost:8080/bezoek/${bezoekId}`);
            if (!response.ok) {
                throw new Error(`Error: ${response.status}`);
            }
            const data = await response.json();
            setBezoek(data);
        };
        fetchBezoek();
        }, []);

    useEffect(() => {
        const fetchGedetineerde = async () => {
            if (bezoek && bezoek.gedetineerde) {
                try {
                    const response = await fetch(`http://localhost:8080/gedetineerde/find/${bezoek.gedetineerde.registratieNummer}`);
                    if (!response.ok) {
                        throw new Error(`Error: ${response.status}`);
                    }
                    const data = await response.json();
                    setGedetineerde(data);
                } catch (error) {
                    console.error("Failed to fetch gedetineerde:", error);
                }
            }
        };
        fetchGedetineerde();
    }, [bezoek]);

    useEffect(() => {
        const fetchBezoeker = async () => {
            if (bezoek && bezoek.bezoeker) {
                try {
                    const response = await fetch(`http://localhost:8080/bezoeker/id/${bezoek.bezoeker.id}`);
                    if (!response.ok) {
                        throw new Error(`Error: ${response.status}`);
                    }
                    const data = await response.json();
                    setBezoeker(data);
                } catch (error) {
                    console.error("Failed to fetch bezoeker:", error);
                }
            }
        };
        fetchBezoeker();
    }, [bezoek]);


    return (
        <>
            <div className="container mt-4">
                <div className="card p-4">
                    <div className="d-flex justify-content-between align-items-center mb-4">
                        <h1>Bezoekmoment voor: {gedetineerde.voorNaam} {gedetineerde.achterNaam}</h1>
                        <h3>{bezoek.datum} {bezoek.tijd}</h3>
                    </div>

                    <div className="card p-4 mb-4">
                        <h4>Aanmelden Bezoeker</h4>
                        <form>
                            <div className="row">
                                <div className="col-md-6 mb-3">
                                    <p className="form-label">Voornaam</p>
                                    <p className="form-label">{bezoeker.voorNaam}</p>
                                </div>
                                <div className="col-md-6 mb-3">
                                    <p className="form-label">Achternaam</p>
                                    <p className="form-label">{bezoeker.achterNaam}</p>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-md-6 mb-3">
                                    <p className="form-label">Geboortedatum</p>
                                    <p className="form-label">{bezoeker.geboorteDatum}</p>
                                </div>
                                <div className="col-md-6 mb-3">
                                    <p className="form-label">Woonplaats</p>
                                    <p className="form-label">{bezoeker.woonPlaats}</p>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="voorNaam" className="form-label">BSN</label>
                                    <input
                                        id="bsn"
                                        type="text"
                                        value={bsn}
                                        onChange={(e) => setBsn(e.target.value)}
                                        className="form-control"
                                    />
                                </div>
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="voorNaam" className="form-label">Aanmelden bezoeker</label>
                                    <select
                                        value={status}
                                        onChange={(e) => setStatus(e.target.value)}
                                        className="form-select">
                                        <option value="">Selecteren</option>
                                        <option value="Bezoek aanwezig">Bezoek aanwezig</option>
                                        <option value="Bezoeker geweigerd">Bezoeker geweigerd</option>
                                    </select>
                                </div>
                            </div>
                        </form>

                        <div className="d-flex justify-content-end mt-4">
                        {/*<ButtonAction label="Plan het bezoek" action={handleNieuwBezoek}*/}
                        {/*              disabled={!isBezoekerCreated}/>*/}
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
};

export default AanmeldenBezoek;