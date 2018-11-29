/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Jaque
 */
@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/Funcionario"})
public class FuncionarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    DAOFuncionario daoFuncionario = new DAOFuncionario();
    Funcionario funcionario = new Funcionario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.print("aui");
            int rg = 0;
            String telefone = "";
            String nomeFuncionario = "";
            DAOFuncionario daoFuncionario = new DAOFuncionario();

            out.print("aqui");
            rg = Integer.valueOf(request.getParameter("RgFuncionario"));
            nomeFuncionario = request.getParameter("NomeFuncionario");
            String endereco = request.getParameter("Endereco");
            String email = request.getParameter("Email");
            telefone = request.getParameter("Telefone");
            out.print("aqui");

            Funcionario funcionario = new Funcionario();
            funcionario.setId(rg);
            funcionario.setNomeFuncionario(nomeFuncionario);
            funcionario.setEndereco(endereco);
            funcionario.setEmail(email);
            funcionario.setTelefone(telefone);

            daoFuncionario.inserir(funcionario);
           // DAOFuncionario tipo = new DAOFuncionario();
            String tabela = "";
            List<Funcionario> lista = daoFuncionario.listInOrderRg();
            for (Funcionario l : lista) {
                tabela += "<tr>"
                        + "<td>" + l.getId()+ "</td>"
                        + "<td>" + l.getNomeFuncionario() + "</td>"
                        + "<td>" + l.getEndereco() + "</td>"
                        + "<td>" + l.getEmail() + "</td>"
                        + "<td>" + l.getTelefone() + "</td>"
                        + "</tr>";
            }
            request.getSession().setAttribute("resultado", tabela);
            response.sendRedirect(request.getContextPath() + "/paginas/funcionario.jsp");
        }
    }

    private String listaFuncionarioId() {
        DAOFuncionario tipo = new DAOFuncionario();
        String tabela = "";
        List<Funcionario> lista = tipo.listInOrderRg();
        for (Funcionario l : lista) {
            tabela += "<tr>"
                    + "<td>" + l.getId()+ "</td>"
                    + "<td>" + l.getNomeFuncionario() + "</td>"
                    + "<td>" + l.getEndereco() + "</td>"
                    + "<td>" + l.getEmail() + "</td>"
                    + "<td>" + l.getTelefone() + "</td>"
                    + "</tr>";
        }

        return tabela;
    }

    protected String listaFuncionariosCadastrados() {
        DAOFuncionario tipo = new DAOFuncionario();
        String tabela = "";
        List<Funcionario> lista = tipo.listByNomeFuncionario(tabela);
        for (Funcionario l : lista) {
            tabela += "<tr>"
                    + "<td>" + l.getId()+ "</td>"
                    + "<td>" + l.getNomeFuncionario() + "</td>"
                    + "<td>" + l.getEndereco() + "</td>"
                    + "<td>" + l.getEmail() + "</td>"
                    + "<td>" + l.getTelefone() + "</td>"
                    + "</tr>";
        }

        return tabela;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        System.out.println("teste doget");
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
        System.out.println("teste dopost");
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
