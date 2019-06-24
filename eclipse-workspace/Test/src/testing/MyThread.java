package testing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyThread extends Thread { 
	
	String list0[]= {"�T��","�L�f","���c", "�˥_","�Y��","���r", "�x���t��", "�L��","���", "�Ÿq","�s��","�s��", "���s", "�綩��", "�j�بt��", "�Y��"};
	String HighWay0[] = {"��D 1 ��","��D 1 ��","��D 1 ��","��D 1 ��","��D 1 ��","��D 1 ��","��D 1 ��","�ֳt���� 76 ��","��D 1 ��", "��D 1 ��","��D 1 ��","��D 8 ��","��D 1 ��","��D 1 ��", "��D 1 ��","��D 5 ��"  };
	
	//��
	String list1[]= {"��s", "�L�f", "���c", "�˥_", "���s", "�Y��","�T�q", "�j��","�j��", "�j���G", "�L��","�_��", "���L�t��","�Ÿq","�s��", "���Y", "���q","�P�_�t��", "�����t��", "�U��", "�W�L�汱", "ù�F"};
	String HighWay1[] = {"��D 1 ��","��D 1 ��","��D 1 ��","��D 1 ��","��D 3 ��","��D 1 ��","��D 1 ��", "��D 3 ��", "��D 1 ��","�ֳt���� 74 ��" , "�ֳt���� 76 ��", "��D 1 ��","��D 1 ��","��D 1 ��","��D 1 ��", "�ֳt���� 84 ��", "��D 3 ��", "��D 3 ��", "��D 1 ��", "�ֳt���� 88 ��", "��D 5 ��","��D 5 ��"};


	  public MyThread (String s) { 
	    super(s); 
	  }

	  public void run() { 
		  
		  System.out.println("Run: "+ getName()); 
		  if(getName().contains("vertical")) {
			  System.out.println("1"); 
			  while(true){
					
					for(int i =0; i<list0.length; i++) {
						String file_name = "D:\\1968Img\\" + "Img1_" + i + ".png";
						try{
							
							System.setProperty("webdriver.chrome.driver","C:\\Users\\voip\\eclipse-workspace\\Test\\tools\\chromedriver.exe");
							WebDriver wd =new ChromeDriver();
							wd.get("https://1968.freeway.gov.tw/");
							
							WebDriverWait wait = new WebDriverWait(wd, 10);
							
							WebElement btn2 = wd.findElement(By.cssSelector("[class='button_ctrl sw_toggle_gis id_sw_toggle_open']"));
							btn2.click();
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("freeway")));
							
							WebElement starttime = wd.findElement(By.id("freeway"));
							Select select=new Select(starttime);
							select.selectByVisibleText(HighWay0[i]);
							
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("from_location")));

							WebDriverWait wait2 = new WebDriverWait(wd, 10);
							wait2.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>(){
						        public Boolean apply(WebDriver driver)  
						        {
						            Select select = new Select(driver.findElement(By.id("from_location")));
						            return select.getOptions().size()>1;
						        }
						    });
							
							WebElement loc = wd.findElement(By.id("from_location"));
							Select select2=new Select(loc);
							select2.selectByVisibleText(list0[i]);
							
							WebElement btn = wd.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[3]/div[2]/div/div[1]/div[2]/button"));
							btn.click();
							
							//for 1-km accuracy 
							WebElement btn_1km = wd.findElement(By.cssSelector("[class='gis_info info_1km _event_click_gisinfo']"));
							btn_1km.click();
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idModalGisInfo1kmAsk\"]/div/div")));
							WebElement btn_check = wd.findElement(By.xpath("//*[@id=\"idModalGisInfo1kmAsk\"]/div/div/div/a[2]"));
							btn_check.click();
							TimeUnit.MILLISECONDS.sleep(3000);
							//for 1-km accuracy
							
							//resize the map partition
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/div[4]/div/div[2]")));
							WebElement svgObj = wd.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[4]/div/div[2]"));
							Actions actionBuilder = new Actions(wd);
							actionBuilder.click(svgObj).build().perform();
							TimeUnit.MILLISECONDS.sleep(2000);
				
							TakesScreenshot ts=(TakesScreenshot)wd;
							
						    File source=ts.getScreenshotAs(OutputType.FILE);    
						    FileHandler.copy(source,new File("D:\\temp1.png"));
						    wd.quit();
						    
						}catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						
						int x = 150;
					    int y = 100;
					    int w = 809;
					    int h = 852;
					    
					    try{
					    	
					    	BufferedImage image = ImageIO.read(new File("D:\\temp1.png"));
					        BufferedImage out = image.getSubimage(x, y, w-2*x, h-2*y);
					        ImageIO.write(out, "png", new File(file_name));
					        System.out.println("crop the image done");
					        
					    }catch (Exception e) {
							// TODO: handle exception
						}
					}
					System.out.println("batch image done");
				}
		  }else {
			  System.out.println("2"); 
			  
			  while(true){
					
					for(int i = 0; i<list1.length; i++) {
						String file_name = "D:\\1968Img\\" + "Img0_" + i + ".png";
						try{
							
							System.setProperty("webdriver.chrome.driver","C:\\Users\\voip\\eclipse-workspace\\Test\\tools\\chromedriver.exe");
							WebDriver wd =new ChromeDriver();
							wd.get("https://1968.freeway.gov.tw/");
							
							WebDriverWait wait = new WebDriverWait(wd, 10);
							
							WebElement btn2 = wd.findElement(By.cssSelector("[class='button_ctrl sw_toggle_gis id_sw_toggle_open']"));
							btn2.click();
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("freeway")));
							
							WebElement starttime = wd.findElement(By.id("freeway"));
							Select select=new Select(starttime);
							select.selectByVisibleText(HighWay1[i]);
							
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("from_location")));

							WebDriverWait wait2 = new WebDriverWait(wd, 10);
							wait2.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>(){
						        public Boolean apply(WebDriver driver)  
						        {
						            Select select = new Select(driver.findElement(By.id("from_location")));
						            return select.getOptions().size()>1;
						        }
						    });
							
							WebElement loc = wd.findElement(By.id("from_location"));
							Select select2=new Select(loc);
							select2.selectByVisibleText(list1[i]);
							
							WebElement btn = wd.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[3]/div[2]/div/div[1]/div[2]/button"));
							btn.click();
							
							//for 1-km accuracy 
							WebElement btn_1km = wd.findElement(By.cssSelector("[class='gis_info info_1km _event_click_gisinfo']"));
							btn_1km.click();
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idModalGisInfo1kmAsk\"]/div/div")));
							WebElement btn_check = wd.findElement(By.xpath("//*[@id=\"idModalGisInfo1kmAsk\"]/div/div/div/a[2]"));
							btn_check.click();
							TimeUnit.MILLISECONDS.sleep(3000);
							//for 1-km accuracy
							
							
							//resize the map partition
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/div[4]/div/div[2]")));
							WebElement svgObj = wd.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[4]/div/div[2]"));
							Actions actionBuilder = new Actions(wd);
							actionBuilder.click(svgObj).build().perform();
							wd.manage().window().setSize(new Dimension(992, 850));
							TimeUnit.MILLISECONDS.sleep(2000);
				
							TakesScreenshot ts=(TakesScreenshot)wd;
							
						    File source=ts.getScreenshotAs(OutputType.FILE);    
						    FileHandler.copy(source,new File("D:\\temp2.png"));
						    wd.quit();
						    
						}catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						
						//crop imgae
						int x = 120;
					    int y = 150;
					    int w = 976;
					    int h = 714;
					    
					    try{
					    	
					    	BufferedImage image = ImageIO.read(new File("D:\\temp2.png"));
					        BufferedImage out = image.getSubimage(x, y, w-2*x, h-2*y);
					        ImageIO.write(out, "png", new File(file_name));
					        System.out.println("crop the image done");
					        
					    }catch (Exception e) {
							// TODO: handle exception
						}
					}
					System.out.println("batch image done");
				}
		  }
		  
		  

	  } 
	}
