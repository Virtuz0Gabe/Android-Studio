package devandroid.gabriel.catologcourses.models;
import java.util.List;
public class Course {
    private String title;
    private String subtitle;
    private List<Instructor> instructors;

    // === GETTERS =================================================================    public String getTitle() {
    public String getTitle(){
        return title;
    }
    public String getSubtitle() {
        return subtitle;
    }
    public List<Instructor> getInstructors() {
        return instructors;
    }
    // === SETTERS =================================================================
    public void setTitle(String title) {
        this.title = title;
    }
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }
}
