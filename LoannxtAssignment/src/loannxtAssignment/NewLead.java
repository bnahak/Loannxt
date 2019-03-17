package loannxtAssignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewLead 
{
	

	public static void main(String[] args) throws Exception 
	{
		
		
		System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://128.199.244.155:5050/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Partner Login")).click();
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("nairmahesh23@gmail.com");
		//Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("password")).sendKeys("test");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='user-login']//div//div/form//div//div[3]//button")).click();
		
		
		TestHomeLoan(driver);
		
		//TestPersonalLoan(driver);
		
		//TestBusinessLoan(driver);
		
		//TestCreditCard(driver);
		
		//Logout
		driver.findElementByXPath("//*[@class='user-item usr-opt dropdown']").click();
		SelectDropDown2(driver, "Log Out");
		
		//Close
		driver.close();
		
		}
	
	
	public static void SelectDropDown(ChromeDriver driver, String dropdownText) throws InterruptedException 
	{
		
		List<WebElement> ddlist = driver.findElementsByXPath("//ul[contains(@class, 'dropdown-menu inner show')]//li//a");
		
		for(WebElement element:ddlist)
		{
			String ddText = element.getText();
			
			if (element.isDisplayed())
			{
				if (ddText.contentEquals(dropdownText))
				{
					element.click();
					break;
				}
			}
		}

	}
	

	public static void SelectDropDown2(ChromeDriver driver, String dropdownText) throws InterruptedException 
	{
		
		List<WebElement> ddlist = driver.findElementsByXPath("//*[contains(@class, 'profile-dropdown')]//li//a");
		
		for(WebElement element:ddlist)
		{
			String ddText = element.getText();
			
			if (element.isDisplayed())
			{
				if (ddText.contentEquals(dropdownText))
				{
					element.click();
					break;
				}
			}
		}

	}

	public static void SelectDate(ChromeDriver driver, String dateText) throws InterruptedException 
	{
	    String date_ent1[] = dateText.split("-");
	    String shipFDay = date_ent1[0];
	    String shipFMonth = date_ent1[1];
	    String shipFYear = date_ent1[2];
	    
	    String date_pres = driver.findElement(By.xpath("//th[@title='Select Month']")).getText();
	    
	    String dp[] = date_pres.split(" ");
	    
	    String year_pres = dp[1];
	    
	    if (year_pres.equals(shipFYear)) 
	    {
	        driver.findElement(By.xpath("//th[@title='Select Month']")).click();

	        driver.findElement(By.xpath("//span[contains(.,'" + shipFMonth + "')]")).click();
	        Thread.sleep(5000);

	    } 
	    else if (Integer.parseInt(year_pres) > Integer.parseInt(shipFYear)) 
	    {
	        driver.findElement(By.xpath("//th[@title='Select Month']")).click();

	        while (2 > 1) 
	        {
	            year_pres = driver.findElement(By.xpath("//th[@title='Select Year']")).getText();
	            if (year_pres.equalsIgnoreCase(shipFYear)) 
	            {

	                driver.findElement(By.xpath("//span[contains(.,'" + shipFMonth + "')]")).click();
	                Thread.sleep(5000);
	                break;
	            }
	            
	            driver.findElement(By.xpath("//span[@title='Previous Year']")).click();
	        }

	    } 
	    else 
	    {
	        driver.findElement(By.xpath("//th[@title='Select Month']")).click();
	        
	        while (2 > 1) 
	        {
	            year_pres = driver.findElement(By.xpath("//th[@title='Select Year']")).getText();
	            
	            if (year_pres.equalsIgnoreCase(shipFYear)) 
	            {

	                driver.findElement(By.xpath("//span[contains(.,'" + shipFMonth + "')]")).click();

	                Thread.sleep(5000);
	                break;
	            }
	            
	            driver.findElement(By.xpath("//span[@title='Next Year']")).click();
	        }
	    }
	    
	    String month = "";

	    switch (shipFMonth) 
	    {
		    case "Jan": {
		    	month = "01";
		        break;
		    }
	
		    case "Feb": {
		    	month = "02";
		        break;
		    }
		    case "Mar": {
		    	month = "03";
		        break;
		    }
		    case "Apr": {
		    	month = "04";
		        break;
		    }
		    case "May": {
		    	month = "05";
		        break;
		    }
		    case "Jun": {
		    	month = "06";
		        break;
		    }
		    case "Jul": {
		    	month = "07";
		        break;
		    }
		    case "Aug": {
		    	month = "08";
		        break;
		    }
		    case "Sep": {
		    	month = "09";
		        break;
		    }
		    case "Oct": {
		    	month = "10";
		        break;
		    }
		    case "Nov": {
		    	month = "11";
		        break;
		    }
		    case "Dec": {
		    	month = "12";
		        break;
		    }
		    default: {
		        System.out.println("Please enter the date in the standard format like DD-MMM-yyyy");
		     break;
		    }
	    }
	    
	    driver.findElement(By.xpath("//td[@data-day='" + month + "/" + shipFDay + "/" + shipFYear + "']")).click();
	}
	
			
	public static void TestHomeLoan(ChromeDriver driver) throws InterruptedException 
	{
	
		driver.findElement(By.xpath("//html//body//header//div[1]//div[2]//div[1]//div//button[1]")).click();
		
		//Select opportunity=new Select(driver.findElement(By.name("lead[opportunityType]")));
		//opportunity.selectByVisibleText("Home Loan");
		
		//Opportunity
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[4]").click();
		SelectDropDown(driver, "Home Loan");
		
		driver.findElement(By.id("newtext-lead-amount")).sendKeys("2000000");
		
		driver.findElement(By.id("lead-tenor")).sendKeys("1");

		//Repayment Mode
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[5]").click();
		SelectDropDown(driver, "PDC");
		
		driver.findElement(By.id("lead-fname")).sendKeys("Barsha");
		driver.findElement(By.id("lead-lname")).sendKeys("TestHomeLoan");
		WebElement radioBtn = driver.findElement(By.id("gen-f"));
		radioBtn.click();
		
		driver.findElement(By.name("user[basicDetails][dob]")).click();
		SelectDate(driver , "12-Feb-1995");
		
		driver.findElement(By.id("lead-address")).sendKeys("Mulund");
		
		//State
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[10]").click();
		SelectDropDown(driver, "Maharashtra");
		Thread.sleep(3000);

		//City
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[11]").click();
		SelectDropDown(driver, "Mumbai");
		
		driver.findElement(By.id("lead-pincode")).sendKeys("460081");
		
		//Moved to Current Residence
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[12]").click();
		SelectDropDown(driver, "Less then 1 Year");
		
		//Moved to Current City
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[13]").click();
		SelectDropDown(driver, "Less then 1 Year");

		driver.findElement(By.id("lead-email")).sendKeys("barsha.homeloan@gmail.com");
		driver.findElement(By.id("lead-mob")).sendKeys("9876543210");
		
		//New To Credit
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[14]").click();
		SelectDropDown(driver, "Yes");
		
		driver.findElement(By.id("lead-pan")).sendKeys("ABCDE1234F");

		//Identification Type 
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[15]").click();
		SelectDropDown(driver, "Passport");
		
		driver.findElement(By.id("lead-id-no")).sendKeys("P4567123");

		//Occupation Type
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[16]").click();
		SelectDropDown(driver, "Salaried");
		
		//Type Of Company
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[17]").click();
		SelectDropDown(driver, "Private Limited");
		
		//Company Sub Type
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[18]").click();
		SelectDropDown(driver, "MNC");
		
		driver.findElement(By.id("input-loan-industry-type")).sendKeys("service");
		driver.findElement(By.id("opp-company-name")).sendKeys("ABC Infotech");
		driver.findElement(By.id("lead-exp")).sendKeys("3");
		driver.findElement(By.id("lead-emp-year")).sendKeys("1");
		
		//Method Of Salary
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[19]").click();
		SelectDropDown(driver, "Bank Account Transfer");
		
		driver.findElement(By.id("net-income")).sendKeys("100000");
		driver.findElement(By.name("user[professionalDetails][salaryDetails][grossSalary]")).sendKeys("150000");

		//Account Type
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[22]").click();
		SelectDropDown(driver, "Salary");
		
		//Bank Name
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[23]").click();
		SelectDropDown(driver, "Axis Bank Ltd");
		
		//No Of Cheque bounce in last 3 months
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[24]").click();
		SelectDropDown(driver, "0");
		
		//No Of Cheque bounce in last 6 months
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[25]").click();
		SelectDropDown(driver, "0");
		
		driver.findElement(By.id("six-months-avg-balance")).sendKeys("500000");
		
		//Existing Loan
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[26]").click();
		SelectDropDown(driver, "No");
		
		//Source
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[31]").click();
		SelectDropDown(driver, "Others");
		
		//Save Button
		driver.findElementByXPath("(//*[@class='app-btn btn btn-primary'])[2]").click();
		
		//driver.findElementByXPath("(//*[contains(@class, 'nav-primary-item hint-right hint-rounded active')])").click();
		
		//Cancel Button
		//driver.findElementByXPath("(//*[@class='app-btn btn btn-outline-secondary'])[2]").click();
		
	}
	
	public static void TestPersonalLoan(ChromeDriver driver) throws InterruptedException 
	{
		
		driver.findElement(By.xpath("//html//body//header//div[1]//div[2]//div[1]//div//button[1]")).click();
		
		//Opportunity
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[4]").click();
		SelectDropDown(driver, "Personal Loan");
		
		
		driver.findElement(By.id("newtext-lead-amount")).sendKeys("200000");
		
		driver.findElement(By.id("lead-tenor")).sendKeys("2");
		
		//Repayment Mode
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[5]").click();
		SelectDropDown(driver, "ECS");
		
		
		driver.findElement(By.id("lead-fname")).sendKeys("Barsha");
		driver.findElement(By.id("lead-lname")).sendKeys("TestPersonalLoan");
		WebElement radioBtn = driver.findElement(By.id("gen-f"));
		radioBtn.click();
		driver.findElement(By.name("user[basicDetails][dob]")).click();
		SelectDate(driver, "14-Dec-1994");
		
		driver.findElement(By.id("lead-address")).sendKeys("BTM");
		
		//State
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[10]").click();
		SelectDropDown(driver, "Karnataka");
		Thread.sleep(4000);

		
		//City
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[11]").click();
		SelectDropDown(driver, "Bengaluru East");
		
		
		driver.findElement(By.id("lead-pincode")).sendKeys("560071");
		
		//Moved to Current Residence
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[12]").click();
		SelectDropDown(driver, "1 Year");
		
		
		//Moved to Current City
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[13]").click();
		SelectDropDown(driver, "1 Year");

		
		driver.findElement(By.id("lead-email")).sendKeys("barsha.personalloan@gmail.com");
		driver.findElement(By.id("lead-mob")).sendKeys("9876543210");
		
		//New To Credit
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[14]").click();
		SelectDropDown(driver, "Yes");
		
		
		driver.findElement(By.id("lead-pan")).sendKeys("ABCDE5678F");
		
		//Identification Type 
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[15]").click();
		SelectDropDown(driver, "Passport");
		
		
		driver.findElement(By.id("lead-id-no")).sendKeys("Q3217654");
		
		//Occupation Type
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[16]").click();
		SelectDropDown(driver, "Self Employed Professional");
		
		
		//Type Of Company
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[17]").click();
		SelectDropDown(driver, "Private Limited");
		
		
		//Company Sub Type
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[18]").click();
		SelectDropDown(driver, "MNC");
		
		
		driver.findElement(By.id("input-loan-industry-type")).sendKeys("Service");
		driver.findElement(By.id("lead-exp")).sendKeys("10");
		driver.findElement(By.id("net-income")).sendKeys("40000");
		driver.findElement(By.id("gross-income")).sendKeys("50000");
		
		//Account Type
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[22]").click();
		SelectDropDown(driver, "Savings");
		
		
		//Bank Name
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[23]").click();
		SelectDropDown(driver, "HDFC Bank Ltd");
		
		
		//No Of Cheque bounce in last 3 months
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[24]").click();
		SelectDropDown(driver, "0");
		
		
		//No Of Cheque bounce in last 6 months
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[25]").click();
		SelectDropDown(driver, "0");
		
		
		driver.findElement(By.id("six-months-avg-balance")).sendKeys("50000");
		
		//Existing Loan
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[26]").click();
		SelectDropDown(driver, "No");
		
		
		//Source
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[31]").click();
		SelectDropDown(driver, "Inbound Phone call");
		
		//Save Button
		driver.findElementByXPath("(//*[@class='app-btn btn btn-primary'])[2]").click();
		
		//Cancel Button
		//driver.findElementByXPath("(//*[@class='app-btn btn btn-outline-secondary'])[2]").click();
		

	}
	
	public static void TestBusinessLoan(ChromeDriver driver) throws InterruptedException 
	{	
		
		driver.findElement(By.xpath("//html//body//header//div[1]//div[2]//div[1]//div//button[1]")).click();
		
		//Opportunity
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[4]").click();
		SelectDropDown(driver, "Business Loan");
		
		
		driver.findElement(By.id("newtext-lead-amount")).sendKeys("5000000");
		driver.findElement(By.id("lead-tenor")).sendKeys("24");
		
		//Repayment Mode
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[5]").click();
		SelectDropDown(driver, "NACH");
		
		
		//Business Type
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[8]").click();
		SelectDropDown(driver, "Self Employed Business");
		
		
		//Constitution
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[9]").click();
		SelectDropDown(driver, "Partnership");
		
		
		driver.findElement(By.id("lead-fname")).sendKeys("Barsha");
		driver.findElement(By.id("lead-lname")).sendKeys("TestBusinessLoan");
		WebElement radioBtn = driver.findElement(By.id("gen-m"));
		radioBtn.click();
		
		driver.findElement(By.name("user[basicDetails][dob]")).click();
		SelectDate(driver, "24-Jun-1992");
		
		driver.findElement(By.id("lead-address")).sendKeys("Goutam Nagar");
		
		//State
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[10]").click();
		SelectDropDown(driver, "Odisha");
		Thread.sleep(3000);

		
		//City
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[11]").click();
		SelectDropDown(driver, "Berhampur");
		
		
		driver.findElement(By.id("lead-pincode")).sendKeys("760071");
		
		//Moved to Current Residence
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[12]").click();
		SelectDropDown(driver, "More than 5 Years");
		
		
		//Moved to Current City
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[13]").click();
		SelectDropDown(driver, "More than 5 Years");

		
		driver.findElement(By.id("lead-email")).sendKeys("barsha.businessloan@gmail.com");
		driver.findElement(By.id("lead-mob")).sendKeys("9876543210");
		
		//New To Credit
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[14]").click();
		SelectDropDown(driver, "Yes");
		
		
		driver.findElement(By.id("lead-pan")).sendKeys("EDCBA3698F");
		
		//Identification Type 
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[15]").click();
		SelectDropDown(driver, "Passport");
		
		
		driver.findElement(By.id("lead-id-no")).sendKeys("R3692584");
		driver.findElement(By.id("input-business-name")).sendKeys("Barsha Private Limited");
		driver.findElement(By.id("input-company-pan")).sendKeys("IJKLM1234N");
		driver.findElement(By.id("input-company-gst")).sendKeys("29ABCDE1334F2Z5");
		driver.findElement(By.name("user[businessDetails][dateOfIncorporation]")).click();
		SelectDate(driver, "28-Mar-2014");
		
		
		//Type Of Company
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[20]").click();
		SelectDropDown(driver, "Private Limited");
		
		
		//Company Sub Type
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[21]").click();
		SelectDropDown(driver, "MNC");
		
		
		driver.findElement(By.id("input-business-industry")).sendKeys("New Service");
		driver.findElement(By.name("user[businessDetails][businessTurnOver][0][amount]")).sendKeys("9000000");
		driver.findElement(By.name("user[businessDetails][businessTurnOver][1][amount]")).sendKeys("8000000");
		driver.findElement(By.name("user[businessDetails][businessTurnOver][2][amount]")).sendKeys("6000000");
		driver.findElement(By.name("user[businessDetails][businessProfit][0][amount]")).sendKeys("2000000");
		driver.findElement(By.name("user[businessDetails][businessProfit][1][amount]")).sendKeys("1000000");
		driver.findElement(By.name("user[businessDetails][businessProfit][2][amount]")).sendKeys("500000");
		driver.findElement(By.name("user[businessDetails][transactionsPerMonth]")).sendKeys("1000000");
		driver.findElement(By.name("user[businessDetails][sixMonthCreditAmount]")).sendKeys("200000");
		
		//Account Type
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[22]").click();
		SelectDropDown(driver, "Savings");
		
		
		//Bank Name
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[23]").click();
		SelectDropDown(driver, "Central Bank of India");
		
		//No Of Cheque bounce in last 3 months
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[24]").click();
		SelectDropDown(driver, "0");
		
		
		//No Of Cheque bounce in last 6 months
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[25]").click();
		SelectDropDown(driver, "0");
		
		
		driver.findElement(By.id("six-months-avg-balance")).sendKeys("1500000");
		
		//Existing Loan
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[26]").click();
		SelectDropDown(driver, "No");
		
		
		//Source
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[31]").click();
		SelectDropDown(driver, "Customer Referral");
		
		//Save Button
		driver.findElementByXPath("(//*[@class='app-btn btn btn-primary'])[2]").click();
		
		//Cancel Button
		//driver.findElementByXPath("(//*[@class='app-btn btn btn-outline-secondary'])[2]").click();
		
	}
	
	
	public static void TestCreditCard(ChromeDriver driver) throws InterruptedException 
	{	
		
		driver.findElement(By.xpath("//html//body//header//div[1]//div[2]//div[1]//div//button[1]")).click();
	
		//Opportunity
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[4]").click();
		SelectDropDown(driver, "Credit Card");
		
		
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[6]").click();
		SelectDropDown(driver, "Banking Partnership");
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[6]").click();
		
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[7]").click();
		SelectDropDown(driver, "Master Card");
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[7]").click();
		
		driver.findElement(By.id("lead-fname")).sendKeys("Barsha");
		driver.findElement(By.id("lead-lname")).sendKeys("TestCreditCard");
		WebElement radioBtn = driver.findElement(By.id("gen-f"));
		radioBtn.click();
		
		driver.findElement(By.name("user[basicDetails][dob]")).click();
		SelectDate(driver, "30-Sep-1992");	
		
		driver.findElement(By.id("lead-address")).sendKeys("Ram Nagar");
		
		//State
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[10]").click();
		SelectDropDown(driver, "Delhi");
		Thread.sleep(3000);

		
		//City
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[11]").click();
		SelectDropDown(driver, "Delhi");
		
		
		driver.findElement(By.id("lead-pincode")).sendKeys("860071");
		
		//Moved to Current Residence
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[12]").click();
		SelectDropDown(driver, "2 Years");
		
		
		//Moved to Current City
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[13]").click();
		SelectDropDown(driver, "2 Years");

		
		driver.findElement(By.id("lead-email")).sendKeys("barsha.creditcard@gmail.com");
		driver.findElement(By.id("lead-mob")).sendKeys("9876543210");
		
		//New To Credit
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[14]").click();
		SelectDropDown(driver, "Yes");
		
		
		driver.findElement(By.id("lead-pan")).sendKeys("IJKLM7890N");
		
		//Identification Type 
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[15]").click();
		SelectDropDown(driver, "Passport");
		
		
		driver.findElement(By.id("lead-id-no")).sendKeys("S2587896");
		
		//Occupation Type
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[16]").click();
		SelectDropDown(driver, "Self Employed Business");
		
		
		//Type Of Company
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[17]").click();
		SelectDropDown(driver, "Private Limited");
		
		
		//Company Sub Type
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[18]").click();
		SelectDropDown(driver, "MNC");
		
		
		driver.findElement(By.id("input-loan-industry-type")).sendKeys("service");
		driver.findElement(By.id("lead-exp")).sendKeys("10");
		driver.findElement(By.id("net-income")).sendKeys("50000");
		driver.findElement(By.id("gross-income")).sendKeys("70000");

		
		//Account Type
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[22]").click();
		SelectDropDown(driver, "Savings");
		
		
		//Bank Name
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[23]").click();
		SelectDropDown(driver, "Bank of India");
		
		
		//No Of Cheque bounce in last 3 months
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[24]").click();
		SelectDropDown(driver, "0");
		
		
		//No Of Cheque bounce in last 6 months
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[25]").click();
		SelectDropDown(driver, "0");
		
		
		driver.findElement(By.id("six-months-avg-balance")).sendKeys("250000");
		
		//Existing Loan
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[29]").click();
		SelectDropDown(driver, "No");
		
		
		//Source
		driver.findElementByXPath("(//*[contains(@class, 'dropdown bootstrap-select')])[31]").click();
		SelectDropDown(driver, "Customer Referral");
		
		//Save Button
		driver.findElementByXPath("(//*[@class='app-btn btn btn-primary'])[2]").click();
		
		//Cancel Button
		//driver.findElementByXPath("(//*[@class='app-btn btn btn-outline-secondary'])[2]").click();
		
	}
}


