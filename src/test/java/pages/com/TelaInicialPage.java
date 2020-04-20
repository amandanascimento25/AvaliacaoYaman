package pages.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.com.config;
import generics.com.Genericos;

public class TelaInicialPage {
	
	private WebDriver driver;
	Genericos genericos;
	
	public TelaInicialPage(){
		driver = config.ObterDriver();
		PageFactory.initElements(driver, this);
		genericos = new Genericos(driver, config.ObterCenario());
	}
	
	@FindBy(xpath = "//*[@id=\"s2id_lang_name\"]/a")
	public WebElement linkIdioma;
	
	@FindBy(xpath = "//*[@id=\"s2id_time_zone\"]/a")
	public WebElement linkFusoHorario;
	
	@FindBy(xpath = "//*[@id=\"s2id_date_format\"]/a")
	public WebElement linkFormaData;
	
	@FindBy(xpath = "/html/body/div[2]/ul")
	public WebElement listaComboBox;
	
	@FindBy(className = "btn")
	public WebElement iniciar;
	
	@FindBy(xpath= "//*[@id=\"appnavigator\"]/div/span")
	public WebElement menu;
	
	@FindBy(className= "app-list")
	//@FindBy(xpath= "//*[@id=\"app-menu\"]/div/div[2]")
	public WebElement listaMenu;
	
	@FindBy(xpath="//*[@id=\"mCSB_2_container\"]/li[1]/a")
	public WebElement linkOportunidades;
	
	@FindBy(xpath= "//*[@id=\"Potentials_listView_basicAction_LBL_ADD_RECORD\"]")
	public WebElement linkAddOportunidades;
	
	String idioma = "PT Brasil";
	String fuso = "(UTC-03:00) Brasilia";
	String data ="dd-mm-yyyy";
	String vendas = "VENDAS";
	
	public void TelaModalPreenche() {
		
		if(genericos.aguardaElementoVisivel(iniciar, 5)) {
			genericos.selecionaComboBox(linkIdioma, listaComboBox, idioma);
			genericos.selecionaComboBox(linkFusoHorario, listaComboBox, fuso);
			genericos.selecionaComboBox(linkFormaData,listaComboBox, data);
			genericos.click(iniciar);
		}
		
	}
	
	public void SelecionaMenu() {
		genericos.click(menu);
		genericos.selecionaMenu(listaMenu, vendas,"hover");
		genericos.aguardar(3);
		genericos.click(linkOportunidades);
		
	}
	
}
