import axios from 'axios';
import React from 'react';
import { useState, useEffect } from "react";
import { useParams } from 'react-router-dom';

const EditBook = (props) => {

    const [bookState, setBookState] = useState({
        bookId: 0,
        bookName: "",
        author: "",
        website:"",
        publication: "",
        category: "",
        price: 0,
        discount: 0,
        offerPrice:0
    })
    const { mybookId } = useParams();
    const bookid = mybookId;
    const getBooks = () => {
        axios.get(`http://localhost:5500/myapi/mybooks/${bookid}`).then(
            (myresponse) => {
                const response = myresponse.data
                setBookState(response);
            })
    }
    useEffect(() => {
        console.log("Use Effect")
        getBooks();

    },[]);

    const onChangeHandler = (event) => {
        //event.preventDefault();
        console.log("onChangeHandler");
        setBookState((prevalue) => {
            return {
                ...prevalue,
                [event.target.name]: event.target.value
            }
        })

        


    }

    let onClickHandler = (event) => {
        event.preventDefault();
        console.log("OnClick Handler called")
        console.log("Price", bookState.price);
        let quotient = bookState.discount / 100;
        console.log("quotiesnt", quotient);
        let offerPrice = bookState.price * (1 - quotient);
        console.log("Offer price", offerPrice);
        bookState.offerPrice = offerPrice;

     /*   setBookState((prevalue) => {
            return {
                ...prevalue,
                [event.target.name]: event.target.value
            }
        })
       */
        console.log("setstate method called", bookState.bookId)
        const URL = "http://localhost:5500/myapi/mybooks";
        console.log("URL correct")
        axios.put(URL, bookState).then((myresponse) => {
            console.log("Book Updated Succesfully")

           window.location.replace("http://localhost:3000/getAllBooks");

        }).catch((error) => {
            console.log("Error", error)
        });
    }
        return (
            <div>

                <label>Book Id</label>
                <input
                    type="text"
                    name="bookId"
                    value={bookState.bookId}
                />
                <br/><br/>
                <label>Book Name</label>
                <input
                    id="bookName"
                    type="text"
                    name="bookName"
                    onChange={onChangeHandler}
                    value={bookState.bookName}
                />
                <br /><br />
                <label>Author</label>
                <input
                    id="author"
                    type="text"
                    name="author"
                    onChange={onChangeHandler}
                    value={bookState.author}
                    />
                <br /><br />
                <label>Website</label>
                <input
                    type="text"
                    name="website"
                    value={bookState.website}
                    onChange={onChangeHandler}
                />
                <br/><br/>
                <label>Price</label>
                <input
                    type="text"
                    name="price"
                    value={bookState.price}
                    onChange={onChangeHandler}
                />
                <br /><br />
                <label>Discount</label>
                <input
                    type="text"
                    name="discount"
                    value={bookState.discount}
                    onChange={onChangeHandler}
                />
                <input
                    type="button"
                    value="Submit"
                    onClick={onClickHandler}
                    />
                    <input
                    type="button"
                    value="cancel"

                    />


            </div>
            );
  
}
export default EditBook;