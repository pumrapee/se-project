package se.team11.studentprofile.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Student {

    /**
     */
    @NotNull
    @Column(unique = true)
    //@Pattern(regexp = "\d{7}")
    @Size(min = 7, max = 7)
    private String studentID;

    /**
     */
    @NotNull
    private String firstName;

    /**
     */
    @NotNull
    private String lastName;

    /**
     */
    @NotNull
    @Enumerated
    private Grade grade;

    /**
     */
    @NotNull
    private Integer numberOfActivity;
}
