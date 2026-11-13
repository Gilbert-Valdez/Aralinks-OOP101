package aralinks.users;

import aralinks.exception.DuplicateRequestException;
import aralinks.exception.InvalidRatingException;
import aralinks.exception.InvalidRequestStateException;
import aralinks.exception.InvalidScheduleException;
import aralinks.exception.UnavailableScheduleException;
import aralinks.model.Course;
import aralinks.model.Request;
import aralinks.model.Review;
import aralinks.model.TutoringSession;
import aralinks.model.enums.SessionStatus;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Learner extends User {
    private final List<Request> requestsMade = new ArrayList<>();
    private final List<TutoringSession> sessionHistory = new ArrayList<>();
    private int yearLevel;
    private String program;

    public Learner(String userId, String srCode, String name, String email, String password,
                   String university, int yearLevel, String program) {
        super(userId, srCode, name, email, password, university);
        this.yearLevel = yearLevel;
        this.program = program;
    }

    @Override public String getRole() { return "Learner"; }

    @Override
    public List<String> displayMenu() { return List.of("Browse Classes", "My Classes", "Sessions", "Profile"); }

    /** Active tutors who teach the course (null = any) and charge at most maxRate. */
    public List<Tutor> searchTutors(List<Tutor> allTutors, Course course, double maxRate) {
        List<Tutor> matches = new ArrayList<>();
        for (Tutor t : allTutors) {
            if (t.isActive() && t.getHourlyRate() <= maxRate && (course == null || t.teaches(course))) matches.add(t);
        }
        return matches;
    }

    public String viewTutorProfile(Tutor tutor) {
        return tutor.getName() + " · PHP " + tutor.getHourlyRate() + "/hr · ★ " + tutor.getAverageRating()
                + "\nCourses: " + tutor.getCourses() + "\nAvailable: " + tutor.getAvailableSchedules()
                + "\n" + tutor.getBio();
    }

    public Request submitRequest(String requestId, Tutor tutor, Course course, DayOfWeek day,
                                 LocalTime start, LocalTime end, String message)
            throws InvalidScheduleException, UnavailableScheduleException, DuplicateRequestException {
        if (start == null || end == null || !end.isAfter(start)) {
            throw new InvalidScheduleException("End time must be after the start time.");
        }
        if (!tutor.isAvailable(day, start, end)) {
            throw new UnavailableScheduleException(tutor.getName() + " isn't available on " + day + " at " + start + ".");
        }
        for (Request r : requestsMade) {
            if (r.isPending() && r.getTutor() == tutor) {
                throw new DuplicateRequestException("You already have a pending request with " + tutor.getName() + ".");
            }
        }
        Request request = new Request(requestId, this, tutor, course, day, start, end, message);
        requestsMade.add(request);
        return request;
    }

    public void cancelRequest(Request request) throws InvalidRequestStateException {
        if (!requestsMade.contains(request)) throw new IllegalArgumentException("That isn't your request.");
        request.cancel();
    }

    public Review rateSession(String reviewId, TutoringSession session, int rating, String comment)
            throws InvalidRatingException {
        if (session.getStatus() != SessionStatus.COMPLETED || !session.includes(this)) {
            throw new IllegalStateException("You can only rate completed sessions you joined.");
        }
        return new Review(reviewId, session, this, rating, comment);
    }

    /** Called by TutoringSession.addLearner(). Public because TutoringSession is in another package. */
    public void addToHistory(TutoringSession session) {
        if (!sessionHistory.contains(session)) sessionHistory.add(session);
    }

    public List<Request> getRequestsMade()           { return Collections.unmodifiableList(requestsMade); }
    public List<TutoringSession> getSessionHistory() { return Collections.unmodifiableList(sessionHistory); }
    public int getYearLevel()                        { return yearLevel; }
    public String getProgram()                       { return program; }
}