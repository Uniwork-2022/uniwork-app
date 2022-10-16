package br.com.uniwork;

import java.sql.SQLException;

import br.com.uniwork.dao.EmpresaDAO;
import br.com.uniwork.model.bo.VagaEmpregoBO;
import br.com.uniwork.model.vo.EmpresaVO;
import br.com.uniwork.model.vo.VagaEmpregoVO;

public class Teste {

	public static void main(String[] args) {
//		VagaEmpregoBO vebo = new VagaEmpregoBO();
//		VagaEmpregoVO vevo = new VagaEmpregoVO(1, 1, "Desenvolvedor Python", "Desenvolve umas parada ae", 3500.2, "SP", "VR - 500; VA - 500");
//		vebo.cadastrar(1, vevo);
		
		EmpresaVO evo = new EmpresaVO("Python sei la", 1, "mamaco", "mamaco123", "python@mamaco.com", 123412341234L, "Rua mamaco", 45502115666481L);
		System.out.println(evo.getLogin());
		System.out.println(evo.getId());
		
		try {
			EmpresaDAO edao = new EmpresaDAO();
			
			edao.insert(evo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
