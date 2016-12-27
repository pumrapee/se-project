package se.team11.studentprofile.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Subject {

    /**
     */
    @NotNull
    @Pattern(regexp = "\\d{6}")
    private String subjectID;

    /**
     */
    @NotNull
    private String subjectName;

    /**
     */
    @NotNull
    private Integer weight;
}
