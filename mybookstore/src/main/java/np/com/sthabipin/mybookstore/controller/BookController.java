package np.com.sthabipin.mybookstore.controller;

import java.io.IOException;
import java.util.List;

import np.com.sthabipin.mybookstore.Service.BookService;
import np.com.sthabipin.mybookstore.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("/bookList")
	public String getBooks(Model model) {
		
		List<Book> books = bookService.getBookList();
		model.addAttribute("books", books);
		
		return "bookList";
	}
	
	@RequestMapping("/viewBook/{bookId}")
	public String viewBook(@PathVariable int bookId, Model model) throws IOException {
		
		Book book = bookService.getBookById(bookId);
		model.addAttribute("book", book);
		
		return "viewBook";
	}
}
