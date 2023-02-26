package controllers;

import models.Request;
import models.User;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class MainController {
    public static void Listing() throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(9876);
        //keep listens indefinitely until receives 'exit' call or program terminates
        while(true){
            System.out.println("Waiting for the client request");
            //creating socket and waiting for client connection
            Socket socket = server.accept();
            //read from socket to ObjectInputStream object
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //convert ObjectInputStream object to String
            String message = (String) ois.readObject();
            //create ObjectOutputStream object
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            //write object to Socket

            ObjectMapper mapper = new ObjectMapper();
            Request request = mapper.readValue(message, Request.class);

            if(request.getType().equals("login")){
                if(Login(request)){
                    System.out.println("Login ok: " + request.getName());
                    oos.writeObject("Login ok");
                }
                else{
                    System.out.println("Login failed: " + request.getName());
                    oos.writeObject("Login failed");
                }
            }
            else if(request.getType().equals("registration")){
                if(Registration(request)){
                    System.out.println("Registration ok: " + request.getName());
                    oos.writeObject("Registration ok");
                }
                else{
                    System.out.println("Registration failed: " + request.getName());
                    oos.writeObject("Registration failed");
                }
            }
            else if(request.getType().equals("exit")) {
                oos.writeObject("server stopped");
            }
            //close resources
            ois.close();
            oos.close();
            socket.close();
            //terminate the server if client sends exit request
            if(request.getType().equals("exit")) break;
            ShowUsers();
        }
        //close the ServerSocket object
        server.close();
    }
    private static boolean Login(Request request){
        UserController userController = new UserController();
        List<User> users = userController.getName(request.getName());
        long count = users.stream().filter(u->u.getName().equals(request.getName()) && u.getPassword().equals(request.getPassword())).count();
        if(count > 0) return true;
        else return false;
    }
    private static boolean Registration(Request request){
        UserController userController = new UserController();
        User user = new User(request.getName(), request.getPassword());
        long id = userController.save(user);
        if (id > 0) return true;
        else return false;
    }
    private static void ShowUsers(){
        System.out.println("\nShow users:");
        System.out.println("id\tlogin\tpassword");
        UserController userController = new UserController();
        List<User> users = userController.getAll();
        for (var user: users) {
            System.out.println(user.getId() + "\t" + user.getName() + "\t" + user.getPassword());
        }
        System.out.println();
    }
}
