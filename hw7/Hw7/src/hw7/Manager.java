package hw7;


public class Manager extends Person {
	public Project[] projects;
	public void manageDepartment(Department department) {
		department.manager(this);
	}
}
