package aralinks.users;

import java.util.List;

// abstract to guys para di yung mismong user object ang maiinstantaniate 
//bale reference class lang to para yung atttributes nya is mainherit ni
// tutor, admin and tutee 
// kumbaga sa User class mageextend yung tatlo, pero ito mismo ay bawal instantaniate as an object user
public abstract class User {
    private final String userId, srCode;
    private String name, email, password, university;
    private boolean active = true;

// protected for the same reason kasi abstract pa i2
    protected User(String userId, String srCode, String name, String email, String password, String university) {
        this.userId = userId; 
        this.srCode = srCode; 
        this.name = name;
        this.email = email;
        this.password = password; 
        this.university = university;
    }

    public boolean login(String password) { return active && this.password.equals(password); }

    public void updateProfile(String name, String email, String university) {
        throw new UnsupportedOperationException("TODO: User.updateProfile");
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