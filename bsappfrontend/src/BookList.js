import { Component } from "react";
import axios from 'axios'
import { NavLink } from "react-router-dom";
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import Nav from 'react-bootstrap/Nav';

class BookList extends Component {
    state = {
        mybooks: [],
        showConfirm: false,
        myBookIdToDelete: "",
        myBookToEdit:""
    };

    componentDidMount() {
        this.getAllBooks();
    }
    getAllBooks = () => {
        const URL = "http://localhost:5500/myapi/mybooks";
        axios.get(URL).then(
            myresponse => {
                console.log("myresponse", myresponse.data);
                this.setState({ mybooks: myresponse.data })
            });

    }
    editBook = (bookId) => {
        const URL = `http://localhost:5500/myapi/mybooks/${this.state.myBookToEdit}`;
        axios.get(URL).then((myresponse) => {

        }
            
        )

    }
    showDeleteConfirm(bookId) {
        console.log("ShowDeleteConfirm bookId", bookId);
        let tempShowConfirm = this.state.showConfirm
        this.setState({
            showConfirm: !tempShowConfirm,
            myBookIdToDelete: bookId
        })
    }

    hidedelete=()=> {
        console.log("hideDelete")
   //     let tempShowConfirm = this.state.showConfirm
        this.setState({
            showConfirm: false
        })
            }
    handleDelete=()=> {

        axios.delete(`http://localhost:5500/myapi/mybooks/${this.state.myBookIdToDelete}`)
            .then((myresponse) => {
            console.log("handledelete ", myresponse.data);
            this.hidedelete();
            this.getAllBooks();
        }
        ).catch((myerror) => {
            console.log("myerror",myerror)
        })
  
    }
    render() {
        const mybooksList = this.state.mybooks.map(
            mybook => {
                return (
                    <tr key={mybook.bookId}>
                        <td>{mybook.bookId}</td>
                        <td>{mybook.bookName}</td>
                        <td>{mybook.author}</td>
                        <td>{mybook.website}</td>
                        <td>{mybook.category}</td>
                        <td>{mybook.publication}</td>
                        <td>{mybook.price}</td>
                        <td>{mybook.discount}</td>
                        <td>{mybook.offerPrice}</td>
                        <td>
                            <NavLink to={"/edit-book/" + mybook.bookId}
                                className="btn btn-primary mytext-large mymargin1"
                       //         onClick={this.editBook.bind(this, mybook.bookId}
                            >
                                Edit
                            </NavLink>
                            <Button
                                type="button"
                                className="btn btn-danger mytext-large"
                                onClick={this.showDeleteConfirm.bind(this, mybook.bookId)}
                            >
                                Delete
                            </Button>
                        </td>
                    </tr>
                    )
            }
                )
        return (
            <div className="container">
                <Nav type="Button" className="justify-content-end">
                    <NavLink to="/addBook" className="nav-link mywhite" exact> Add Book </NavLink>
                </Nav>
                <table className="table">
                    <thead>
                        <tr>
                            <th>Book Id</th>
                            <th>Book Name</th>
                            <th>Author</th>
                            <th>Website</th>
                            <th>Category</th>
                            <th>Publication</th>
                            <th>Price</th>
                            <th>Discount(%)</th>
                            <th>Offer Price</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {mybooksList}
                    </tbody>
                </table>
                <Modal show={this.state.showConfirm} onHide={this.hidedelete}>
                    <Modal.Header closeButton>
                        <Modal.Title>Delete command</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>Woohoo, you're reading this text in a modal!</Modal.Body>
                    <Modal.Footer>
                        <Button variant="secondary"
                            onClick={this.hidedelete}
                        >
                            Close
                        </Button>
                        <Button variant="danger"
                            onClick={this.handleDelete}
                        >
                            Delete
                        </Button>
                    </Modal.Footer>
                </Modal>
            </div>
            );
    }
}
export default BookList;