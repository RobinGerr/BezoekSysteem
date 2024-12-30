import {useEffect, useState} from "react";
import BezoekRij from "../components/BezoekRij";

const HomePage = () => {
    const [bezoeken, setBezoeken] = useState([]);
    const [filterdBezoeken, setFilterdBezoeken] = useState([]);
    const [filterdDatum, setFilterdDatum] = useState(new Date().toISOString().split('T'[0])[0]);

    useEffect(() => {
        const fetchBezoeken = async() => {
            const response = await fetch("http://localhost:8080/bezoek");

            if (!response.ok) {
                throw new Error(`Error: ${response.status}`);
            }
            const data = await response.json();
            setBezoeken(data);
        };
        fetchBezoeken();
    }, []);

    useEffect(() => {
        setFilterdBezoeken(bezoeken.filter(bezoek => bezoek.datum === filterdDatum))
    }, [bezoeken]);

    return (
      <>
        <div className="d-flex p-4 justify-content-between">
            <h1>Bezoeksysteem</h1>
            <button className="btn btn-primary">Plan bezoek</button>
        </div>
        <div>
            <div className="d-flex p-4 justify-content-between">
                <h2>Bezoekmoment van vandaag</h2>
                <button className="btn btn-secondary">filter</button>
            </div>
            <div>
                <table className="table">
                    <thead>
                        <tr>
                            <th scope="col">Gedetineerde</th>
                            <th scope="col">Bezoeker</th>
                            <th scope="col">Datum</th>
                            <th scope="col">Tijd</th>
                        </tr>
                    </thead>
                    <tbody>
                        {filterdBezoeken.map(bezoek => (
                            <BezoekRij bezoek={bezoek} key={bezoek.id} />
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
      </>
    );
};

export default HomePage