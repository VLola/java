package controllers;

import models.Request;
import org.json.JSONObject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class MainController {
    public static void Load() throws IOException, ClassNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.println("enter number:");
        System.out.println("1 - registration user");
        System.out.println("2 - login user");
        System.out.println("3 - stop server");
        int number = console.nextInt();
        if(number == 1){
            Request request = createRequest("registration");
            JSONObject json = createJson(request);
            sendJson(json);
        }
        else if(number == 2){
            Request request = createRequest("login");
            JSONObject json = createJson(request);
            sendJson(json);
        }
        else if(number == 3){
            Request request = new Request();
            request.setType("exit");
            JSONObject json = createJson(request);
            sendJson(json);
        }
    }
    private static Request createRequest(String type){
        Scanner console = new Scanner(System.in);
        System.out.println("enter name");
        String name = console.nextLine();
        System.out.println("enter password");
        console = new Scanner(System.in);
        String password = console.nextLine();
        Request request = new Request(name, password, type);
        return request;
    }
    private static JSONObject createJson(Request request){
        JSONObject json = new JSONObject(request);
        return json;
    }
    private static void sendJson(JSONObject json) throws IOException, ClassNotFoundException {
        System.out.println("Loading.....");
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = new Socket(host.getHostName(), 9876);
        //write to socket using ObjectOutputStream
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        oos.writeObject(json.toString());

        //read the server response message
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        String message = (String) ois.readObject();
        System.out.println("Message: " + message);
        //close resources
        ois.close();
        oos.close();
    }
}
