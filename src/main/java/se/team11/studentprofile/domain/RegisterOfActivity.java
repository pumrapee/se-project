package se.team11.studentprofile.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Column;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class RegisterOfActivity {

    /**
     */
    @NotNull
    @ManyToOne
    private Student Student;

    /**
     */
    @NotNull
    @Column(unique = true)
    @Size(min = 11, max = 11)
    private String RegisterOfActivityID;

    /**
     */
    @ManyToOne
    private AnnouncementOfActivity AnnouncementOfActivity;

    /**
     */
    private Boolean Status;
}
