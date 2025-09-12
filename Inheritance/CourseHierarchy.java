// Base class
class Course {
    String courseName;
    int duration; // in weeks

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    void displayInfo() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " weeks");
    }
}

// Subclass of Course
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Platform: " + platform + ", Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

// Subclass of OnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount; // in percentage

    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded,
                     double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    double getFinalFee() {
        return fee - (fee * discount / 100);
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Fee: Rs." + fee + ", Discount: " + discount + "%, Final Fee: Rs." + getFinalFee());
    }
}

// Testing class
public class CourseHierarchy {
    public static void main(String[] args) {
        Course c1 = new Course("Mathematics Basics", 6);
        OnlineCourse c2 = new OnlineCourse("Java Programming", 8, "Coursera", true);
        PaidOnlineCourse c3 = new PaidOnlineCourse("Data Science Bootcamp", 12, "Udemy", true, 500.0, 20.0);

        c1.displayInfo();
        System.out.println();
        c2.displayInfo();
        System.out.println();
        c3.displayInfo();
    }
}
