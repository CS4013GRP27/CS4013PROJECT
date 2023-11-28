import java.util.HashMap;
/*To do
 * instance have  to be made in main method
 * Make a default account for each id student and faculty
 * link these accounts with grades qca etc.
 * design the gui
 * set default password as Password or their birthday etc.
 * 
 */

public class LoginDetails {
	// will have to tostring for faculty id and student id
	HashMap<String,String> details = new HashMap<String,String>();
	
	LoginDetails(){
		details.put("Student Id", "Password0");// going to have to get added like this
		details.put("Faculty ID" , "Password");
	}
	
	public HashMap getDetails() {
		return details;
	}
}
