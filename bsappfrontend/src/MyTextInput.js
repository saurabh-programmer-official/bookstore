import React from 'react';
const MyTextInput = ({ myType, myName, myValue, myLabel, myOnChange }) => {
    return (
        <div>
            <label htmlFor={myName}>{myLabel}</label>
            <input
                type={myType}
                name={myName}
                value={myValue}
                label={myLabel}
                onChange={myOnChange}
            />
            <br/><br/>
        </div>
    );

}
export default MyTextInput