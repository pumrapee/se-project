package se.team11.studentprofile.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class ConductPointHistory {

    /**
     */
    @NotNull
    @ManyToOne
    private Student StudentID;

    /**
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date ActionDate;

    /**
     */
    @NotNull
    @Size(min = 6, max = 6)
    private String Term;

    /**
     */
    @NotNull
    @Size(min = 5,max = 1000)
    private String History;

    /**
     */
    @NotNull
    private Float Point;
}
