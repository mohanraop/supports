package support.training.spring;

public class Studentset {
	public String name = null;
	private Studentcon studentcon;

	public Studentcon getStudentcon() {
		return studentcon;
	}

	public void setStudentcon(Studentcon studentcon) {
		this.studentcon = studentcon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
