package pages.com;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.com.config;
import generics.com.Genericos;

public class ConsultarOportunidadesPage {
	
	private WebDriver driver;
	Genericos genericos;
	
	public ConsultarOportunidadesPage(){
		driver = config.ObterDriver();
		PageFactory.initElements(driver, this);
		genericos = new Genericos(driver, config.ObterCenario());
	}
	
	@FindBy(name = "potentialname")
	public WebElement nomePesquisa;
	
	@FindBy(xpath = "//*[@id=\"listViewContent\"]/div/div[3]/div[2]/table/thead/tr[2]/th[1]/div/button")
	public WebElement btnPesquisar;
	
	@FindBy(id = "listview-table")
	public WebElement tabela;
	
	public void consultarOportunidade() {
		
			genericos.aguardaElemento(btnPesquisar, 30);
			List<HashMap<String, String>> dados = config.ObterDados();
			
			for (int linhaPlanilha = 0; linhaPlanilha < dados.size(); linhaPlanilha++) {
				genericos.limpaCampo(nomePesquisa);
				genericos.preencheCampo(nomePesquisa, dados.get(linhaPlanilha).get("NomeOportunidade"));
				genericos.click(btnPesquisar);
				genericos.aguardar(5);
				
				WebElement tabelaPesquisa = driver.findElement(By.id("listview-table"));
				genericos.aguardaElemento(tabelaPesquisa, 30);
				
				String[][] dadosPesquisa = genericos.leTabela(tabelaPesquisa);
				boolean validou = false;
				
				for (int linha = 0; linha < dadosPesquisa.length; linha++) {
					String oportunidade = dadosPesquisa[linha][1];
					if(oportunidade.equals(dados.get(linhaPlanilha).get("NomeOportunidade"))) {
						validou = true;
					} else {
						validou = false;
					}
				}
				
				if(validou == true) {
					genericos.escreveRelatorio(true, "Consulta da oportunidade " + dados.get(linhaPlanilha).get("NomeOportunidade") + " realizada com sucesso", true);
				}else {
					genericos.escreveRelatorio(false, "Consulta da oportunidade " + dados.get(linhaPlanilha).get("NomeOportunidade") + " falhou", true);
				}	

			}
	}
}
