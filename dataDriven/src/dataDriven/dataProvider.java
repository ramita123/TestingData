package dataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dataProvider {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","F:\\Selenium\\dataDriven\\src\\dataDriven\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String sheetPath=System.getProperty("user.dir")+"\\src\\dataDriven\\testData1.xlsx";
		Xls_Reader xlr=new Xls_Reader(sheetPath);
		int rcount=xlr.getRowCount("Sheet1");
		System.out.println(rcount);
		for(int i=2;i<=rcount;i++)
		{
			String vTc_id=xlr.getCellData("Sheet1", "TC_id",i);
			String vSummary=xlr.getCellData("Sheet1", "Tc_summary",i);
			String vPara1=xlr.getCellData("Sheet1","para1",i);
			String vPara2=xlr.getCellData("Sheet1","para2",i);
			
			switch(vTc_id)
			{
			case "tc_001":
				String actualUrl=driver.getCurrentUrl();
				System.out.println(actualUrl);
				if(vPara1.equals(actualUrl))
				{
					System.out.println("Pass");
					xlr.setCellData("Sheet1","status",i,"Pass");
				}
				else
				{
					System.out.println("fail");
					xlr.setCellData("Sheet1","status",i,"Fail");
				}
				break;
			case "tc_002":
				String actualTitle=driver.getTitle();
				System.out.println(actualTitle);
				if(vPara1.equals(actualTitle))
				{
					System.out.println("Pass");
					xlr.setCellData("Sheet1","status",i,"Pass");
				}
				else
				{
					System.out.println("fail");
					xlr.setCellData("Sheet1","status",i,"Fail");
				}
				break;
				
			case "tc_003":
				driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(vPara1);
				driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(vPara2);
				driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
				if ((driver.findElement(By.xpath("//input[@id='btnLogin']")).isDisplayed()) == true) {
					System.out.println("Pass");
					xlr.setCellData("Sheet1", "status", i, "Pass");
				}
				 else {
					System.out.println("Fail");
					xlr.setCellData("Sheet1", "status", i, "Fail");
				}
				break;
			case "tc_004":
				driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(vPara1);
				driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(vPara2);
				driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
				Thread.sleep(2000);
				if((driver.findElement(By.xpath("//input[@type='submit']")).isDisplayed())==false)
				{
					System.out.println("pass");
				}
				else
				{
					System.out.println("fail");
				}

					}
				}
	}
}
	


