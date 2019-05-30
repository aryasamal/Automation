package com.seleniumtests.webpage;


import static com.seleniumtests.core.Locator.*;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import java.util.Map;

import com.seleniumtests.dataobject.*;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gdata.util.parser.Action;
import com.seleniumtests.core.SeleniumTestsContextManager;


import com.seleniumtests.webelements.ButtonElement;

import com.seleniumtests.webelements.HtmlElement;
import com.seleniumtests.webelements.PageObject;
import com.seleniumtests.webelements.SelectList;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.util.Calendar;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import java.io.File;

import java.util.Date;
import com.seleniumtests.webelements.TextFieldElement;

public class CSPage extends PageObject {
	
	public static String url = null;
	public static String URL = null;
	
	
	public static Map<Object,Map<Object,Object>> mastermap = new HashMap<Object, Map<Object,Object>>();


	public CSPage(final boolean openPageURL) throws Exception {
	    super(htmlpage, openPageURL ? url = SeleniumTestsContextManager.getThreadContext().getAppURL() : null);
	}
	
	
    private static final ButtonElement Try_for_free=new ButtonElement("click the signup button",locateByXPath("//button[contains(text(),'Try for free')]"));
    
    private static final TextFieldElement firstname=new TextFieldElement("enter the first name",locateByXPath("//input[@id='id_first_name']"));
    private static final TextFieldElement lastname=new TextFieldElement("enter the last name",locateByXPath("//input[@id='id_last_name']"));
    private static final TextFieldElement workemail=new TextFieldElement("enter the email id",locateByXPath("//input[@id='id_email']"));
    private static final TextFieldElement password=new TextFieldElement("enter the password",locateByXPath("//input[@id='id_password']"));
    private static final TextFieldElement companyname=new TextFieldElement("enter the company name",locateByXPath("//input[@id='id_company_name']"));
    private static final ButtonElement loginbutton=new ButtonElement("click on the loginbutton",locateByXPath("//button[@class='ui primary large fluid button']"));
    private static final ButtonElement complete_profile= new ButtonElement("click on the complete profile button",locateByXPath("//a[contains(text(),'Complete Profile')]"));
    private static final TextFieldElement Company_Website_URL=new TextFieldElement("enter the webiste url name",locateByXPath(" //div[@class='eleven wide column']//div[2]//input[1]"));
    private static final TextFieldElement About_the_Company=new TextFieldElement("enter the description",locateByXPath("//div[@class='field']//textarea"));
    private static final TextFieldElement facebook_url=new TextFieldElement("enter the facebook login",locateByXPath("//div[contains(text(),'facebook.com/')]/..//input[1]"));
    private static final TextFieldElement twitter_url=new TextFieldElement("enter the twitter login",locateByXPath("//div[contains(text(),'twitter.com/')]/..//input[1]"));
    private static final TextFieldElement linkedin_url=new TextFieldElement("enter thelinkedin_url",locateByXPath("//div[contains(text(),'linkedin.com/')]/..//input[1]"));
    private static final ButtonElement browser=new ButtonElement("enter the browser button",locateByXPath(" //span[@class='filepond--label-action']"));
    private static final ButtonElement save_changes=new ButtonElement("click on the button",locateByXPath(" //button[@class='ui green button'] "));
    private static final ButtonElement logout=new ButtonElement("click on the logout button",locateByXPath("//a[contains(text(),'Log out')]"));
    
    
  
   
    

    
    
    //private static final ButtonElement contentname = new ButtonElement("click the button", locateByXPath("//select[@id='content_name']"));

    //private static final ButtonElement content_button_breadcrumb = new ButtonElement("cilck",locateByXPath("//ol[@class='breadcrumb font-10 hidden-xs']//a[contains(text(),'Content Library')]"));
    private static final ButtonElement categorydropdown = new ButtonElement("click the button", locateByXPath("//select[@id='content_category_value']/option[1]"));

	String subscriptiondropdown="//div[@class='col-sm-9']//select[@id='customFields'][@name='user_type1']";
	//String contentname="//select[@id='content_name']";
	
	public CSPage Textbox(TextFieldElement element,final String Text) throws Exception {
		waitForSeconds(2);
		element.clearAndType(Text);
	    return this;
	}
	
	public CSPage Click(ButtonElement element) throws Exception {
		   
		   element.waitForPresent(10);
		   element.click();
	        return this;
	    }
	
	public CSPage Wait(int value) throws Exception {
		 waitForSeconds(value);
		 	
			return this;
		     
	 }
	 public CSPage Scroll(ButtonElement element) throws Exception {
		 waitForSeconds(2);
		    element.scroll();
	     return this;
	 }
	
	 public CSPage SelectByListIndex(final int index,String xpath) throws Exception {
		 waitForSeconds(5);
			SelectList s = new SelectList("", By.xpath(xpath));
			s.selectByIndex(index);
				return this;
			     
			 }
	
public CSPage MouseOver(HtmlElement element) throws Exception {
		
		element.waitForPresent(10);
		element.mouseOver();
	    return this;
	}
public CSPage SimulateClick(ButtonElement element) throws Exception {
	 waitForSeconds(2);
	    element.simulateClick();
    return this;
}

public CSPage AssertEquals(final String actualText,final String expectedText) throws Exception {
	 assertEquals(actualText,expectedText,"Actual text and Expected Text Not Equal");
   return this;
  }


public CSPage PrintServerStatus()
{
String name = dedicatedserver.getText();
System.out.println("text is"+name+"end");
assertEquals(name, "Upgrade to Dedicated\nServer for performance and reliability");

return this;
}

//payment gateway integration

public CSPage configure_gateway(String gatewayname,  CSDATA  CSDATA ) throws Exception {
	 waitForSeconds(2);
	 if(gatewayname.trim().equalsIgnoreCase("stripe")&&Stripe.isDisplayed())
		{
			
			Click(Stripe).Wait(3).Textbox(SecretKey, "sk_test_J7QceZ04oG973QoKALgaP0mV").Textbox(PublicKey, "pk_test_wrssVHZpxA03Ur0ywBCWnqDI").Click(IntegratePaymentGatewayButton)
			.Wait(5).Textbox(NameOnCardTextbox, CSDATA.getName()).Textbox(CardNumTextbox, CSDATA.getCardnumber());
			SelectByText(CSDATA.getExpmonth(),"//select[@id='exp_month']").SelectByText(CSDATA.getExpyear(), "//select[@id='exp_year']")
			.Textbox(SecurityCodeTextbox, CSDATA.getSecuritycode()).SimulateClick(CompleteIntegration);waitForElementPresent(VerifyIcon);AssertEquals(VerifyIcon.getAttribute("class"), "icon-check green");
				
		}
	 
   return this;

}

public CSPage Add_vodsinglepart_content(final  CSDATA  CSDATA) throws Exception {
	
	SimulateClick(Addcontent).Wait(3).SelectByText("VOD Single Part", "//select[@id='parent_content_type']").Wait(3).Textbox(Content_Names, "newsinglepart").Click(categorydropdown)
	.Wait(3).Click(save_continue).Wait(3).MouseOver(ManageContent).Wait(3).Click(Content_Library_Button).Wait(3).SimulateClick(upload_video).Wait(3).Click(Browse_file1).Wait(3)
	.clickEnter1().Wait(3).Click(upload_button);


	return this;
}

public CSPage Add_vodmultipart_content(final  CSDATA  CSDATA) throws Exception {
	SimulateClick(Addcontent).Wait(3).SelectByText("VOD Multi Part Parent", "//select[@id='parent_content_type']").Wait(3).Textbox(itemname, "parentcontent").Click(categorydropdown)
	.Wait(3).Click(save_continue).Wait(5).MouseOver(ManageContent). Click(Content_Library_Button).Wait(3).SimulateClick(Addcontent).Wait(3).
	SelectByText("VOD Multi Part Child", "//select[@id='parent_content_type']").Wait(3).SelectByText("parentcontent", "//select[@id='content_name']").Wait(3).Textbox(title1, "childcontent")
	.SelectByText("2", "//select[@id='series_number']").Wait(3).Textbox(Episodenumber, "2").Wait(9).Click(save2).Wait(9).SimulateClick(upload_video).Wait(3).Click(Browse_file1)
	.Wait(3).clickEnter1().Wait(3).Click(upload_button).Wait(10);
	//.Click(Content_Button)

	
	return this;
	
}

public CSPage Add_aod_content(final  CSDATA  CSDATA) throws Exception {
	SimulateClick(Addcontent).Wait(3).SelectByText("AOD Single Part","//select[@id='parent_content_type']").Wait(3).Textbox(Content_Names,"AOD Content").Click(categorydropdown)
	.Wait(3).Click(save_continue).Wait(3).MouseOver(ManageContent).Wait(3).Click(Content_Library_Button).Wait(3).Click(filter).SelectByText("Audio","//select[@id='contenttype']").Wait(3).
	Click(upload_audio).Wait(3).Click(Browse_file1).Wait(5).clickEnter2().Wait(3).Click(uploadbutton_audio).Wait(10);
	
	
	return this;
}

public CSPage Add_livestreaming_content(final  CSDATA  CSDATA) throws Exception {
	SimulateClick(Addcontent).Wait(3).SelectByText("Video Live Streaming","//select[@id='parent_content_type']").Wait(3).Textbox(itemname,"livestreaming Content").Wait(3).Textbox(Feed,CSDATA.Feed).Click(categorydropdown)
	.Wait(3).Click(save_continue);
	
	return this;
}


public CSPage Activate_subscription_PPV_Coupon(final CSDATA CSDATA) throws Exception{
	MouseOver(Monetization)
	.Wait(3).Click(setting).Wait(3).Click(subscription_checkbox).Wait(3).Click(ppv_plan).Wait(3).Click(coupon).Wait(3).Click(updatebutton1).Wait(3).MouseOver(Monetization).Click(subscription).Wait(3);
	
	
	return this;
}

public CSPage subscription_plan(final CSDATA CSDATA) throws Exception{
	Click(Add).Wait(3).Textbox(PlanName,"Gold").Wait(3).Textbox(Short_Descriptions,"plan description").Wait(3).Textbox(Subscription_Fee, "150").Wait(3).Click(submitt_button);
	
	
	return this;
}

public CSPage Activate_ppvplan(final CSDATA CSDATA)throws Exception{
	//MouseOver(Monetization).Wait(3).Click(setting).Wait(3).Click(ppv_plan).Wait(3).Click(updatebutton1).Wait(5).
	MouseOver(Monetization).MouseOver(pay_per_view1).Click(ppv).Wait(3).Click(Addcategory_link)
	.Wait(3).Textbox(title_text,"ppv plan").Wait(3).Textbox(description,"test description").Wait(3).Textbox(Non_subscribers,"150").Wait(3).Textbox(subscribers, "200").Wait(3).Click(Add1).Wait(3);
	 
	return this;
}

public CSPage Activate_coupon(final CSDATA CSDATA)throws Exception{
	
	MouseOver(Monetization);
	
	if(coupon_tab.isSelected())
	 {
		 Click(coupon_tab).Wait(3);
	 }
	 else
	Click(setting).Wait(3).Click(coupon).Click(updatebutton1).Wait(5).MouseOver(Monetization).Click(coupon_tab).Wait(5);
	
	return this;
}

public CSPage video_page(final CSDATA CSDATA)throws Exception{
	MouseOver(analyticstab).Wait(3).Click(videotab);
	return this;
}


//public CSPage printpagesource() throws Exception {
	
 	//System.out.println(dedicatedserver.getText().trim().replaceAll("[\\r\\n]", ""));
	//System.out.println(dedicatedserver.getText());
	//return this;


public CSPage randomData(final  CSDATA  CSDATA) throws Exception {
 	
 	
	  
    CSDATA.setEmail(RandomEmailID.randomEmail());
    CSDATA.setName(RandomName.name());
    CSDATA.setPassword(RandomPassword.password(10));
    CSDATA.setMobilenumber(RandomMobileNo.randomMobileNo());
    CSDATA.setAddress(RandomAddress.address());
    CSDATA.setZip(RandomZip.zip());
   
	
	return this;
  }


public CSPage SelectByText(final String Text, String xpath) throws Exception {

SelectList s = new SelectList(Text, By.xpath(xpath));
s.selectByText(Text);
return this;
}

public CSPage pageScrollDown() throws Exception
{
JavascriptExecutor js = (JavascriptExecutor) driver; 
js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//js.executeScript("window.scrollBy(0,1000)");

return this;
}

public CSPage Delete_r() throws Exception {
	int iCount = 0;
	
	iCount = driver.findElements(By.xpath("//div[@class='col-sm-6']//em[@class='icon-trash']")).size();
	
	System.out.println(iCount);

	 if(iCount<=2)
	 {
		Click(Addcontentcategory);
		
		
		 
	 }
	 else
	 {
		 MouseOver(ManageContent);
		 Click(ManageMetadata);
	 }
	
	return this;

   }

public CSPage clickEnter() throws Exception {
	File file = new File("C:\\Users\\muvi\\Desktop\\324310.jpg");

    ClipboardOwner owner = null;

    Robot robot = new Robot();
    StringSelection str_path = new StringSelection(file.getAbsolutePath());
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str_path, owner);

    robot.setAutoDelay(1000);
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_K);

    robot.setAutoDelay(1000);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyPress(KeyEvent.VK_ENTER);
    Thread.sleep(3000);
      return this;
}

public CSPage clickEnter1() throws Exception {
	Wait(2);
	File file = new File("C:\\Users\\muvi\\Documents\\small.mp4");

    ClipboardOwner owner = null;

    Robot robot = new Robot();
    StringSelection str_path = new StringSelection(file.getAbsolutePath());
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str_path, owner);

    robot.setAutoDelay(1000);
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_K);

    robot.setAutoDelay(1000);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyPress(KeyEvent.VK_ENTER);
    Thread.sleep(3000);
      return this;
}

public CSPage clickEnter2() throws Exception {
	Wait(2);
	File file = new File("C:\\Users\\muvi\\Documents\\Aashiq.mp3");

    ClipboardOwner owner = null;

    Robot robot = new Robot();
    StringSelection str_path = new StringSelection(file.getAbsolutePath());
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str_path, owner);

    robot.setAutoDelay(1000);
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_K);

    robot.setAutoDelay(1000);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyPress(KeyEvent.VK_ENTER);
    Thread.sleep(3000);
      return this;
}


public CSPage Company_Profile()throws Exception {
	
    Textbox(Company_Website_URL,"https://www.muvi.com/").Click(browser).clickEnter().
    Wait(5).Textbox(About_the_Company,"test description").Textbox(facebook_url,"https://www.facebook.com/").Textbox(twitter_url,"https://twitter.com/login?lang=en")
    .Textbox(linkedin_url,"https://in.linkedin.com/");
	
	return this;
	
}


//19689-Cms>Content library >Add Content page:All the images are not showing which was available in the image gallery
//(upload image from gallary)

/*	public CSPage TC_uploadimage_01(final CSDATA CSDATA) throws Exception 
	
	{
		
		Click(LoginButton_HomePage)
		.Textbox(LoginUserNameTextbox, CSDATA.getLoginUserName())
		.Textbox(LoginPassWordTextbox, CSDATA.getPassword())
		.Click(Rememberme)
		.Click(LoginButton_LoginPage)
	    .Wait(10)
	    .MouseOver(ManageContent)
	    .Click(Content_Library_Button)
	    .Wait(10)
	    .SimulateClick(Addcontent)
	    .Wait(3)
		.SelectByText("VOD Single Part", "//select[@id='parent_content_type']").Wait(3)
		.Textbox(Content_Names, "ghfgf")
		.SelectByText("Movie",categorydropdown)
		.Wait(3)
		.SimulateClick(Browsebutton)
		.Wait(3)
		.Click(choose_from_gallary_button)
		.Wait(5)
		.MouseOver(image)
		.Click(image1)
		.Wait(10)
		.Click(Next)
		.Wait(10)
		.Click(save_continue)
		//.AssertEquals(successfulmessage.getText().substring(4),"content was added successfully")
		.Wait(10);
		
		return   new CSPage(false);
		 
	}*/
	

//20148:Unable to edit the date field for subscribed user
	
/*	public CSPage TC_uploadimage_01(final CSDATA CSDATA) throws Exception 
	{
		
		Click(LoginButton_HomePage)
		.Textbox(LoginUserNameTextbox, CSDATA.getLoginUserName())
		.Textbox(LoginPassWordTextbox, CSDATA.getPassword())
		.Click(Rememberme)
		.Click(LoginButton_LoginPage)
	    .Wait(10)
		.MouseOver(support_icon)
		.Click(enduser_support)
		.Click(editprofile).Wait(4)
		.SelectByText("Subscription",subscriptiondropdown)
		.Wait(5)
		.Textbox(calender_date, "01/09/2019")
		.Wait(10)
		.SimulateClick(submit)
		.Wait(10);
		
		return   new CSPage(false);
		

	}*/

//21677- Account Menu Changes don't reflect on website immediately
	
/*public CSPage TC_menu_01(final CSDATA CSDATA) throws Exception 
	{
		
	     Click(LoginButton_HomePage)
		.Textbox(LoginUserNameTextbox, CSDATA.getLoginUserName())
		.Textbox(LoginPassWordTextbox, CSDATA.getPassword())
		.Click(Rememberme)
		.Click(LoginButton_LoginPage)
	    .Wait(10)
	    .MouseOver(ManageContent)
	    .Wait(5)
	    .Click(ManageMetadata)
	    .Wait(5)
	    .Delete_r()
	    .Click(Addcontentcategory)
	    .Wait(5)
	    .Textbox(categoryname, CSDATA.getcategoryname())
	    .Wait(5)
	    .Click(Uploadimage)
	    .Wait(2)
	    .Click(UploadFile)
	    .Wait(2)
	    .clickEnter()
	    .Wait(5)
	    .Click(Next_button)
	    .Wait(5)
	    .Click(submitt)
	    .Wait(5);     
	  
	     return   new CSPage(false);
}*/


//Customer should be able to add Payment Gateway to his store.(Stripe)

/*public CSPage TC_menu_01(final CSDATA CSDATA) throws Exception 
{
	
	return Click(LoginButton_HomePage)
     .Textbox(LoginUserNameTextbox, CSDATA.getLoginUserName())
	 .Textbox(LoginPassWordTextbox, CSDATA.getPassword())
	 .Click(Rememberme)
	 .Click(LoginButton_LoginPage)
	 .Wait(10)
    .Click(home1)
	 .Scroll(hosting)
	 .PrintServerStatus()
	.Wait(10)	
	//.AssertEquals(dedicatedserver.getText().trim().replaceAll("[\\r\\n]", " "),"Upgrade to Dedicated Server for performance and reliability")
	// .AssertEquals(dedicatedserver.getText(),"Upgrade to DedicatedServer for performance and reliability")
	.MouseOver( Monetization)
	.Wait(10)
	.Click(payment_gateway)
	.configure_gateway("stripe", CSDATA)
	.MouseOver(ManageContent)
    .Click(Content_Library_Button)
    .Wait(10)
    .Add_vodsinglepart_content(CSDATA)
    .Wait(10)
	//.Click(Content_Button)
    .Add_vodmultipart_content(CSDATA)
    .Wait(10)
    .Add_aod_content(CSDATA)
    .Wait(10)
    .Add_livestreaming_content(CSDATA)
    .Wait(10)
	.MouseOver(support1)
	.Wait(5)
	//.Click(ticket)
	.Wait(3)
	.pageScrollDown()
	.Wait(3)
	.Activate_subscription_PPV_Coupon(CSDATA)
    .Wait(3)
    .subscription_plan(CSDATA)
    .Wait(3)
    .Activate_ppvplan(CSDATA)
	.video_page(CSDATA);
    //.Activate_coupon(CSDATA);*/


//for signup the webiste	
public CSPage TC_menu_01(final CSDATA CSDATA) throws Exception 

{
	
     Click(Try_for_free)
     .Wait(2)
     .Textbox(firstname, "newtest")
     .Textbox(lastname, "test")
     .Textbox(workemail, "sdsada@getnadadss@yopmail.com")
     .Textbox(password,"test123")
     .Textbox(companyname,"muvi")
     .SelectByText("Agency","//select[@id='id_team_type']")
     .Wait(5)
     .Click(loginbutton)
     .Wait(5)
     .Click(complete_profile)
     .Company_Profile()
	 .Wait(5)
	 .Click(save_changes)
	 .Click(logout);
     
     
     

     
     
     
     
     
     
	return  new CSPage(false);
	
	
}


//a[contains(text(),'Complete Profile')]

//after login the website


   
    
   
    
   
    
    
	
	
	
	
    
   /* .SimulateClick(Addcontent)
    .Wait(3)
	.SelectByText("VOD Single Part", "//select[@id='parent_content_type']").Wait(3)
	.Textbox(Content_Names, "newsinglepart")
	.Click(categorydropdown)
	.Wait(3)
	.Click(save_continue)
	.Wait(3)
	.MouseOver(ManageContent)
	.Wait(3)
	.Click(Content_Library_Button)
	.Wait(3)
	.SimulateClick(upload_video)
	.Wait(3)
	.Click(Browse_file1)
	.Wait(3)
	.clickEnter1()
	.Wait(3)
	.Click(upload_button)*/
	//.AssertEquals(successfulmessage.getText().substring(4), "content was added successfully")
   /* .SimulateClick(Addcontent)
    .Wait(3)
	.SelectByText("VOD Multi Part Parent", "//select[@id='parent_content_type']").Wait(3)
	.Textbox(itemname, "parentcontent")
	.Click(categorydropdown)
	.Wait(3)
	.Click(save_continue)
	//.Click(Content_Button)
	.Wait(5)
	.MouseOver(ManageContent)
    .Click(Content_Library_Button)
	.Wait(3)
	.SimulateClick(Addcontent)
	.Wait(3)
	.SelectByText("VOD Multi Part Child", "//select[@id='parent_content_type']").Wait(3)
	.SelectByText("parentcontent", "//select[@id='content_name']")
	.Wait(3)
	.Textbox(title1, "childcontent")
	.SelectByText("2", "//select[@id='series_number']").Wait(3)
	.Textbox(Episodenumber, "2")
	.Wait(9)
	.Click(save2)
	.Wait(9)
	.SimulateClick(upload_video)
	.Wait(3)
	.Click(Browse_file1)
	.Wait(3)
	.clickEnter1()
	.Wait(3)
	.Click(upload_button)
	.Wait(10)*/
	
	
} 

  








