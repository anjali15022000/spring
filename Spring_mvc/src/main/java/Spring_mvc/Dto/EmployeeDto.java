package Spring_mvc.Dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Entity
public class EmployeeDto {
	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", name=" + name + "]";
	}
	@Id
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
