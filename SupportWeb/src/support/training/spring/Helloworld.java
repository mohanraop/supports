package support.training.spring;

public class Helloworld {
 public Greeting greets;
 public String name;

public Greeting getGreets() {
	return greets;
}

public void setGreets(Greeting greets) {
	this.greets = greets;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
public void hello()
{
 System.out.println( "HI " +getName()+ "\n" +getGreets().getMessage());
}
}
