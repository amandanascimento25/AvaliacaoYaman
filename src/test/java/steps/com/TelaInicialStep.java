package steps.com;

import cucumber.api.java.pt.Dado;
import pages.com.TelaInicialPage;

public class TelaInicialStep {
	TelaInicialPage telaInicial = new TelaInicialPage();
	
	@Dado("^que estou na tela inicial$")
	public void que_estou_na_tela_inicial() throws Throwable {
	    telaInicial.TelaModalPreenche();
	}

	@Dado("^no menu seleciono vendas > oportunidades$")
	public void no_menu_seleciono_vendas_oportunidades() throws Throwable {
	    telaInicial.SelecionaMenu();
	}

}
