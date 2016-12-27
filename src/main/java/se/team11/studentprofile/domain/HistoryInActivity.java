package se.team11.studentprofile.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class HistoryInActivity {

    /**
     */
    @ManyToOne
    private Student Student;

    /**
     */
    @NotNull
    private String HistoryID;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Activity> Activity = new HashSet<Activity>();
}
