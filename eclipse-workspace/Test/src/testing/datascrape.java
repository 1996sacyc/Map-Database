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
		//��
		String list0[]= {"�T��","�L�f","���c", "�˥_","�Y��","���r", "�x���t��", "�L��","���", "�Ÿq","�s��","�s��", "���s", "�綩��", "�j�بt��", "�Y��"};
		String HighWay0[] = {"��D 1 ��","��D 1 ��","��D 1 ��","��D 1 ��","��D 1 ��","��D 1 ��","��D 1 ��","�ֳt���� 76 ��","��D 1 ��", "��D 1 ��","��D 1 ��","��D 8 ��","��D 1 ��","��D 1 ��", "��D 1 ��","��D 5 ��"  };
		
		//��
		String list1[]= {"��s", "�L�f", "���c", "�˥_", "���s", "�Y��","�T�q", "�j��","�j��", "�j���G", "�L��","�_��", "���L�t��","�Ÿq","�s��", "���Y", "���q","�P�_�t��", "�����t��", "�U��", "�W�L�汱", "ù�F"};
		String HighWay1[] = {"��D 1 ��","��D 1 ��","��D 1 ��","��D 1 ��","��D 3 ��","��D 1 ��","��D 1 ��", "��D 3 ��", "��D 1 ��","�ֳt���� 74 ��" , "�ֳt���� 76 ��", "��D 1 ��","��D 1 ��","��D 1 ��","��D 1 ��", "�ֳt���� 84 ��", "��D 3 ��", "��D 3 ��", "��D 1 ��", "�ֳt���� 88 ��", "��D 5 ��","��D 5 ��"};

		MyThread temp= new MyThread("vertical");
        temp.start();
        MyThread temp2= new MyThread("hotizontal");
        temp2.start();
        
		
	

	}
	
	
}
