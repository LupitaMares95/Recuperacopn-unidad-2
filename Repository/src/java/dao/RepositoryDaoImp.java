/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;




import model.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Util;

/**
 *
 * @author user
 */
public class RepositoryDaoImp implements RepositoryDao {
    private Connection connection;
    
    public RepositoryDaoImp(){
        connection = Util.getConnection();
    
}

    @Override
    public void insertarRepository(Repository repository) {
try{
            String query = "INSERT INTO repositories (user_key,creation_date, name, description)"
                    +" VALUES(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,repository.getUserKey());
            ps.setString(2,repository.getCreationDate());
            ps.setString(3,repository.getName());
            ps.setString(4, repository.getDescription());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        } 
    }

    @Override
    public void eliminarRepository(int key) {
try{
            String query = "DELETE FROM repositories WHERE key=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, key);
            ps.executeUpdate();
            
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void modificarRepository(Repository repository) {
try{
            String query = "UPDATE repositories SET user_key =? "
                    + ", creation_date =?"
                    + ", name =?"
                    +", description =?"
                    +" WHERE   key=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,repository.getUserKey());
            ps.setString(2,repository.getCreationDate());
            ps.setString(3,repository.getName());
            ps.setString(4, repository.getDescription());
            ps.setInt(5, repository.getKey());
            
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Repository> desplegarRepositories() {
     List<Repository> repositorys = new ArrayList<Repository>();
        try{
        Statement statement = connection.createStatement();
         ResultSet rs= statement.executeQuery("SELECT * FROM repositories");
         while(rs.next()){
             Repository repository = new Repository(
                     rs.getInt("key"),
                     rs.getInt("user_key"),
                     rs.getString("creation_date"),
                     rs.getString("name"),
                     rs.getString("description"));
             
             repositorys.add(repository);
             
         
         }
         rs.close();
         statement.close();
    }catch(SQLException e){
        e.printStackTrace();
    }
return repositorys;
    }
    

    @Override
    public Repository elegirRepository(int key) {
   Repository repository = null;
        
        try{
            String query = "SELECT * FROM repositories WHERE key= ?";
            PreparedStatement statement =
                    connection.prepareStatement(query);
            statement.setInt(1, key);
             ResultSet rs= statement.executeQuery();
         if(rs.next()){
             
               repository = new Repository(
                rs.getInt("key"),
                        rs.getInt("user_key"),
                        rs.getString("creation_date"),
                        rs.getString("name"),
                        rs.getString("description"));
         }
         rs.close();
         statement.close();
    }catch(SQLException e){
        e.printStackTrace();
    }
return repository;
    }
    
    }
    
   
