import { Component } from "react";
import MyTextInput from "./MyTextInput";
import axios from 'axios';
//import { Redirect } from 'react-router-dom';
import { Navigate } from 'react-router-dom';
// import { useNavigate } from 'react-router-dom';
import BookList from "./BookList";

class AddBook extends Component {
    state = {
            bookId: 0,
            bookName: "",
            author: "",
            website:"",
            publication: "",
            category: "",
        price: 0,
        discount: 0,
            offerPrice:0
        }
    //    this.onChangeHandler = this.onChangeHandler.bind(this);
      //  this.onSubmitHadler = this.onSubmitHadler.bind(this);
    

    

    onChangeHandler = (event) => {
    //    event.preventDefault();

        console.log("onchangehandler");
        this.setState({
            [event.target.name]: event.target.value
        })

    }
    onSubmitHandler = (event) => {
        event.preventDefault();
        let offerPrice = this.state.price * this.state.discount / 100;
        this.setState({
            [event.target.name]: event.target.value,
 
        })
        this.setState({
            offerPrice: offerPrice
        })
        const URL1 = "http://localhost:5500/myapi/mybooks/maxId"
        axios.get(URL1).then((myresponse) => {
            const book = myresponse.data[0];
            const bookId = book.bookId+1;
            this.setState({
                bookId: bookId
            })
            const URL = "http://localhost:5500/myapi/mybooks";
            axios.post(URL, this.state).then((myresponse) => {
                console.log(1, myresponse.data);
                this.setState({
                    bookId: 0,
                    bookName: "",
                    author: "",
                    website:"",
                    publication: "",
                    category: "",
                    price: 0,
                    discount: 0,
                    offerPrice:0

                });
                window.location.replace("http://localhost:3000/getAllBooks");
                // this.props.history.replace("http://localhost:3000/getAllBooks");
                //           this.props.history.push("/getAllBooks");
                /*
                <Redirect
                    to={{ pathname: "/" }}
                />;
                */
                // <Navigate to="/getAllBooks"/>
                //let navigate = useNavigate();
                // navigate("/getAllBooks");

            })


        }
            
        )
            //< Navigate replace to = "/getAllBooks" />;

    }
    render() {
        const { bookName, author, website,category, publication, price, discount } = this.state;
        return (
            <div className="card-body container col-md-6">
                <h2 className="text-center">Add Book</h2>
                <form onSubmit={this.onSubmitHandler}>
  
                      

                    <MyTextInput
                        myType="text"
                        myName="bookName"
                        myLabel="BookName"
                        myValue={bookName}
                        myOnChange={this.onChangeHandler}
                    />
                    <MyTextInput
                        myType="text"
                        myName="author"
                        myLabel="Author"
                        myValue={author}
                        myOnChange={this.onChangeHandler}
                    />
                    <MyTextInput
                        myType="text"
                        myName="website"
                        myLabel="Website"
                        myValue={website}
                        myOnChange={this.onChangeHandler}
                    />

                    <MyTextInput
                        myType="text"
                        myName="category"
                        myLabel="Category"
                        myValue={category}
                        myOnChange={this.onChangeHandler}
                    />
                    <MyTextInput
                        myType="text"
                        myName="publication"
                        myLabel="Publication"
                        myValue={publication}
                        myOnChange={this.onChangeHandler}
                    />
                    <MyTextInput
                        myType="text"
                        myName="price"
                        myLabel="Price"
                        myValue={price}
                        myOnChange={this.onChangeHandler}
                    />
                    <MyTextInput
                        myType="text"
                        myName="discount"
                        myLabel="Discount"
                        myValue={discount}
                        myOnChange={this.onChangeHandler}
                        
                    />

                    <input
                        type="submit"
                        className="btn btn-success bt-primary btn-lg"
                        value="Add Book Now"
                    />


                </form>
            </div>
            );


    }
}
export default AddBook;