package steps.com;

import cucumber.api.java.pt.Quando;
import pages.com.TelaOportunidadesPage;

public class TelaOportunidadesSteps {
	TelaOportunidadesPage telaOportunidades = new TelaOportunidadesPage();
	
	@Quando("^clico em Adicionar Oportunidade$")
	public void clico_em_Adicionar_Oportunidade() throws Throwable {
	   telaOportunidades.adicionarOportunidade();
	}

}
