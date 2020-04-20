package steps.com;

import cucumber.api.java.pt.Entao;
import pages.com.ConsultarOportunidadesPage;

public class ConsultarOportunidadesSteps {
	
	ConsultarOportunidadesPage consultar = new ConsultarOportunidadesPage();
	
	@Entao("^consulto o nome da Oportunidade desejada$")
	public void consulto_o_nome_da_Oportunidade_desejada() throws Throwable {
	    consultar.consultarOportunidade();
	}
}
