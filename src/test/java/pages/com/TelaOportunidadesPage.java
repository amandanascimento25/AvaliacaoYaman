package pages.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.com.config;
import generics.com.Genericos;

public class TelaOportunidadesPage {
	
	private WebDriver driver;
	Genericos genericos;
	
	public TelaOportunidadesPage(){
		driver = config.ObterDriver();
		PageFactory.initElements(driver, this);
		genericos = new Genericos(driver, config.ObterCenario());
	}
	
	@FindBy(xpath= "//*[@id=\"Potentials_listView_basicAction_LBL_ADD_RECORD\"]")
	public WebElement linkAddOportunidades;
	
	public void adicionarOportunidade() {
		genericos.click(linkAddOportunidades);
	}
}
