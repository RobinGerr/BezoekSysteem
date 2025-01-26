import {useEffect, useState} from "react";
import BezoekRij from "../components/BezoekRij";
import { useNavigate } from 'react-router-dom';

const HomePage = () => {
    const [bezoeken, setBezoeken] = useState([]);
    const [filterdDatum, setFilterdDatum] = useState(new Date().toISOString().split('T'[0])[0]);
    const navigate = useNavigate();

    useEffect(() => {
        const fetchBezoeken = async() => {
            const response = await fetch(`http://localhost:8080/bezoek/filter/${filterdDatum}`);

            if (!response.ok) {
                throw new Error(`Error: ${response.status}`);
            }
            const data = await response.json();
            setBezoeken(data);
        };
        fetchBezoeken();
    }, [filterdDatum]);

    return (
        <>
            <div className="d-flex p-4 justify-content-between">
                <h1>Bezoeksysteem</h1>
                <button className="btn btn-primary" onClick={() => navigate("/planbezoek")}>Plan bezoek</button>
            </div>
            <div>
                <div className="d-flex p-4 justify-content-between">
                    <h2>Bezoekmoment van vandaag</h2>
                        {/* Button to trigger the modal */}
                        <button
                            type="button"
                            className="btn btn-outline-primary"
                            data-bs-toggle="modal"
                            data-bs-target="#exampleModal"
                        >
                            Filter
                        </button>

                        {/* Modal */}
                        <div
                            className="modal fade"
                            id="exampleModal"
                            tabIndex="-1"
                            aria-labelledby="exampleModalLabel"
                            aria-hidden="true"
                        >
                            <div className="modal-dialog">
                                <div className="modal-content">
                                    <div className="modal-header">
                                        <h1 className="modal-title fs-5" id="exampleModalLabel">
                                            Filter bezoeken
                                        </h1>
                                        <button
                                            type="button"
                                            className="btn-close"
                                            data-bs-dismiss="modal"
                                            aria-label="Close"
                                        ></button>
                                    </div>
                                    <div className="modal-body">
                                        <div className="mb-3">
                                            <label htmlFor="datum" className="form-label">Datum</label>
                                            <input
                                                id="datum"
                                                type="date"
                                                value={filterdDatum}
                                                onChange={(e) => setFilterdDatum(e.target.value)}
                                                className="form-control"
                                            />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                </div>
                <div>
                    <table className="table">
                        <thead>
                        <tr>
                            <th scope="col">Gedetineerde</th>
                            <th scope="col">Bezoeker</th>
                            <th scope="col">Datum</th>
                            <th scope="col">Tijd</th>
                            <th scope="col">Status</th>
                            <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        {bezoeken.map(bezoek => (
                            <BezoekRij bezoek={bezoek} key={bezoek.id}/>
                        ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </>
    );
};

export default HomePage