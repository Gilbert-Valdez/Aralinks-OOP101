package aralinks.model;

import aralinks.exception.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

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

    @Override public String getRole() { return "Tutor"; }
    @Override public List<String> displayMenu() { return List.of("My Classes", "Requests", "History", "Profile"); }

    public void addCourse(Course c)    { throw new UnsupportedOperationException("TODO"); }
    public void removeCourse(Course c) { throw new UnsupportedOperationException("TODO"); }
    public void setRate(double rate) throws InvalidRateException { throw new UnsupportedOperationException("TODO"); }
    public void addAvailability(DayOfWeek day, LocalTime start, LocalTime end) throws InvalidScheduleException {
        throw new UnsupportedOperationException("TODO");
    }
    public boolean isAvailable(DayOfWeek day, LocalTime start, LocalTime end) { throw new UnsupportedOperationException("TODO"); }
    public TutoringSession acceptRequest(Request r, String sessionId, LocalDate date) throws InvalidRequestStateException {
        throw new UnsupportedOperationException("TODO");
    }
    public void declineRequest(Request r) throws InvalidRequestStateException { throw new UnsupportedOperationException("TODO"); }
    public void completeSession(TutoringSession s) { throw new UnsupportedOperationException("TODO"); }
    public double computeAverageRating(List<Review> all) { throw new UnsupportedOperationException("TODO"); }

    public List<Course> getCourses() { return Collections.unmodifiableList(courses); }
    public List<Availability> getAvailableSchedules() { return Collections.unmodifiableList(availableSchedules); }
    public double getHourlyRate() { return hourlyRate; }
    public String getBio() { return bio; }
    public double getAverageRating() { return averageRating; }
}