import ButtonOutline from "../components/ButtonOutline";

const AfdelingKeuze = () => {

    return (
      <>
          <div className="d-flex p-4 justify-content-between">
              <h1>Afdeling</h1>
              <h3>Plan bezoek</h3>
          </div>
          <div>
              <ButtonOutline label="Afdeling A" link="/planbezoek/A" />
              <ButtonOutline label="Afdeling B" link="/planbezoek/B" />
              <ButtonOutline label="Afdeling C" link="/planbezoek/C" />
          </div>
      </>
  );
};

export default AfdelingKeuze;