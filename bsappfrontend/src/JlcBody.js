import { Component } from "react";
import { Route, Routes } from "react-router-dom";
import AddBook from "./AddBook";
import BookList from "./BookList";
import EditBook from "./EditBook";

class JlcBody extends Component {
    render() {
        return (
            <div>
                <Routes>
                    <Route path="/" element={<BookList />} exact />
                    <Route path="/addBook" element={<AddBook />} exact />
                    <Route path="/getAllBooks" element={<BookList />} exact />
                    <Route path="/edit-book/:mybookId" element={<EditBook />} exact />
                </Routes>
            </div>);
    }

}
export default JlcBody;