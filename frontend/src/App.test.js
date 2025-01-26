import {fireEvent, render, screen, waitFor} from '@testing-library/react';
import {MemoryRouter, Route, Routes} from 'react-router-dom';
import HomePage from './pages/HomePage';
import AfdelingKeuze from "./pages/AfdelingKeuze";
import AfdelingsOverzicht from "./pages/AfdelingsOverzicht";
import NieuweBezoeker from "./pages/NieuweBezoeker";

test('renders visit list', () => {
    render(
        <MemoryRouter>
            <HomePage />
        </MemoryRouter>
    );
    expect(screen.getByText('Bezoekmoment van vandaag')).toBeInTheDocument();
});

test('navigates to the correct afdeling', () => {
    render(
        <MemoryRouter initialEntries={['/planbezoek']}>
            <Routes>
                <Route path="/planbezoek" element={<AfdelingKeuze />} />
                <Route path="/planbezoek/:afdeling" element={<AfdelingsOverzicht />} />
            </Routes>
        </MemoryRouter>
    );

    fireEvent.click(screen.getByText('Afdeling A'));
    expect(screen.getByText('Afdelingsoverzicht A')).toBeInTheDocument();
});


// test('navigates to the correct gedetineerde', () => {
//     render(
//         <MemoryRouter initialEntries={['/planbezoek/A']}>
//             <Routes>
//                 <Route path="/planbezoek/:afdeling" element={<AfdelingsOverzicht />} />
//                 <Route path="/planbezoek/nieuw/:registratieNummer" element={<NieuweBezoeker />} />
//             </Routes>
//         </MemoryRouter>
//     );
//
//     fireEvent.click(screen.getByText('Selecteer'));
//     expect(screen.getByText('Registreer')).toBeInTheDocument();
// });

