package com.ashish.bean;

import java.util.LinkedList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>EmployeeBeanTest</code> contains tests for the class <code>{@link EmployeeBean}</code>.
 *
 * @generatedBy CodePro at 6/9/18 6:16 PM
 * @author manish
 * @version $Revision: 1.0 $
 */
public class EmployeeBeanTest {
	/**
	 * Run the EmployeeBean() constructor test.
	 *
	 * @generatedBy CodePro at 6/9/18 6:16 PM
	 */
	@Test
	public void testEmployeeBean_1()
		throws Exception {
		EmployeeBean result = new EmployeeBean();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the String getCityName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/9/18 6:16 PM
	 */
	@Test
	public void testGetCityName_1()
		throws Exception {
		EmployeeBean fixture = new EmployeeBean();
		fixture.setSubEmpployee(new LinkedList());
		fixture.setFirstName("");
		fixture.setCityName("");
		fixture.setEmployeeId(new Long(1L));
		fixture.setSalary(1L);
		fixture.setManagerEmployeeId(1L);
		fixture.setSecondName("");

		String result = fixture.getCityName();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the long getEmployeeId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/9/18 6:16 PM
	 */
	@Test
	public void testGetEmployeeId_1()
		throws Exception {
		EmployeeBean fixture = new EmployeeBean();
		fixture.setSubEmpployee(new LinkedList());
		fixture.setFirstName("");
		fixture.setCityName("");
		fixture.setEmployeeId(new Long(1L));
		fixture.setSalary(1L);
		fixture.setManagerEmployeeId(1L);
		fixture.setSecondName("");

		long result = fixture.getEmployeeId();

		// add additional test code here
		assertEquals(1L, result);
	}

	/**
	 * Run the String getFirstName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/9/18 6:16 PM
	 */
	@Test
	public void testGetFirstName_1()
		throws Exception {
		EmployeeBean fixture = new EmployeeBean();
		fixture.setSubEmpployee(new LinkedList());
		fixture.setFirstName("");
		fixture.setCityName("");
		fixture.setEmployeeId(new Long(1L));
		fixture.setSalary(1L);
		fixture.setManagerEmployeeId(1L);
		fixture.setSecondName("");

		String result = fixture.getFirstName();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the long getManagerEmployeeId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/9/18 6:16 PM
	 */
	@Test
	public void testGetManagerEmployeeId_1()
		throws Exception {
		EmployeeBean fixture = new EmployeeBean();
		fixture.setSubEmpployee(new LinkedList());
		fixture.setFirstName("");
		fixture.setCityName("");
		fixture.setEmployeeId(new Long(1L));
		fixture.setSalary(1L);
		fixture.setManagerEmployeeId(1L);
		fixture.setSecondName("");

		long result = fixture.getManagerEmployeeId();

		// add additional test code here
		assertEquals(1L, result);
	}

	/**
	 * Run the long getSalary() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/9/18 6:16 PM
	 */
	@Test
	public void testGetSalary_1()
		throws Exception {
		EmployeeBean fixture = new EmployeeBean();
		fixture.setSubEmpployee(new LinkedList());
		fixture.setFirstName("");
		fixture.setCityName("");
		fixture.setEmployeeId(new Long(1L));
		fixture.setSalary(1L);
		fixture.setManagerEmployeeId(1L);
		fixture.setSecondName("");

		long result = fixture.getSalary();

		// add additional test code here
		assertEquals(1L, result);
	}

	/**
	 * Run the String getSecondName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/9/18 6:16 PM
	 */
	@Test
	public void testGetSecondName_1()
		throws Exception {
		EmployeeBean fixture = new EmployeeBean();
		fixture.setSubEmpployee(new LinkedList());
		fixture.setFirstName("");
		fixture.setCityName("");
		fixture.setEmployeeId(new Long(1L));
		fixture.setSalary(1L);
		fixture.setManagerEmployeeId(1L);
		fixture.setSecondName("");

		String result = fixture.getSecondName();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the List<Long> getSubEmpployee() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/9/18 6:16 PM
	 */
	@Test
	public void testGetSubEmpployee_1()
		throws Exception {
		EmployeeBean fixture = new EmployeeBean();
		fixture.setSubEmpployee(new LinkedList());
		fixture.setFirstName("");
		fixture.setCityName("");
		fixture.setEmployeeId(new Long(1L));
		fixture.setSalary(1L);
		fixture.setManagerEmployeeId(1L);
		fixture.setSecondName("");

		List<Long> result = fixture.getSubEmpployee();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the void setCityName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/9/18 6:16 PM
	 */
	@Test
	public void testSetCityName_1()
		throws Exception {
		EmployeeBean fixture = new EmployeeBean();
		fixture.setSubEmpployee(new LinkedList());
		fixture.setFirstName("");
		fixture.setCityName("");
		fixture.setEmployeeId(new Long(1L));
		fixture.setSalary(1L);
		fixture.setManagerEmployeeId(1L);
		fixture.setSecondName("");
		String cityName = "";

		fixture.setCityName(cityName);

		// add additional test code here
	}

	/**
	 * Run the void setEmployeeId(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/9/18 6:16 PM
	 */
	@Test
	public void testSetEmployeeId_1()
		throws Exception {
		EmployeeBean fixture = new EmployeeBean();
		fixture.setSubEmpployee(new LinkedList());
		fixture.setFirstName("");
		fixture.setCityName("");
		fixture.setEmployeeId(new Long(1L));
		fixture.setSalary(1L);
		fixture.setManagerEmployeeId(1L);
		fixture.setSecondName("");
		Long long1 = new Long(1L);

		fixture.setEmployeeId(long1);

		// add additional test code here
	}

	/**
	 * Run the void setFirstName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/9/18 6:16 PM
	 */
	@Test
	public void testSetFirstName_1()
		throws Exception {
		EmployeeBean fixture = new EmployeeBean();
		fixture.setSubEmpployee(new LinkedList());
		fixture.setFirstName("");
		fixture.setCityName("");
		fixture.setEmployeeId(new Long(1L));
		fixture.setSalary(1L);
		fixture.setManagerEmployeeId(1L);
		fixture.setSecondName("");
		String firstName = "";

		fixture.setFirstName(firstName);

		// add additional test code here
	}

	/**
	 * Run the void setManagerEmployeeId(long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/9/18 6:16 PM
	 */
	@Test
	public void testSetManagerEmployeeId_1()
		throws Exception {
		EmployeeBean fixture = new EmployeeBean();
		fixture.setSubEmpployee(new LinkedList());
		fixture.setFirstName("");
		fixture.setCityName("");
		fixture.setEmployeeId(new Long(1L));
		fixture.setSalary(1L);
		fixture.setManagerEmployeeId(1L);
		fixture.setSecondName("");
		long managerEmployeeId = 1L;

		fixture.setManagerEmployeeId(managerEmployeeId);

		// add additional test code here
	}

	/**
	 * Run the void setSalary(long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/9/18 6:16 PM
	 */
	@Test
	public void testSetSalary_1()
		throws Exception {
		EmployeeBean fixture = new EmployeeBean();
		fixture.setSubEmpployee(new LinkedList());
		fixture.setFirstName("");
		fixture.setCityName("");
		fixture.setEmployeeId(new Long(1L));
		fixture.setSalary(1L);
		fixture.setManagerEmployeeId(1L);
		fixture.setSecondName("");
		long salary = 1L;

		fixture.setSalary(salary);

		// add additional test code here
	}

	/**
	 * Run the void setSecondName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/9/18 6:16 PM
	 */
	@Test
	public void testSetSecondName_1()
		throws Exception {
		EmployeeBean fixture = new EmployeeBean();
		fixture.setSubEmpployee(new LinkedList());
		fixture.setFirstName("");
		fixture.setCityName("");
		fixture.setEmployeeId(new Long(1L));
		fixture.setSalary(1L);
		fixture.setManagerEmployeeId(1L);
		fixture.setSecondName("");
		String secondName = "";

		fixture.setSecondName(secondName);

		// add additional test code here
	}

	/**
	 * Run the void setSubEmpployee(List<Long>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/9/18 6:16 PM
	 */
	@Test
	public void testSetSubEmpployee_1()
		throws Exception {
		EmployeeBean fixture = new EmployeeBean();
		fixture.setSubEmpployee(new LinkedList());
		fixture.setFirstName("");
		fixture.setCityName("");
		fixture.setEmployeeId(new Long(1L));
		fixture.setSalary(1L);
		fixture.setManagerEmployeeId(1L);
		fixture.setSecondName("");
		List<Long> subEmpployee = new LinkedList();

		fixture.setSubEmpployee(subEmpployee);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 6/9/18 6:16 PM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 6/9/18 6:16 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 6/9/18 6:16 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(EmployeeBeanTest.class);
	}
}