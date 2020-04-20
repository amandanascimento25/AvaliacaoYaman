package generics.com;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;

public class Genericos {

	private WebDriver driver;
	private Scenario scenario;

	public Genericos(WebDriver webDriver, Scenario scenario) {

		this.scenario = scenario;
		this.driver = webDriver;
	}

	public void aguardar(int timeOut) {

		timeOut = timeOut * 1000;

		try {
			Thread.sleep(timeOut);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void aguardaElemento(WebElement elemento, int timeOut) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, timeOut);

			if (wait.until(ExpectedConditions.visibilityOfAllElements(elemento)) == null) {
				escreveRelatorio(false, "O elemento " + elemento + " não foi carregado!", true);
			}

		} catch (Exception e) {
			escreveRelatorio(false, "O elemento " + elemento + " não foi carregado!", true);
		}

	}

	public boolean aguardaElementoVisivel(WebElement elemento, int timeOut) {

		boolean visivel = false;

		try {

			WebDriverWait wait = new WebDriverWait(driver, timeOut);

			if (wait.until(ExpectedConditions.visibilityOfAllElements(elemento)) == null) {
				visivel = true;
			}

		} catch (Exception e) {
			escreveRelatorio(false, "O elemento " + elemento + " não é visível!", true);
		}

		return visivel;

	}

	public void preencheCampo(WebElement elemento, String valor) {

		try {
			aguardaElemento(elemento, 10);
			elemento.sendKeys(valor);
		} catch (Exception e) {
			escreveRelatorio(false, "Não foi possível preencher o campo " + elemento, true);
		}

	}
	
	public void limpaCampo(WebElement elemento) {

		try {
			aguardaElemento(elemento, 10);
			elemento.clear();
		} catch (Exception e) {
			escreveRelatorio(false, "Não foi possível limpar o campo " + elemento, true);
		}

	}

	public void selecionaComboBox(WebElement link, WebElement lista, String item) {

		try {
			link.click();
			aguardar(2);
			List<WebElement> arrItens = lista.findElements(By.tagName("li"));
			boolean achou = false;

			for (WebElement arrItem : arrItens) {
				if (arrItem.findElement(By.tagName("div")).getText().equals(item)) {
					arrItem.click();
					achou = true;
					break;
				}
			}

			if (achou == false) {
				escreveRelatorio(false, "Não foi possivel localizar o " + item, true);
			}

		} catch (Exception e) {
			escreveRelatorio(false, "Erro inesperado ", true);
		}
	}

	public void selecionaMenu(WebElement lista, String item, String acao) {

		List<WebElement> arrItens = lista.findElements(By.tagName("div"));

		for (WebElement arrItem : arrItens) {
			String itemMenu = arrItem.getText();
			if (itemMenu.equals(item)) {
				if (acao.equals("hover")) {
					Actions action = new Actions(driver);
					action.moveToElement(arrItem).build().perform();
				} else if (acao.equals("click")) {
					arrItem.click();
				}
				break;
			}
		}

	}

	public void click(WebElement elemento) {

		try {
			aguardaElemento(elemento, 10);
			elemento.click();
		} catch (Exception e) {
			escreveRelatorio(false, "Não foi possível efetuar o click no elemento " + elemento, true);
		}

	}

	public String obterTextElemento(WebElement elemento) {
		String text = null;

		try {
			text = elemento.getText();
		} catch (Exception e) {
			escreveRelatorio(false, "Não foi possível obter o texto do elemento " + elemento, true);
		}

		return text;
	}

	public String[][] leTabela(WebElement tabela) {

		int linhas = tabela.findElements(By.tagName("tr")).size() - 1;
		int colunas = tabela.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).size();

		String[][] listaTabela = new String[linhas][colunas];

		for (int indiceLinha = 1; indiceLinha <= linhas; indiceLinha++) {

			WebElement linha = tabela.findElements(By.tagName("tr")).get(indiceLinha);

			for (int indiceColuna = 0; indiceColuna <= colunas - 1; indiceColuna++) {
				listaTabela[indiceLinha - 1][indiceColuna] = linha.findElements(By.tagName("td")).get(indiceColuna)
						.getText();
			}
		}

		return listaTabela;
	}

	public void escreveRelatorio(boolean status, String msg, boolean printScreen) {

		scenario.write(msg);

		if (printScreen) {
			scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
		}

		if (status == false) {
			Assert.fail(msg);
		}

	}

}
