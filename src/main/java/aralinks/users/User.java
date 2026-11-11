package aralinks.users;

import java.util.List;

public abstract class User {
    private final String userId, srCode;
    private String name, email, password, university;
    private boolean active = true;

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