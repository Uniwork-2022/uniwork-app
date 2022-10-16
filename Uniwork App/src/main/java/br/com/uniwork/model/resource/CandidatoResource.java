package br.com.uniwork.model.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.uniwork.model.bo.CandidatoBO;
import br.com.uniwork.model.bo.EmpresaBO;
import br.com.uniwork.model.exceptions.MenorDeIdadeException;
import br.com.uniwork.model.vo.CandidatoVO;
import br.com.uniwork.model.vo.EmpresaVO;

@Path("/candidato")
public class CandidatoResource {
	CandidatoBO cbo = new CandidatoBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CandidatoVO> buscar() {

		try {
			return cbo.listar();
		} catch (SQLException e) {
			System.err.println("Erro na operação...");
			e.printStackTrace();
		}

		return null;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CandidatoVO buscar(@PathParam("id") int id) {
		try {
			return cbo.listar(id);
		} catch (SQLException e) {
			System.err.println("Erro na operação...");
			e.printStackTrace();
		}

		return null;
	}

	@POST
	@Consumes
	public Response cadastrar(CandidatoVO candidato, @Context UriInfo uriInfo) {
		try {
			cbo.cadastrar(candidato);
		} catch (MenorDeIdadeException e) {
			System.err.println("Erro na operação...");
			e.printStackTrace();
		}
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(candidato.getId()));
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(CandidatoVO cvo, @PathParam("{id}") int id) throws SQLException {
		cbo.atualizar(id,cvo);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) throws SQLException {
		cbo.deletar(id);
	}
}
