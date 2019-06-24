package testing;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.PresentationDirection;
import javax.xml.transform.Templates;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class datascrape {
	

	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
		//直
		String list0[]= {"三重","林口","中壢", "竹北","頭份","銅鑼", "台中系統", "林厝","虎尾", "嘉義","新營","新市", "岡山", "瑞隆路", "大華系統", "頭城"};
		String HighWay0[] = {"國道 1 號","國道 1 號","國道 1 號","國道 1 號","國道 1 號","國道 1 號","國道 1 號","快速公路 76 號","國道 1 號", "國道 1 號","國道 1 號","國道 8 號","國道 1 號","國道 1 號", "國道 1 號","國道 5 號"  };
		
		//橫
		String list1[]= {"圓山", "林口", "內壢", "竹北", "香山", "頭屋","三義", "大甲","大雅", "大里二", "林厝","北斗", "雲林系統","嘉義","新營", "渡頭", "關廟","燕巢系統", "鼎金系統", "萬丹", "坪林行控", "羅東"};
		String HighWay1[] = {"國道 1 號","國道 1 號","國道 1 號","國道 1 號","國道 3 號","國道 1 號","國道 1 號", "國道 3 號", "國道 1 號","快速公路 74 號" , "快速公路 76 號", "國道 1 號","國道 1 號","國道 1 號","國道 1 號", "快速公路 84 號", "國道 3 號", "國道 3 號", "國道 1 號", "快速公路 88 號", "國道 5 號","國道 5 號"};

		MyThread temp= new MyThread("vertical");
        temp.start();
        MyThread temp2= new MyThread("hotizontal");
        temp2.start();
        
		
	

	}
	
	
}
