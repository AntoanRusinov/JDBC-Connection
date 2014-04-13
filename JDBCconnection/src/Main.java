public class Main {

	public static void main(String[] args) {

		DBconnect connect = new DBconnect();
		connect.viewPerson();
		System.out.println("\n");
		connect.viewEmployees();
	}

}
