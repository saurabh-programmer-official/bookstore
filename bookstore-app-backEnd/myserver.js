const express = require("express");
const dotenv = require("dotenv");

const bodyParser = require("body-parser");
const mongoose = require("mongoose");
const path = require("path");
const cors = require("cors");
const nodemailer = require('nodemailer');

const transporter = nodemailer.createTransport({
  service: 'gmail',
  auth: {
    user: 'saurabh.bhandari0110@gmail.com',
    pass: 'saurabh0110'
  }
});

var mailOptions = {
  from: 'saurabh.bhandari0110@gmail.com',
  to: 'saurbah.bhandari.it@gmail.com',
  subject: 'Sending Email using Node.js',
  text: 'That was easy!'
};

transporter.sendMail(mailOptions, function(error, info){
  if (error) {
    console.log(error);
  } else {
    console.log('Email sent: ' + info.response);
  }
});

//import bookcontroller
const BookController = require("./src/mycontrollers/BookController")

dotenv.config({ path: ".env.jlc" });

const app = express();
const PORT = process.env.PORT || 5500;

/*
 Conect to MongoDB
 */
mongoose.connect((process.env.MONGODB_URI), {
    useUnifiedTopology: true,
    //useFindAndModify: false,
    useNewUrlParser: true
}).then(() => {
    console.log("MongoDB connected Successfully");
}, error => {
    console.log(error);
    console.log("MongoDB connection Error");
    process.exit();
});
//Add Middleware
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended:false
}));
app.use(cors());
app.get("/hello", (req, res) => {
    console.log("Request for -/hello");
    return res.send("Hello Guys I am ready");
}
)
app.get('/myapi/mybooks', BookController.getAllBooks);
app.post('/myapi/mybooks', BookController.addBook);
app.get('/myapi/mybooks/maxId', BookController.findMaxBookId);
app.get('/myapi/mybooks/:bookId', BookController.getBookById);
app.delete('/myapi/mybooks/:bookId', BookController.deleteBook);
app.put('/myapi/mybooks', BookController.updateBook);
/*
 Start Express server on port 5500
 */
app.listen(PORT, () => {
    console.log("Express server is running at http://localhost:%d", PORT);
    console.log("Press CTR-C to Stop \n");
})
