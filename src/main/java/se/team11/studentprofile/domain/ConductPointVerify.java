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
public class ConductPointVerify {

    /**
     */
    @NotNull
    @ManyToOne
    private Student Student;

    /**
     */
    @NotNull
    private Float TotalScore;

    /**
     */
    @NotNull
    @Size(min = 4, max = 100)
    private String Info;

    /**
     */
    private Boolean status;
}
