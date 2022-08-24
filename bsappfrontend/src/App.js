import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as MyRouter } from 'react-router-dom';
import JLCHeader from './JlcHeader';
import JlcBody from './JlcBody';
import JlcFooter from './JlcFooter';
import { Component } from 'react';
class App extends Component {
    render() {

        return (
                <MyRouter>
                    <div className="card">
                    <JLCHeader />
                    <JlcBody />
                        <JlcFooter />
                    </div>
                </MyRouter>
        );
    }
}

export default App;
