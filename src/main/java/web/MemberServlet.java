package web;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MemberServlet", urlPatterns = { "/index" })
public class MemberServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MemberService memberService = new MemberService();
	BookService bookService = new BookService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("searchAction");
		if (action != null) {
			switch (action) {
			case "searchByID":
				searchMemberById(req, resp);
				break;
			}
		} else {
			forwardListMembers(req, resp);
		}
	}

	private void searchMemberById(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		long memberID = Integer.valueOf(req.getParameter("memberID"));
		
		List<Book> bookList = bookService.getBooksByMemberID(memberID);	
		List<Member> memberList = memberService.getAllMembers();
		
		String nextJSP = "/list-members.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		req.setAttribute("memberList", memberList);
		req.setAttribute("bookList", bookList);		
		dispatcher.forward(req, resp);
	}

	private void forwardListMembers(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Book> bookList = bookService.getAllBooks();
		List<Member> memberList = memberService.getAllMembers();
		
		String nextJSP = "/list-members.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		req.setAttribute("memberList", memberList);
		req.setAttribute("bookList", bookList);
		dispatcher.forward(req, resp);
	}
}
