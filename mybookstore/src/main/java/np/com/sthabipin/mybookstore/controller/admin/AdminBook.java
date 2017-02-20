package np.com.sthabipin.mybookstore.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import np.com.sthabipin.mybookstore.Service.BookService;
import np.com.sthabipin.mybookstore.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
public class AdminBook {
	
	private Path path;
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/book/addBook")
	public String addBook(Model model) {
		
		Book book = new Book();
		book.setBookCategory("nepali");
		book.setBookCondition("new");
		
		model.addAttribute("book", book);
		
		return "addBook";
	}
	
	@PostMapping(value="/book/addBook")
	public String addBookPost(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "addBook";
		}
		
		bookService.addBook(book);
		
		MultipartFile bookImage = book.getBookImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path  = Paths.get(rootDirectory+ "\\WEB-INF\\resources\\images\\" +book.getBookId()+ ".png");
		
		if(bookImage != null && !bookImage.isEmpty()) {
			try {
				bookImage.transferTo(new File(path.toString()));
			} catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Book Image saving failed",e);
			}
		}
		
		return "redirect:/admin/bookInventory";
	}
	
	@RequestMapping("/book/editBook/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		
		Book book = bookService.getBookById(id);
		
		model.addAttribute("book", book);
		
		return "editBook";
	}
	
	@PostMapping(value="/book/editBook")
	public String editBookPost(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "editBook";
		}
					
		MultipartFile bookImage = book.getBookImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path  = Paths.get(rootDirectory+ "\\WEB-INF\\resources\\images\\" +book.getBookId()+ ".png");
		
		if(bookImage != null && !bookImage.isEmpty()) {
			try {
				bookImage.transferTo(new File(path.toString()));
			} catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Book Image saving failed",e);
			}
		}
		
		bookService.editBook(book);
		
		return "redirect:/admin/bookInventory";
	}
	
	@RequestMapping("/book/deleteBook/{id}")
	public String deleteBook(@PathVariable int id, Model model, HttpServletRequest request) {
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path  = Paths.get(rootDirectory+ "\\WEB-INF\\resources\\images\\" + id+ ".png");
		
		if(Files.exists(path)) {
			try {
				Files.delete(path);
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
		Book book = bookService.getBookById(id);
		bookService.deleteBook(book);
		
		return "redirect:/admin/bookInventory";
	}
}
















