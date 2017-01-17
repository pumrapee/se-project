package se.team11.studentprofile.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class AnnouncementOfActivity {

    /**
     */
    @NotNull
    @Column(unique = true)
    @Size(min = 6, max = 6)
    private String AnnouncementOfActivityID;

    /**
     */
    private String AnnouncementOfActivityName;

    /**
     */
    @NotNull
    @Min(0L)
    private Integer AnnouncementOfActivityRemain;
}
