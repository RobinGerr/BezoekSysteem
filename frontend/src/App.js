import './App.css';
import { Routes, Route } from 'react-router-dom';
import HomePage from "./pages/HomePage";
import AfdelingKeuze from "./pages/AfdelingKeuze";
import AfdelingsOverzicht from "./pages/AfdelingsOverzicht";
import NieuweBezoeker from "./pages/NieuweBezoeker";
import AanmeldenBezoek from "./pages/AanmeldenBezoek";



function App() {
  return (
    <Routes>
      <Route path="/" element={<HomePage />} />
      <Route path="/planbezoek" element={<AfdelingKeuze />} />
      <Route path="/planbezoek/:afdeling" element={<AfdelingsOverzicht />} />
      <Route path="/planbezoek/nieuw/:registratieNummer" element={<NieuweBezoeker />} />
      <Route path="/aanmeldenBezoek/:bezoekId" element={<AanmeldenBezoek />} />
    </Routes>
  );
}

export default App;
