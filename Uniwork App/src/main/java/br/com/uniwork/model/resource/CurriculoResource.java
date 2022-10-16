/**
 * 
 */
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

import br.com.uniwork.model.bo.CurriculoBO;
import br.com.uniwork.model.vo.CurriculoVO;

/**
 * @author Mateus Cabral
 * @version 1.0
 */
public class CurriculoResource {
	CurriculoBO cbo = new CurriculoBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CurriculoVO> buscar() {

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
	public CurriculoVO buscar(@PathParam("id") int id) {
		try {
			return cbo.listar(id);
		} catch (SQLException e) {
			System.err.println("Erro na operação...");
			e.printStackTrace();
		}

		return null;
	}

	@POST
	@Path("/{id}")
	@Consumes
	public Response cadastrar(CurriculoVO curriculo, int id, @Context UriInfo uriInfo) {
		cbo.cadastrar(curriculo, id);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(curriculo.getId()));
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(CurriculoVO cvo, @PathParam("{id}") int id) throws SQLException {
		cbo.atualizar(id,cvo);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) throws SQLException {
		cbo.deletar(id);
	}
}
