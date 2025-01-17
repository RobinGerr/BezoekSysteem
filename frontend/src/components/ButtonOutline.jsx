import PropTypes from "prop-types";
import { useNavigate } from 'react-router-dom';

const ButtonOutline = ({label, link}) => {
    const navigate = useNavigate();
    return (
        <button className="btn btn-outline-primary" onClick={() => navigate(`${link}`)}>{label}</button>
    );
};

ButtonOutline.propTypes = {
    label: PropTypes.string.isRequired,
    link: PropTypes.string.isRequired,
};

export default ButtonOutline