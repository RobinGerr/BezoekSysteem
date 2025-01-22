import PropTypes from "prop-types";
import React, { useState } from "react";

const ButtonAction = ({label, action, disabled}) => {
    return (
        <button className="btn btn-primary" onClick={action} disabled={disabled}>{label}</button>
    );
};

ButtonAction.propTypes = {
    label: PropTypes.string.isRequired,
    action: PropTypes.string.isRequired,
    disabled: PropTypes.bool,
};

export default ButtonAction