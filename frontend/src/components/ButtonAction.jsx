import PropTypes from "prop-types";

const ButtonAction = ({label, action}) => {
    return (
        <button className="btn btn-primary" onClick={action}>{label}</button>
    );
};

ButtonAction.propTypes = {
    label: PropTypes.string.isRequired,
    action: PropTypes.string.isRequired,
};

export default ButtonAction