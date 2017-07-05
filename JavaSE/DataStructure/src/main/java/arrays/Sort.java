package arrays;

import java.util.Arrays;

public class Sort {
	public static void main(String[] args) {
		Employee[] staff = new Employee[3];

		staff[0] = new Employee("Harry", 35000);
		staff[1] = new Employee("Carl", 75000);
		staff[2] = new Employee("Tony", 38000);

		Arrays.sort(staff);

		for (Employee e : staff) {
			System.out.println("name=" + e.getName() + "\t,salary=" + e.getSalary());
		}
	}
}

class Employee implements Comparable<Employee> {
	private String name;
	private double salary;

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public int compareTo(Employee other) {
		return Double.compare(salary, other.salary);
	}
}