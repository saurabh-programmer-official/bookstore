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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiModel;

//import io.swagger.annotations.ApiModel;
//import io.swagger.models.Model;

@CrossOrigin
@Controller
@ApiModel("BookPriceController")
public class BookStoreWebController {

	static Logger log = LoggerFactory.getLogger(BookStoreWebController.class);

	@Autowired
	BookStoreWebService bookStoreWebService;
	private Map<Integer,BookInfo> myCartMap=new LinkedHashMap<>();
	
	private int serialNumber;

	@GetMapping("/")
	public String showIndexPage(Model model, HttpSession session) {
	List<String> authorList = bookStoreWebService.getAuthorList();
	List<String> catList = bookStoreWebService.getCategoryList();
	session.setAttribute("MyAuthorList", authorList);
	session.setAttribute("MyCategoryList", catList);
	return "redirect:/showAllBooks";
	}
	
	@GetMapping("/showAllBooks")
	public String showBooksList(HttpServletRequest request, HttpSession session) {
	
		System.out.println("BookStoreController showBooksList");
		String author = request.getParameter("author");
		String category = request.getParameter("category");
		System.out.println("Author: "+author+" : "+ category);
		Collection<Book> blist=bookStoreWebService.getMyBook(author, category);
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
		BookInfo bookInfo = bookStoreWebService.getBookByBookId(Integer.parseInt(bookId));
        this.serialNumber=this.serialNumber+1;
		myCartMap.put(serialNumber, bookInfo);
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
		return null;
	}
	
	@GetMapping("/placeOrder")
	public String placeOrder(HttpSession session) {
		bookStoreWebService.placeOrder(myCartMap);
		myCartMap.clear();

		return "redirect:/showSelectedBooks";
	}
}