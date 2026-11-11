package aralinks.users;

import aralinks.exception.InvalidScheduleException;
import aralinks.model.Course;
import aralinks.model.Availability;
import aralinks.model.TutoringSession;
import aralinks.model.Request;
import aralinks.model.Review;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.LocalDate;
import aralinks.exception.InvalidRateException;
import aralinks.exception.InvalidRequestStateException;

public class Tutor extends User {
    private final List<Course> courses = new ArrayList<>();
    private final List<Availability> availableSchedules = new ArrayList<>();
    private double hourlyRate;
    private String bio;
    private double averageRating;

    public Tutor(String userId, String srCode, String name, String email, String password,
                 String university, double hourlyRate, String bio) {
        super(userId, srCode, name, email, password, university);
        this.hourlyRate = hourlyRate; this.bio = bio;
    }

    @Override public String getRole() { 
        return "Tutor"; 
    }
    @Override public List<String> displayMenu() { 
        return List.of(
        "My Classes", 
        "Requests", 
        "History", 
        "Profile"
        ); 
    }

    public void addCourse(Course c) { 
        throw new java.lang.UnsupportedOperationException("TODO"); 
    }

    public void removeCourse(Course c) { 
        throw new java.lang.UnsupportedOperationException("TODO"); 
    }

    public void setRate(double rate) throws InvalidRateException 
    { throw new java.lang.UnsupportedOperationException("TODO"); 

    }
    public void addAvailability(DayOfWeek day, LocalTime start, LocalTime end) throws InvalidScheduleException {
        throw new java.lang.UnsupportedOperationException("TODO");
    }
    public boolean isAvailable(DayOfWeek day, LocalTime start, LocalTime end) { 
        throw new java.lang.UnsupportedOperationException("TODO"); 
    }
    public TutoringSession acceptRequest(Request r, String sessionId, LocalDate date) throws InvalidRequestStateException {
        throw new java.lang.UnsupportedOperationException("TODO");
    }
    public void declineRequest(Request r) throws InvalidRequestStateException { 
        throw new java.lang.UnsupportedOperationException("TODO"); 
    }

    public void completeSession(TutoringSession s) { 
        throw new java.lang.UnsupportedOperationException("TODO"); 
    }
    public double computeAverageRating(List<Review> all) { 
        throw new java.lang.UnsupportedOperationException("TODO"); 
    }

    public List<Course> getCourses() { 
        return Collections.unmodifiableList(courses); 
    }
    public List<Availability> getAvailableSchedules() { 
        return Collections.unmodifiableList(availableSchedules); 
    }

    public double getHourlyRate() { 
        return hourlyRate; 
    }

    public String getBio() { 
        return bio; 
    }
    public double getAverageRating() { 
        return averageRating; 
    }
}