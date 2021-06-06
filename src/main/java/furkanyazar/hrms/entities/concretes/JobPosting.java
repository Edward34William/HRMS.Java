package furkanyazar.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @PrimaryKeyJoinColumn(name = "user_id")
// @PrimaryKeyJoinColumn(name = "job_id")
// @PrimaryKeyJoinColumn(name = "city_id")
@Data
@Entity
@Table(name = "job_postings")
// @Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
public class JobPosting {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;

    // @Column(name = "job_id")
	// private int jobId;

    // @Column(name = "city_id")
	// private int cityId;

    // @Column(name = "user_id")
	// private int userId;

    @Column(name = "description")
    private String description;

    @Column(name = "salary_range")
    private String salaryRange;

    @Column(name = "open_position")
    private int openPosition;

    @Column(name = "application_deadline")
    private Date applicationDeadline;

    @Column(name = "is_activated")
    private Boolean isActivated;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
