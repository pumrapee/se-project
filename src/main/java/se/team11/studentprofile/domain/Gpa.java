package se.team11.studentprofile.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.Enumerated;
import java.util.Calendar;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findGpasByStudent" })
public class Gpa {

    /**
     */
    @NotNull
    //@Pattern(regexp = "\\d{6}")
    @Size(min = 6, max = 6)
    private String gradeID;

    /**
     */
    @NotNull
    @ManyToOne
    private Student student;

    /**
     */
    @NotNull
    @ManyToMany
    private Set<Subject> subject = new HashSet<Subject>();

    /**
     */
    @NotNull
    @Enumerated
    private Semester semester;

    /**
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy")
    private Calendar schoolYear;

    /**
     */
    @NotNull
    private Float gpaPoint;
}
