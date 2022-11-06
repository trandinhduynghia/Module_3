package controller;

import dao.UserDAO;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.validation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    private String errors = "";

    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "permision":
                    addUserPermision(request, response);
                    break;
                default:
                    //listUserPagging(request, response);
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) {
        User user = new User("quan", "quan.nguyen@codegym.vn", "vn");
        int[] permision = {1, 2, 4};
        userDAO.addUserTransaction(user, permision);
    }

    private void listUserPagging(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 3;
        String q = "";

        if (request.getParameter("q") != null) {
            q = request.getParameter("q");
        }

        if (request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));

        List<User> listUser = userDAO.selectUsersPagging((page - 1) * recordsPerPage, recordsPerPage, q);
        int noOfRecords = userDAO.getNoOfRecords();

        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

        request.setAttribute("listUser", listUser);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);

        request.setAttribute("q", q);

        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list_paging.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        //userDAO.deleteUser(id);
        userDAO.deleteUserStore(id);
        List<User> listUser = userDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDAO.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        //List<User> listUser = userDAO.selectAllUsers();
        List<User> listUser = userDAO.selectUserStore();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    //addUserTransaction(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(id, name, email, country);
        //userDAO.updateUser(newUser);
        userDAO.updateUserStore(newUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//        User newUser = new User(name, email, country);
//        userDAO.insertUser(newUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
//        dispatcher.forward(request, response);

        User user = new User();
        boolean flag = true;
        Map<String, String> hashMap = new HashMap<String, String>(); // luu lai danh sach cac truong loi
        System.out.println(this.getClass() + "insertUser with validate");
        try {
            user.setName(request.getParameter("name"));
            user.setEmail(request.getParameter("email"));
            user.setCountry(request.getParameter("country"));

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<User>> constraintValidators = validator.validate(user);

            if (!constraintValidators.isEmpty()) {
                //errors = "<ul>";
                for (ConstraintViolation<User> constraintViolation : constraintValidators) {
                    //            constraintViolation.getPropertyPath() +
                    //errors += "<li>" + constraintViolation.getMessage() + "</li>";
                    errors += "<p>"+ constraintViolation.getMessage() + "</p>";
                }
                    //errors += "</ul>";

                    request.setAttribute("user", user);
                    request.setAttribute("errors", errors);
                    request.getRequestDispatcher("user/create.jsp").forward(request, response);

            } else {
                userDAO.insertUser(user);
                RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception ex) {
        }
    }

    private void addUserTransaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(name, email, country);
        int[] permision = {};
        userDAO.addUserTransaction(newUser, permision);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }
}
