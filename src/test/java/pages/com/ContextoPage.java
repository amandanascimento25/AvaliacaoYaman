package pages.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.com.config;

public class ContextoPage {
	
	private WebDriver driver;
	
	public ContextoPage() {
		
		driver = config.ObterDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")
	public WebElement Nome;
	
	@FindBy(id= "password")
	public WebElement Senha;
	
	@FindBy(className= "button")
	public WebElement Entrar;
	
	@FindBy(className ="forgotPasswordLink")
	public WebElement EsqueceuSenha;
	
	String url ="https://startupflex.com.br/crm/";
	
	String nome = "Amanda Nascimento";
	
	String senha ="0987";
	
	public void acessarSistema() {
		driver.navigate().to(url);
	}
	
	public void login() {
		
		Nome.sendKeys(nome);
		Senha.sendKeys(senha);
		
	}
}
