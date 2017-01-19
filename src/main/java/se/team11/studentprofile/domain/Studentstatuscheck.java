package se.team11.studentprofile.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Studentstatuscheck {

    /**
     */
    @ManyToOne
    private Student studentID;

    /**
     */
    @ManyToOne
    private Gpa gpaPoint;

    /**
     */
    @ManyToOne
    private Cashier paystatus;

    /**
     */
    @ManyToOne
    private HealthCareHistory HealthCareHistory;

    /**
     */
    @ManyToOne
    private HistoryInActivity HistoryInActivity;

    /**
     */
    @NotNull
    @Size(min = 2, max = 10)
    private String status;
}
