package constants;

public class Constant {
	public static final String CONFIGFILE=System.getProperty("user.dir")+"\\src\\main\\resources\\config.property";
	public static final String TESTDATA = System.getProperty("user.dir")+ "\\src\\test\\resources\\TestData.xlsx";
	public static final String VALIDCREDENTIALERROR = "User is unable to login with valid credentials";
	public static final String INVALIDCREDENTIALERROR = "user is able to login with invalid credentials";
	public static final String LOGOUTERROR = "user is unable to logout";
	public static final String UNABLETOADDUSERERROR = "User is unable to create new user";
	public static final String SEARCHERROR ="searched user not available";
	public static final String UNABLETOUPDATECONTACTERROR ="User is unable to edit contact details";
	public static final String UNABLETOADDNEWSERROR = "User is unable to add new news";
	public static final String SEARCHNEWSERROR ="searched news not available";
	
}
