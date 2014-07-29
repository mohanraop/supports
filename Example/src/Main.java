public class Main {
	public static void main(String[] args) {

		Example ex = new Example();
		ex.setEmpNo(123);
		ex.empName = "xyz";
		
		System.out.println(ex.getEmpNo());
		System.out.println(ex.getEmpName());
		
		Thread thread = new Thread();
	}
}
