import org.openqa.selenium.firefox.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.util.concurrent.*;

public class AutoClickLike{
	public static void main(String[] args) throws InterruptedException{
		WebDriver dr = new FirefoxDriver();
		try{
			dr.get("http://www.yeeyi.com");
		}catch(Exception e){
			System.out.println("Unable to load website");
		}
		dr.manage().window().maximize();
		dr.findElement(By.xpath("//input[@name='username']")).sendKeys(new String[]{"username"});
		dr.findElement(By.xpath("//input[@name='password']")).sendKeys(new String[]{"password"});
		dr.findElement(By.xpath("//input[@type='image']")).click();
		try{
			dr.get("http://www.yeeyi.com/bbs/forum_topic_page");
		}catch(Exception e){
			System.out.println("Unable to load website");
		}
		while(true){
			try{
				//Press Like the topic button
				dr.findElement(By.xpath("//a[@title='提升帖子']")).click();
			}catch(NoSuchElementException e){
				dr.get("http://www.yeeyi.com/bbs/forum_topic_page");
				continue;
			}
			try{
				//Close the popped confirm window
				WebDriverWait wait = new WebDriverWait(dr,10);
				WebElement element = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='关闭' and @class='flbc']")));
				element.click();
			}catch(NoSuchElementException e){
				dr.get("http://www.yeeyi.com/bbs/forum_topic_page");
				continue;
			}
			//Wait for 15 min
			TimeUnit.SECONDS.sleep(900);		
		}
		//Keep working, non-stopping
		//dr.close();
	}
}


