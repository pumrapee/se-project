package se.team11.studentprofile.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Gpax {

    /**
     */
    @NotNull
    @Size(min = 6, max = 6)
    private String gpaxID;

    /**
     */
    @NotNull
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Gpa> gpa = new HashSet<Gpa>();

    /**
     */
    @NotNull
    private Float gpaxPoint;
}
