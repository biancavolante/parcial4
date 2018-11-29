package Controles;

import DAOs.DAOFuncionario;
import Entidade.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author a1712004
 */
@WebServlet(name = "CadastroFuncionarioServlet", urlPatterns = {"/CadastroFuncionario"})
public class CadastroFuncionarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String tabela = "";
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastroFuncionario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastroFuncionario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

            Integer rg = Integer.valueOf(request.getParameter("RGFuncionario"));
            String nome = request.getParameter("NomeFuncionario");
            String endereco = request.getParameter("Endereco");
            String email = request.getParameter("Email");
            String telefone = request.getParameter("Telefone");

            DAOFuncionario daoFuncionario = new DAOFuncionario();
            Funcionario produto = new Funcionario();

            produto.setId(rg);
            produto.setNomeFuncionario(nome);
            produto.setEndereco(endereco);
            produto.setEmail(email);
            produto.setTelefone(telefone);

            daoFuncionario.inserir(produto);
            
            List<Funcionario> lista = daoFuncionario.listInOrderRg();
            for (Funcionario p : lista) {
                tabela += "<tr class=\"gradeA\">"
                        + "<td>" + p.getId() + "</td>"
                        + "<td>" + p.getNomeFuncionario() + "</td>"
                        + "<td>" + p.getEndereco() + "</td>"
                        + "<td>" + p.getEmail() + "</td>"
                        + "<td>" + p.getTelefone() + "</td>"
                        + "</tr>";
            }
        request.getSession().setAttribute("resultado", tabela);
        response.sendRedirect(request.getContextPath() + "/paginas/funcionario.jsp");
        rg=null;
        nome="";
        endereco="";
        telefone="";
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
