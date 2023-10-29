package genericUtility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.mysql.cj.jdbc.Driver;

import pomRepository.HomePage;
import pomRepository.LoginPage;
/**
 * Java doc
 * This class contains all the preconditions and post conditions
 * @author Akash Deb
 *
 */
public class BaseClass {
	
	public WebDriver driver;
	//Creating the objects of all generic classes
	public FileUtility fUtils = new FileUtility();
	public ExcelUtility eUtils = new ExcelUtility();
	public WebDriverUtility wUtils = new WebDriverUtility();
	public JavaUtility jUtils = new JavaUtility();
	public DataBaseUtility dUtils=new DataBaseUtility();
	public static WebDriver sDriver;
	public Connection connection;

	//Pre condition to connect to the data base
	@BeforeSuite(groups = {"smoke", "regression"})
	public void bsConfig() throws SQLException {
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		connection = DriverManager.getConnection(IPathConstant.DATABASE_URL, IPathConstant.DATABASE_USERNAME, IPathConstant.DATABASE_PASSWORD);

		System.out.println("The Data base connection has been established");
		
	}
	
	@BeforeClass(groups = {"smoke", "regression"})
	public void bcConfig() throws IOException {
		driver = new ChromeDriver();
		sDriver=driver;
		System.out.println("The  browser has been launched");
		wUtils.waitForPageToLoad(driver);
		wUtils.maximizeTheWindow(driver);
		driver.get("http://localhost:8888/");
		System.out.println("The user has navigated to "+"http://localhost:8888/");
		
	}
		
	@BeforeMethod(groups = {"smoke", "regression"})
	public void bmConfig() throws IOException {
		
		//String username = fUtils.fetchDataFromPropertyFile("username");
		//String password = fUtils.fetchDataFromPropertyFile("password");
		
		LoginPage login = new LoginPage(driver);
		login.loginAction("admin", "admin");
		System.out.println("The login was successfull");
		
	}
	
	@AfterMethod(groups = {"smoke", "regression"})
	public void amConfig() {
		HomePage home=new HomePage(driver);
		home.logoutAction();
		System.out.println("The user has logged out successfully");
	}
	
	@AfterClass(groups = {"smoke", "regression"})
	public void acConfig() throws IOException {
		
		driver.quit();
		System.out.println("The browser has been closed");
		
	}
	
	@AfterSuite(groups = {"smoke", "regression"})
	public void asConfig() throws SQLException {
		
		connection.close();
		System.out.println("Data Base has been closed");
	
		
	}
	
	

}
