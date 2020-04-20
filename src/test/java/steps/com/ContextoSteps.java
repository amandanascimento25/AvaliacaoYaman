package steps.com;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import pages.com.ContextoPage;

public class ContextoSteps {
	
	ContextoPage contexto = new ContextoPage();
	
	@Dado("^que acesso o sistema$")
	public void que_acesso_o_sistema() throws Throwable {
	    contexto.acessarSistema();
	}

	@Entao("^realizo login$")
	public void realizo_login() throws Throwable {
	    contexto.login();
	    contexto.Entrar.click();
	}

}
