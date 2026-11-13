package aralinks.users;

import aralinks.model.TutoringClass;
import aralinks.model.enums.ClassStatus;

import java.util.List;

public class Administrator extends User {
    private final String adminId; //di na machacchange si Id upon entry

    public Administrator(String userId, String adminId, String srCode, String name, String email, String password, String university) {
        super(userId, srCode, name, email, password, university);
        this.adminId = adminId;
    }

    @Override public String getRole() { return "Administrator"; }

    @Override
    public List<String> displayMenu() { return List.of("Users", "Listings", "Records"); }

    public void manageUser(User user, boolean active) {
        if (user == this) throw new IllegalArgumentException("You can't deactivate your own account.");
        user.setActive(active);
    }

    public void removeListing(TutoringClass listing) { listing.cancel(); }

    public String viewRecords(List<User> users, List<TutoringClass> classes) {
        int tutors = 0, learners = 0, open = 0;
        for (User u : users) {
            if (u instanceof Tutor) tutors++;
            else if (u instanceof Learner) learners++;
        }
        for (TutoringClass c : classes) if (c.getStatus() == ClassStatus.OPEN) open++;
        return users.size() + " users · " + tutors + " tutors · " + learners + " learners · " + open + " open classes";
    }

    public String getAdminId() { return adminId; }
}