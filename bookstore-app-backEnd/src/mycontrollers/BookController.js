const { json } = require("body-parser");
let Book = require("../mymodels/Book");

//Get All Books
exports.getAllBooks = (req, res, next) => {
	console.log("/mybooks--get()");
	Book.find((error, data) => {
		if (error) {
			return next(error);
		}
		else {
			console.log("get All Books called data",data);
			 res.json(data);
		}
	}).sort({
		bookId:1
	})

}
//getMaxbookId
exports.getMaxBookId = (req, res, next) => {
	console.log("findmaxBookId");
	Book.find({}, (error, data) => {
		if (error)
			return next(error);
		else {
			json.res(data);

        }
	}).sort({
		bookId:-1
    }).limi(1)

}


exports.getBookById = (req, res, next) => {
	console.log("/mybooks/bookId --get()");
	Book.findOne({
		bookId: parseInt(req.params.bookId)
	},
		(error, data) => {
		if (error)
			return next(error);
		else {
			console.log("Book By Id", data)
			res.json(data);
		}
	})
}

exports.deleteBook = (req, res, next) => {
	console.log("/myapi/deleteBook --delete()");
	Book.findOneAndRemove({
		bookId: parseInt(req.params.bookId)
	}, (error, data) => {
		if (error) {
			return next(error);
		}
		else {
			res.json(data);
			console.log("Book Deleted Successfully")
		}
	}
		)
}

//get Book with maximum book Id
exports.findMaxBookId = (req, res, next) => {
	console.log("findMxBookId /myapi/maxid --get()");
	Book.find({}, (error, data) => {
		if (error) {
			return next(error);
		} else {
			res.json(data);
		}
	}).sort({
		bookId: -1
	}).limit(1);

}
//updte Book
exports.updateBook = (req, res, next) => {
	console.log("Book Updated in DB successfully");
	Book.findOneAndUpdate({
		bookId: req.body.bookId
	}, req.body, (error, data) => {
		if (error)
			return next(error);
		else {
			res.json(data);
			console.log("Book Updates Successfully");
		}
		})
}

//add Book
exports.addBook = (req, res, next) => {
	console.log("Book adding to DB");
	Book.create(req.body, (error, data) => {
		if (error) {
			return next(error);
		} else {
			console.log("Book added successfully in Database");
			res.json(data);
		}
	});
	
}