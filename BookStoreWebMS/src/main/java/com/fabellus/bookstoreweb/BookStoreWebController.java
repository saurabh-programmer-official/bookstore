package com.fabellus.bookstoreweb;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiModel;

//import io.swagger.annotations.ApiModel;
//import io.swagger.models.Model;

@CrossOrigin
@Controller
@ApiModel("BookPriceController")
public class BookStoreWebController {

	static Logger log = LoggerFactory.getLogger(BookStoreWebController.class);
	int serialNumber;
	
	@Autowired
	BookStoreWebService bookStoreWebService;
	
	private Map<Integer,Book> myCartMap=new LinkedHashMap<>();

	
	@GetMapping("/")
	public String showIndexPage(Model model, HttpSession session) {
	List<String> authorList = bookStoreWebService.getAuthorList();
	List<String> catList = bookStoreWebService.getCategoryList();
	session.setAttribute("MyAuthorList", authorList);
	session.setAttribute("MyCategoryList", catList);
	Collection<Book> blist=bookStoreWebService.getAllBooks();
	//.getMyBook(author, category);
	session.setAttribute("MyBooksList", blist); 
	return "showBooksList1";

//	return "redirect:/showAllBooks";
	}
	@GetMapping("/showAllBooks")
	public String showBooksList(HttpServletRequest request, HttpSession session) {
	
		System.out.println("BookStoreController showBooksList");
		String author = request.getParameter("author");
		String category = request.getParameter("category");
		System.out.println("Author: "+author+" : "+ category);
		Collection<Book> blist=bookStoreWebService.getAllBooks();
				//.getMyBook(author, category); 
		session.setAttribute("MyBooksList", blist); 
		session.setAttribute("MyCartMap", myCartMap); 
		return "showBooksList1";
	}
	@GetMapping("/showSelectedBooks")
	public String showSelectedBooks(HttpServletRequest request, HttpSession session) {
		String author = request.getParameter("author");
		String category = request.getParameter("category");
		List<Book> booksList = bookStoreWebService.getMyBook(author, category);
		session.setAttribute("MyBooksList", booksList);
		return "showBooksList1";
	}
	@GetMapping("/showBookInfo")
	public String getBookInfo(@RequestParam("bookId")String bookId, HttpSession session, HttpServletRequest request) {
		System.out.println("Show Book Info");
		
		BookInfo bookInfo =bookStoreWebService.getBookInfoByBookId(Integer.parseInt(bookId));
		request.setAttribute("MyBookInfo",bookInfo);
		System.out.println("Show Book Info"+bookInfo);
		return "showBookInfo";
	}
	@GetMapping("/addToCart")
	public String addToCart(@RequestParam("bookId") String bookId, HttpSession session, HttpServletRequest request) {
		System.out.println("Add to Cart");
		Book book = bookStoreWebService.getBookByBookId(Integer.parseInt(bookId));
//        this.serialNumber=this.serialNumber+1;
//		myCartMap.put(serialNumber, book);
		myCartMap.put(new Integer(bookId), book);
		session.setAttribute("MyCartMap", myCartMap);
		return "redirect:/showSelectedBooks";
	}
	@GetMapping("/showMyCart")
	public String showMYCart(HttpSession session) {
		Object obj = session.getAttribute("MyCartMap");
		System.out.println("showmycart"+obj);
		Map<Integer,Book> myCartMap =(Map<Integer,Book>)obj;
		Collection<Book> cartBookList =(Collection<Book>)myCartMap.values();
		session.setAttribute("MyCartBooks", cartBookList);
		return "showCart";

	}
	@GetMapping("/continueShopping")
	public String continueShopping() {
		return "redirect:/showSelectedBooks";
	}
	
	@GetMapping("/showRatingsForm")
	public String showRatingForm(Model model) {
		UserRating userRating = new UserRating();
		userRating.setUserId("U-111");
		model.addAttribute("UserRating",userRating);
		return "addRating";
	}
	@PostMapping("/addMyRating")
	public String addMyRating(@ModelAttribute ("") UserRating userRating) {
		System.out.println("Controller Add My Rating");
		bookStoreWebService.addUserRating(userRating);
		return "showBooksList1";
	}
	@GetMapping("/placeOrder")
	public String placeOrder(HttpSession session) {
		System.out.println("bookstoreController placeorder");
		OrderInfo orderInfo= bookStoreWebService.placeOrder(myCartMap);
		session.setAttribute("Order", orderInfo.getOrder());
		session.setAttribute("OrderItemList", orderInfo.getItemList());
		myCartMap.clear();
		return "order";
	}
	@PostMapping("/remove")
	public String removeBook(@RequestParam String bookId, HttpSession session)
	//		@RequestParam("bookId") String bookId) 
	{
		myCartMap.remove(new Integer(bookId));
//		myCartMap.remove(Integer.parseInt(bookId));
//		session.setAttribute("myCartMap", myCartMap);
		session.setAttribute("MyCartMap", myCartMap);
		return "redirect:/showMyCart";
	}
}
