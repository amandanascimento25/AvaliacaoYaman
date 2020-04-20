package pages.com;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.com.config;
import generics.com.Genericos;

public class AddOportunidadesPage {
	
	private WebDriver driver;
	Genericos genericos;
	
	public AddOportunidadesPage(){
		driver = config.ObterDriver();
		PageFactory.initElements(driver, this);
		genericos = new Genericos(driver, config.ObterCenario());
	}
	
	@FindBy(id = "Potentials_editView_fieldName_potentialname")
	public WebElement nomeOportunidade;
	
	@FindBy(xpath = "//*[@id=\"s2id_autogen1\"]/a")
	public WebElement linkTipoNegocio;
	
	@FindBy(xpath = "//*[@id=\"select2-results-2\"]")
	public WebElement listaTipoNegocio;
	
	@FindBy(xpath = "//*[@id=\"s2id_autogen3\"]/a")
	public WebElement linkFonteLead;
	
	@FindBy(xpath = "//*[@id=\"select2-results-4\"]")
	public WebElement listaFonteLead;
	
	@FindBy(xpath = "//*[@id=\"s2id_autogen5\"]/a")
	public WebElement linkResponsavel;
	
	@FindBy(xpath = "//*[@id=\"select2-results-6\"]")
	public WebElement listaResponsaveis;
	
	@FindBy(id = "Potentials_editView_fieldName_forecast_amount")
	public WebElement receitaPonderada;
	
	@FindBy(id= "Potentials_editView_fieldName_amount")
	public WebElement valorFechamento;
	
	@FindBy(id= "Potentials_editView_fieldName_closingdate")
	public WebElement previsaoFechamento;
	
	@FindBy(id= "Potentials_editView_fieldName_nextstep")
	public WebElement proximoPasso;
	
	@FindBy(xpath = "//*[@id=\"s2id_autogen7\"]/a")
	public WebElement linkEstagioVendas;
	
	@FindBy(xpath = "//*[@id=\"select2-results-8\"]")
	public WebElement listaEstagioVendas;
	
	@FindBy(id = "Potentials_editView_fieldName_probability")
	public WebElement probabilidade;
	
	@FindBy(id = "Potentials_editView_fieldName_description")
	public WebElement descricao;
	
	@FindBy(className = "btn")
	public WebElement salvar;
	
	@FindBy (className = "potentialname")
	public WebElement validaOportunidade;
	
	@FindBy(id = "Potentials_listView_basicAction_LBL_ADD_RECORD")
	public WebElement novaOportunidade;
	
	public void cadastrarOportunidade() {
		
		List<HashMap<String, String>> Dados = config.ObterDados();
		int totalLinhas = Dados.size()-1;
		
		for (int linha = 0; linha <= totalLinhas; linha++) {
			
			genericos.preencheCampo(nomeOportunidade, Dados.get(linha).get("NomeOportunidade"));
			genericos.selecionaComboBox(linkTipoNegocio, listaTipoNegocio, Dados.get(linha).get("Tipo"));
			genericos.selecionaComboBox(linkFonteLead, listaFonteLead, Dados.get(linha).get("FonteLead"));
			genericos.selecionaComboBox(linkResponsavel, listaResponsaveis, Dados.get(linha).get("Responsavel"));
			genericos.preencheCampo(receitaPonderada,  Dados.get(linha).get("ReceitaPonderada"));
			genericos.preencheCampo(valorFechamento, Dados.get(linha).get("ValorFechamento"));
			genericos.preencheCampo(previsaoFechamento, Dados.get(linha).get("PrevisaoFechamento"));
			genericos.preencheCampo(proximoPasso, Dados.get(linha).get("ProximoPasso"));
			genericos.selecionaComboBox(linkEstagioVendas, listaEstagioVendas, Dados.get(linha).get("EstagioVendas"));
			genericos.preencheCampo(probabilidade, Dados.get(linha).get("Probabilidade"));
			genericos.preencheCampo(descricao, Dados.get(linha).get("Descricao"));
			
			genericos.click(salvar);
			
			genericos.aguardaElemento(validaOportunidade, 30);
			genericos.aguardar(3);
			
			if (genericos.obterTextElemento(validaOportunidade).equals(Dados.get(linha).get("NomeOportunidade"))) {
				genericos.escreveRelatorio(true, "Oportunidade cadastrada com sucesso " + Dados.get(linha).get("NomeOportunidade"), true);
			}else {
				genericos.escreveRelatorio(false, "Não foi possivel cadastrar oportunidade " + Dados.get(linha).get("NomeOportunidade"), true);
			}
			
			if(linha < totalLinhas) {
				genericos.click(novaOportunidade);
			}
		}
	}
}
