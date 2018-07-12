package AdvanceTatocTest;


import java.sql.Connection;
import static AdvanceTatocTest.RetrieveLocators.element;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class TestingQueryGateThirdPage extends ReturnPageHeading{
	Connection connectingToDatabase;
	
	public void databaseConnection() {
		try {
			String databaseUrl = "jdbc:mysql://10.0.1.86/tatoc";
			String username = "tatocuser";
			String password = "tatoc01";
			Class.forName("com.mysql.jdbc.Driver");
			connectingToDatabase =  (Connection) DriverManager.getConnection(databaseUrl, username, password);
		}catch(Exception e) {
			System.out.println("Exception : "+e);
		}
	}

	void queryPerforming() {
		databaseConnection();
		try{
			String symbol=element("findIdForGettingTextEcho").getText();
			PreparedStatement queryToSelectidentity= connectingToDatabase.prepareStatement("select id from identity where symbol=?;");				
			queryToSelectidentity.setString(1,symbol);
			ResultSet rs= queryToSelectidentity.executeQuery();
			int id=0;
			while(rs.next()){
				id = Integer.parseInt(rs.getString("id"));
			}
			queryToSelectidentity= connectingToDatabase.prepareStatement("select name, passkey from credentials where id=?;");
			queryToSelectidentity.setInt(1, id);
	
			rs= queryToSelectidentity.executeQuery();
			String name="";
			String passkey="";
			while(rs.next()) {
				name=rs.getString("name");
				passkey=rs.getString("passkey");
			}
			element("findIdForSettingName").sendKeys(name);
			element("findIdForSettingPassword").sendKeys(passkey);
			element("findIdForSubmitting").click();
			connectingToDatabase.close();
		}catch(Exception e) {
			System.out.println("Exception : "+e);
		}
	}
}
