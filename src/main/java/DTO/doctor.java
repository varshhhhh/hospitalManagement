package DTO;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.id.enhanced.InitialValueAwareOptimizer;

import lombok.Data;
import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial;

@Entity
@Data
public class doctor {

	@Id
	@GeneratedValue(generator="doctorid")
	@SequenceGenerator(initialValue=121045,allocationSize=1, name="doctorid",sequenceName="doctorid")													
	private int id;
	private String name;
	private long mobile;
	private String email;
	private String password;
	private Date dob;
	private int age;
	private boolean status;
	private String qualification;
	private String specialization;
	private String gender;
	private boolean availability;
	
	
//	@OneToMany
//	List<appointment> appointment;

}
