import React from "react";


import { NavLink } from "react-router-dom";
const JLCHeader = () => {
    return (
        <div>
            <header>
               
                <nav className="navbar navbar-expand-lg navbar-light bg-dark">
                    <h3 className="text-center mywhite">JLCBookStore</h3>
                    <button className="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                        aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    Java Learning Center 182 React – BookStore App
                    <div className="collapse navbar-collapse justify-content-end" id="navbarNav">
                        <ul className="nav justify-content-end">
                            <li className="nav-item active">
                                <h4>
                                    <NavLink to="/" className="nav-link mywhite" exact> Home </NavLink>
                                </h4>
                            </li>
                            <li className="nav-item active">
                                <h4>
                                    <NavLink to="/getAllBooks" className="nav-link mywhite" exact> Show Books </NavLink>
                                </h4>
                            </li>
                            <li className="nav-item active">
                                <h4>
                                    <NavLink to="/register" className="nav-link mywhite" exact> Register </NavLink>
                                </h4>
                            </li>
                        </ul>
                    </div>
                </nav>
            </header>
        </div>
    );
};
export default JLCHeader;