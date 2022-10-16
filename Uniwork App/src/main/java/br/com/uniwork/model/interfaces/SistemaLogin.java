package br.com.uniwork.model.interfaces;

public interface SistemaLogin {
	
	boolean login(String login, String pwd);
	boolean logout();
}
