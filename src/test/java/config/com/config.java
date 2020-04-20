package config.com;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import excel.com.Excel;

public class config {
	
	public String CaminhoPlanilha = System.getProperty("user.dir") + "\\src\\test\\resources\\planilha\\Dados.xlsx";
	public static List<HashMap<String, String>> planilha;
	public static WebDriver driver;
	public static Scenario cenario;
	
	public static WebDriver ObterDriver() {
		return driver;
	}
	
	public static Scenario ObterCenario() {
		return cenario;
	}
	
	public static List<HashMap<String, String>> ObterDados(){
		return planilha;
	}
	
	@Before
	public void ConfiguracaoInicial(Scenario cenario) {
		
		config.cenario = cenario;
		Excel  excel = new Excel();
		planilha = excel.leArquivoExcel(CaminhoPlanilha);
		
		System.out.println("inicio do teste");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void FecharJanela() {
		driver.quit();
		System.out.println("Fim de teste");	
		
	}
}
