package br.com.uniwork.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.uniwork.model.factory.ConectionFactory;
import br.com.uniwork.model.vo.EmpresaVO;

/**
 * Classe que gerencia a as operações de CRUD da classe Empresa
 * @author Mateus Cabral
 * @version 1.0
 * @see #EmpresaVO() 
 * @see #EmpresaBO()
 */
public class EmpresaDAO {
	private Connection conn = null;
	
	public EmpresaDAO() throws SQLException {
		conn = new ConectionFactory().getConn();
	}
	
	public void insert(EmpresaVO e) throws SQLException {
		String sql = "INSERT INTO T_UW_EMPRESA "
				+ "(nm_empresa, nr_cnpj, ds_email, nr_telefone, st_empresa, ds_username, ds_senha, id_empresa) VALUES (?,?,?,?,?,?,?,SQ_UW_EMPRESA.NEXTVAL)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, e.getNome());
		ps.setLong(2, e.getCnpj());
		ps.setString(3, e.getEmail());
		ps.setLong(4, e.getCelular());
		ps.setString(5, "A");
		ps.setString(6, e.getLogin());
		ps.setString(7, e.getPwd());
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	
	/**
	 * GET BY ID
	 * Retorna uma Empresa, busca no banco feito pelo ID
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public EmpresaVO select(int id) throws SQLException {	
		String sql = "SELECT FROM T_UW_EMPRESA WHERE ID_EMPRESA= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		EmpresaVO evo = new EmpresaVO();
		while(rs.next()) {
			String status = rs.getNString("st_empresa");
			evo.setNome(rs.getString("nm_empresa"));
			evo.setCnpj(rs.getLong("nr_cnpj"));
			evo.setCelular(rs.getLong("nr_telefone"));
			evo.setEmail(rs.getString("ds_email"));
			evo.setStatus((status == "A") ? true : false);
		}
		return evo;
	}
	
	/**
	 * GET ALL
	 * Retorna todas as empresas no banco de dados
	 * @return
	 * @throws SQLException
	 */
	public List<EmpresaVO> select() throws SQLException {
		List<EmpresaVO> empresas = new ArrayList<EmpresaVO>();
		
		String sql = "SELECT * FROM T_UW_EMPRESA";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("id_empresa");
			String nome = rs.getString("nm_empresa");
			Long cnpj = rs.getLong("nr_cnpj");
			Long celular = rs.getLong("nr_telefone");
			String email = rs.getString("ds_email");
			String login = rs.getString("ds_login");
			String senha = rs.getString("ds_senha");
			String endereco = rs.getString("ds_endereco");
			empresas.add(new EmpresaVO(nome, id, login, senha, email, celular, endereco, cnpj));
			
		}
		
		return empresas;
		
	}
	
	/**'
	 * UPDATE NAME
	 * Atualiza um registro no banco, precisa do ID para fazer a busca
	 * @param id
	 * @param novoNome
	 * @throws SQLException
	 */
	public void update(int id, String novoNome) throws SQLException {
		String sql = "UPDATE T_UW_EMPRESA SET NM_EMPRESA = (?) WHERE ID_EMPRESA = (?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, novoNome);
		ps.setInt(2, id);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	
	/**
	 * DELETE
	 * Deleta um registro no banco a partir do ID
	 * @param id
	 * @throws SQLException
	 */
	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM T_UW_EMPRESA WHERE ID_EMPRESA = (?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
		ps.close();
		conn.close();
	}
	
}
