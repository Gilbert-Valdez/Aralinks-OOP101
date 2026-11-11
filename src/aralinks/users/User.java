package aralinks.model;

import java.util.List;

public abstract class User { //abstract para di nila mainstantaniate yung user, it needs to be a tutee, tutor or admin object first
    private final String userId, srCode; //cannot be changed after setting id and code
    private String name, email, password, university; 
    private boolean active = true; // for checking status ng acc (admin role to deactivate accs ng grads and similar cases)

    //protected ang constructor na to kasi di sya pwede tawagin to be an object
    //pero pwede sya tawagin ni child classes gaya ng tutor to inherit these attributes
    protected User(String userId, String srCode, String name, String email, String password, String university) {
        this.userId = userId; 
        this.srCode = srCode; 
        this.name = name;
        this.email = email;
        this.password = password; 
        this.university = university;
    }


    public boolean login(String password) { return active && this.password.equals(password); }

    //void since we dont have to return these accepted strings after receinving input
   public void updateProfile(String name, String email, String university) {
    this.name = name;
    this.email = email;
    this.university = university;
}

    public abstract String getRole();
    public abstract List<String> displayMenu();

    public String getUserId()     { return userId; }
    public String getSrCode()     { return srCode; }
    public String getName()       { return name; }
    public String getEmail()      { return email; }
    public String getUniversity() { return university; }
    public boolean isActive()     { return active; }
    void setActive(boolean active) { this.active = active; }
}