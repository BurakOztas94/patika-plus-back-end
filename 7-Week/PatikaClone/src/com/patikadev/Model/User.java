package com.patikadev.Model;

import com.patikadev.Helper.DBConnector;
import com.patikadev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String uname;
    private String pass;
    private String type;

    public User ()
        {

        }

    public User (int id , String name , String uname , String pass , String type)
        {
            this.id = id;
            this.name = name;
            this.uname = uname;
            this.pass = pass;
            this.type = type;
        }


    public int getId ()
        {
            return id;
        }

    public void setId (int id)
        {
            this.id = id;
        }

    public String getName ()
        {
            return name;
        }

    public void setName (String name)
        {
            this.name = name;
        }

    public String getUname ()
        {
            return uname;
        }

    public void setUname (String uname)
        {
            this.uname = uname;
        }

    public String getPass ()
        {
            return pass;
        }

    public void setPass (String pass)
        {
            this.pass = pass;
        }

    public String getType ()
        {
            return type;
        }

    public void setType (String type)
        {
            this.type = type;
        }

    public static ArrayList<User> getList ()
        {
            ArrayList<User> userList = new ArrayList<> ();
            String query = "SELECT * FROM user";
            try
                {
                    Statement statement = DBConnector.getInstance ().createStatement ();
                    ResultSet resultSet = statement.executeQuery (query);
                    User obj;
                    while (resultSet.next ())
                        {
                            obj = new User ();
                            obj.setId (resultSet.getInt ("id"));
                            obj.setName (resultSet.getString ("name"));
                            obj.setUname (resultSet.getString ("uname"));
                            obj.setPass (resultSet.getString ("pass"));
                            obj.setType (resultSet.getString ("type"));
                            userList.add (obj);
                        }
                    statement.close ();
                    resultSet.close ();
                } catch (SQLException e)
                {
                    System.out.println (e.getMessage ());
                }
            return userList;
        }

    public static boolean add (String name , String uname , String pass , String type)
        {
            String query = "INSERT INTO user(name,uname,pass,type) VALUES (?,?,?,?)";
            User findUser = User.getFetch (uname);
            if ( findUser != null )
                {
                    Helper.showMsg ("This user name has been added ! Please enter different user name ! ");
                    return false;
                }

            try
                {
                    PreparedStatement pr = DBConnector.getInstance ().prepareStatement (query);
                    pr.setString (1 , name);
                    pr.setString (2 , uname);
                    pr.setString (3 , pass);
                    pr.setString (4 , type);

                    int response = pr.executeUpdate ();
                    if ( response == -1 )
                        {
                            Helper.showMsg ("error");
                        }
                    return response != -1;

                } catch (SQLException e)
                {
                    System.out.println (e.getMessage ());
                }
            return true;
        }

    public static User getFetch (String uname)
        {

            User obj = null;
            String query = "SELECT * FROM user WHERE uname = ?";
            try
                {
                    PreparedStatement pr = DBConnector.getInstance ().prepareStatement (query);
                    pr.setString (1 , uname);
                    ResultSet resultSet = pr.executeQuery ();
                    if ( resultSet.next () )
                        {
                            obj = new User ();
                            obj.setId (resultSet.getInt ("id"));
                            obj.setName (resultSet.getString ("name"));
                            obj.setUname (resultSet.getString ("uname"));
                            obj.setPass (resultSet.getString ("pass"));
                            obj.setType (resultSet.getString ("type"));

                        }
                } catch (SQLException e)
                {
                    throw new RuntimeException (e);
                }

            return obj;
        }

    public static User getFetch (String uname,String pass)
        {

            User obj = null;
            String query = "SELECT * FROM user WHERE uname = ? AND pass = ?";
            try
                {
                    PreparedStatement pr = DBConnector.getInstance ().prepareStatement (query);
                    pr.setString (1 , uname);
                    pr.setString (2 , pass);
                    ResultSet resultSet = pr.executeQuery ();
                    if ( resultSet.next () )
                        {
                            switch (resultSet.getString ("type")){
                                case "operator":
                                    obj = new Operator ();
                                    break;
                                default:
                                    obj=new User ();
                                  break;
                            }

                            obj.setId (resultSet.getInt ("id"));
                            obj.setName (resultSet.getString ("name"));
                            obj.setUname (resultSet.getString ("uname"));
                            obj.setPass (resultSet.getString ("pass"));
                            obj.setType (resultSet.getString ("type"));

                        }
                } catch (SQLException e)
                {
                    throw new RuntimeException (e);
                }

            return obj;
        }
    public static User getFetch (int id)
        {

            User obj = null;
            String query = "SELECT * FROM user WHERE id = ?";
            try
                {
                    PreparedStatement pr = DBConnector.getInstance ().prepareStatement (query);
                    pr.setInt (1 , id);
                    ResultSet resultSet = pr.executeQuery ();
                    if ( resultSet.next () )
                        {
                            obj = new User ();
                            obj.setId (resultSet.getInt ("id"));
                            obj.setName (resultSet.getString ("name"));
                            obj.setUname (resultSet.getString ("uname"));
                            obj.setPass (resultSet.getString ("pass"));
                            obj.setType (resultSet.getString ("type"));

                        }
                } catch (SQLException e)
                {
                    throw new RuntimeException (e);
                }

            return obj;
        }


    public static boolean delete (int id)
        {
            String query = "DELETE FROM user WHERE id = ?";
            ArrayList<Course> courseList=Course.getListByUser (id);
            for ( Course c : courseList ){
                    Course.delete (c.getId ());
            }
            try
                {
                    PreparedStatement preparedStatement = DBConnector.getInstance ().prepareStatement (query);
                    preparedStatement.setInt (1 , id);


                    return preparedStatement.executeUpdate () != -1;
                } catch (SQLException e)
                {
                    System.out.println (e.getMessage ());
                }
            return true;

        }

    public static boolean update (int id , String name , String uname , String pass , String type)
        {                                                                                                                     // Liste oluşturulup type içinde var mı yok mu sorgusu yapılarak type kısmının değiştirilmemesini sağlamamız gerekiyor.
            String query = "UPDATE user SET name=?,uname=?,pass=?,type=? WHERE id = ?";                                         // karmaşık olamayn if else sorgusu ve type liste ilişkisi ile.
            User findUser = User.getFetch (uname);

            ArrayList<String> userTypes = new ArrayList<> () {
                {
                    add ("operator");
                    add ("student");
                    add ("educator");
                }
            };


            if ( findUser != null && findUser.getId () != id )
                {
                    Helper.showMsg ("This user name has been added ! Please enter different user name ! ");
                    return false;
                }
            else if ( !userTypes.contains (type) )
                {

                    Helper.showMsg ("Invalid user type !");
                    return false;
                }


            try
                {
                    PreparedStatement pr = DBConnector.getInstance ().prepareStatement (query);
                    pr.setString (1 , name);
                    pr.setString (2 , uname);
                    pr.setString (3 , pass);
                    pr.setString (4 , type);
                    pr.setInt (5 , id);
                    return pr.executeUpdate () != -1;
                } catch (SQLException e)
                {
                    System.out.println (e.getMessage ());
                }
            return true;

        }

    public static ArrayList<User> searchUserList (String query)
        {
            ArrayList<User> userList = new ArrayList<> ();
            User obj;
            try
                {
                    Statement statement = DBConnector.getInstance ().createStatement ();
                    ResultSet resultSet = statement.executeQuery (query);

                    while (resultSet.next ())
                        {
                            obj = new User ();
                            obj.setId (resultSet.getInt ("id"));
                            obj.setName (resultSet.getString ("name"));
                            obj.setUname (resultSet.getString ("uname"));
                            obj.setPass (resultSet.getString ("pass"));
                            obj.setType (resultSet.getString ("type"));
                            userList.add (obj);
                        }
                    statement.close ();
                    resultSet.close ();
                } catch (SQLException e)
                {
                    System.out.println (e.getMessage ());
                }
            return userList;
        }


    public static String searchQuery (String name , String uname , String type)
        {
            String query = "SELECT * FROM user WHERE uname LIKE '%{{uname}}%' AND name LIKE '%{{name}}%'";
            query = query.replace ("{{uname}}" , uname);
            query = query.replace ("{{name}}" , name);
            if ( !type.isEmpty () )
                {
                    query += " AND type= '{{type}}'";
                    query = query.replace ("{{type}}" , type);
                }
            query = query.replace ("{{type}}" , type);

            return query;


        }

    public static ArrayList<User> getOnlyEducator ()
        {
            ArrayList<User> userList = new ArrayList<> ();
            String query = "SELECT * FROM user WHERE type= 'educator'";
            try
                {
                    Statement statement = DBConnector.getInstance ().createStatement ();
                    ResultSet resultSet = statement.executeQuery (query);
                    User obj;
                    while (resultSet.next ())
                        {
                            obj = new User ();
                            obj.setId (resultSet.getInt ("id"));
                            obj.setName (resultSet.getString ("name"));
                            obj.setUname (resultSet.getString ("uname"));
                            obj.setPass (resultSet.getString ("pass"));
                            obj.setType (resultSet.getString ("type"));
                            userList.add (obj);
                        }
                    statement.close ();
                    resultSet.close ();
                } catch (SQLException e)
                {
                    System.out.println (e.getMessage ());
                }
            return userList;
        }


}
