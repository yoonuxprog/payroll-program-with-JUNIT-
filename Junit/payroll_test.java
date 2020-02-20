import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;




class payroll_test {
	

	
	@Test
	public void salary_pass()
	{
		// for employee type P
		assertEquals(2400, payroll_method.get_salary(60, 30, 20),"error in salary calculation for P");
		assertEquals(450, payroll_method.get_salary(15, 30, 0),"error in salary calculation for P");
		// for employee type F
		assertEquals(1800, payroll_method.get_salary(40, 45, 0),"error in salary calculation for F");
	
	}
	
	@Test
	public void salary_fail()
	{
		// for employee type P
		assertNotEquals(2000, payroll_method.get_salary(60, 30, 20),"error in salary calculation for P");
		assertNotEquals(2000, payroll_method.get_salary(15, 30, 0),"error in salary calculation for P");
		// for employee type F
		assertNotEquals(1000, payroll_method.get_salary(40, 45, 0),"error in salary calculation for P");
		
	}
	
	@Test
	public void test_additionalhourspass()
	{
		assertEquals(20, payroll_method.get_add_hours(60),"error in add_hour calculation for P");
	}
	
	@Test
	public void test_additionalhoursfail()
	{
		assertNotEquals(15, payroll_method.get_add_hours(60),"error in add_hour calculation for P");
	}
	
	@Test
	public void test_emptype_pass()
	{
		assertEquals(true, payroll_method.getEmploymentType("P"),"error in emplpoyment type");
		assertEquals(true, payroll_method.getEmploymentType("F"),"error in emplpoyment type");
		assertEquals(false, payroll_method.getEmploymentType("A"),"error in emplpoyment type");
	}
	
	@Test
	public void test_emptype_fail()
	{
		assertNotEquals(true, payroll_method.getEmploymentType("A"),"error in emplpoyment type");
		assertNotEquals(false, payroll_method.getEmploymentType("F"),"error in emplpoyment type");
		assertNotEquals(false, payroll_method.getEmploymentType("P"),"error in emplpoyment type");
	}
	
	@Test
	public void pass_test_hours()
	{
		assertThrows(RuntimeException.class, ()->{payroll_method.get_hours(10, 60);});
		assertEquals(20, payroll_method.get_hours(20, 60));
		assertThrows(RuntimeException.class, ()->{payroll_method.get_hours(80, 60);});
		assertThrows(RuntimeException.class, ()->{payroll_method.get_hours(14, 60);});
		assertEquals(15, payroll_method.get_hours(15, 60));
		assertEquals(16, payroll_method.get_hours(16, 60));
		assertEquals(59, payroll_method.get_hours(59, 60));
		assertEquals(50, payroll_method.get_hours(60, 60));
		assertThrows(RuntimeException.class, ()->{payroll_method.get_hours(61, 60);});
	}
	

	
	@Test
	public void pass_test_getID()
	{
		assertEquals(true, payroll_method.Get_ID(123123),"error in ID");
		assertEquals(false, payroll_method.Get_ID(12312),"error in ID");
		assertEquals(false, payroll_method.Get_ID(1123123),"error in ID");
		
	}
	
	@Test
	public void fail_test_getID()
	{
		assertNotEquals(false, payroll_method.Get_ID(123123),"error in id");
		assertNotEquals(true, payroll_method.Get_ID(12323),"error in id");
		assertNotEquals(true, payroll_method.Get_ID(1231123),"error in id");
		
	}
	
	@Test
	public void test_pass_hour_rate()
	{
		// testing max and min for employee type P
		assertEquals(false, payroll_method.get_Rate(15, 30, 45),"error in hour rate");
		assertEquals(true, payroll_method.get_Rate(35, 30, 45),"error in hour rate");
		assertEquals(false, payroll_method.get_Rate(60, 30, 45),"error in hour rate");
		assertEquals(false, payroll_method.get_Rate(29, 30, 45),"error in hour rate");
		assertEquals(true, payroll_method.get_Rate(30, 30, 45),"error in hour rate");
		assertEquals(true, payroll_method.get_Rate(31, 30, 45),"error in hour rate");
		assertEquals(true, payroll_method.get_Rate(44, 30, 45),"error in hour rate");
		assertEquals(true, payroll_method.get_Rate(45, 30, 45),"error in hour rate");
		assertEquals(false, payroll_method.get_Rate(46, 30, 45),"error in hour rate");
		
	}
	
	@Test
	public void test_fail_hour_rate()
	{
		assertNotEquals(true, payroll_method.get_Rate(15, 30, 45),"error in hour rate");
		assertNotEquals(false, payroll_method.get_Rate(35, 30, 45),"error in hour rate");
		assertNotEquals(true, payroll_method.get_Rate(60, 30, 45),"error in hour rate");
		assertNotEquals(true, payroll_method.get_Rate(29, 30, 45),"error in hour rate");
		assertNotEquals(false, payroll_method.get_Rate(30, 30, 45),"error in hour rate");
		assertNotEquals(false, payroll_method.get_Rate(31, 30, 45),"error in hour rate");
		assertNotEquals(false, payroll_method.get_Rate(44, 30, 45),"error in hour rate");
		assertNotEquals(false, payroll_method.get_Rate(45, 30, 45),"error in hour rate");
		assertNotEquals(true, payroll_method.get_Rate(46, 30, 45),"error in hour rate");
	}
	
	
	
	
	
	
	

}
