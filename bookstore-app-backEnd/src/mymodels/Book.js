const mongoose = require("mongoose");
const Schema = mongoose.Schema;

let BookSchema = new Schema(
    {
        bookId: { type: Number },
        bookName: { type: String },
        author: { type: String },
	website:{type:String},	
        category: { type: String },
        publication: { type: String },
        price: { type: Number },
		discount:{type:Number},
		offerPrice:{type:Number}
    },
    {
        timestamps: true,
        collection: "mybooks"
    }
);
const Book = mongoose.model("Book", BookSchema);
module.exports = Book;