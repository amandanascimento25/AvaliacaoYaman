package steps.com;

import cucumber.api.java.pt.Entao;
import pages.com.AddOportunidadesPage;

public class AddOportunidadesSteps {
	
	AddOportunidadesPage addOportunidades =  new AddOportunidadesPage();
	
	@Entao("^realizo o cadastro$")
	public void realizo_o_cadastro() throws Throwable {
	  
		addOportunidades.cadastrarOportunidade();
		
	}
}
