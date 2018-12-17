import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TwoTests {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "https://app.perkbox.com";
        String testEmail = "pooja@perkbox.co.uk";
        String foundEmail = "";
        Boolean buttonVisible;
        

        driver.get(baseUrl);
        
        //Test 1 - Check if continue button is visible
        Thread.sleep(1000);
        buttonVisible = driver.findElement(By.id("login__global-login__btn-submit")).isDisplayed();
        if(buttonVisible)
        	System.out.println("Test 1 Passed");
        else
        	System.out.println("Test 1 Failed");
        
        
        driver.get(baseUrl);
        
        //Test 2 - check email is populated after choosing role
        Thread.sleep(1000);
        driver.findElement(By.id("login__global-login__field-email")).sendKeys(testEmail);
        Thread.sleep(1000);
        driver.findElement(By.id("login__global-login__btn-submit")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("login__global-login__tenant-select__themistrypenguin__tenant")).click();
        driver.findElement(By.id("login__global-login__tenant-select__btn-submit")).click();
        Thread.sleep(3000);
        foundEmail = driver.findElement(By.cssSelector("input#login__default-login__field-email.form-control")).getAttribute("value");
        if(testEmail.equals(foundEmail))
        	System.out.println("Test 2 Passed");
        else
        	System.out.println("Test 2 Failed");
        
        driver.close();
        driver.quit();
    
	}
}
