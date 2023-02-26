package models;

public class Request {
    protected String Name;
    protected String Password;
    protected String Type;
    public Request(){ }
    public Request(String name, String password, String type){
        this.Name = name;
        this.Password = password;
        this.Type = type;
    }


    public String getName() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }

    public String getType() {
        return Type;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "{'name':\"" + Name + "\""
                + ", 'password':\"" + Password + "\""
                + ", 'type':\"" + Type + "\"" + "}";
    }
}
