package hw7;


public class Department {
	public String name;
	public Company company;
	public void manager(Manager manager) {
		manager.manageDepartment(this);
	};
	public void make(Product[] products) {
		
	};
}
