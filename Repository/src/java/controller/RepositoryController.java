/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RepositoryDao;
import dao.RepositoryDaoImp;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Repository;

/**
 *
 * @author user
 */
@WebServlet(name = "RepositoryController", urlPatterns = {"/RepositoryController"})
public class RepositoryController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private static final String LISTA_REPOSITORYS= 
            "/listarRepositories.jsp";
    private static final String AGREGAR_O_CAMBIAR = 
            "/repositories.jsp";
    private RepositoryDao dao;
    
    public RepositoryController(){
        dao = new RepositoryDaoImp();
    }
    


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("eliminar")){
            forward = LISTA_REPOSITORYS;
            int key = Integer.parseInt(
                    request.getParameter("key"));
            dao.eliminarRepository(key);
            request.setAttribute("repositories", dao.desplegarRepositories());
        }else if(action.equalsIgnoreCase("modificar")){
            forward= AGREGAR_O_CAMBIAR;
            int key = Integer.parseInt(
                    request.getParameter("key"));
            Repository repository=  dao.elegirRepository(key);
            request.setAttribute("repository", repository);
            
            
            
        }else if(action.equalsIgnoreCase("insertar")){
            forward= AGREGAR_O_CAMBIAR;
        }else{
            forward=LISTA_REPOSITORYS;
            request.setAttribute("repositories", dao.desplegarRepositories());
        }
        RequestDispatcher view =
                request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Repository repository = new Repository();
      String key = (request.getParameter("key").trim());
      String userKey = (request.getParameter("userKey").trim());
       repository.setUserKey(Integer.parseInt(userKey));
      repository.setCreationDate(request.getParameter("creationDate").trim());
      repository.setName(request.getParameter("name").trim());
      repository.setDescription(request.getParameter("description").trim());
      
      
      if(key==null || key.isEmpty()){
          dao.insertarRepository(repository);
          
      }else{
          repository.setKey(Integer.parseInt(key));
//          repository.setKey(Integer.parseInt(userKey));
          dao.modificarRepository(repository);
          
      }
      RequestDispatcher view = request.getRequestDispatcher(LISTA_REPOSITORYS);
      request.setAttribute("repositories", dao.desplegarRepositories());
      view.forward(request, response);
    }


   
    }

