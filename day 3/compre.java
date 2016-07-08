package Linked;

import java.util.Comparator;

public class compre implements Comparator<Employee>{

	 	public int compare(Employee e1,Employee e2)
		{
			if (e1.getSalary()<e2.getSalary())
			{
				return 1;
			}
			else
			{
				return -1;
			}
		}
	}
	
	
	
	
	

