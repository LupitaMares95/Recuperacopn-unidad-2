/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */
public class Repository {
    private int key;
    private int userKey;
    private String  creationDate;
    private String name;
    private String description;
   


    public Repository(int key, int userKey, String creationDate, String name, String description ) {
        this.key= key;
        this.userKey = userKey;
        this.creationDate= creationDate;
        this.name= name;
        this.description=description;
   
       
    }
    
    public Repository(){
        this(0,0, "", "", "");
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getUserKey() {
        return userKey;
    }

    public void setUserKey(int userKey) {
        this.userKey = userKey;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Repository{" + "key=" + key + ", userKey=" + userKey + ", creationDate=" + creationDate + ", name=" + name + ", description=" + description + '}';
    }

    

    
}
