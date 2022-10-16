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

import br.com.uniwork.model.bo.EmpresaBO;
import br.com.uniwork.model.vo.EmpresaVO;

@Path("/empresa")
public class EmpresaResource {
	EmpresaBO ebo = new EmpresaBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmpresaVO> buscar() {

		try {
			return ebo.listar();
		} catch (SQLException e) {
			System.err.println("Erro na operação...");
			e.printStackTrace();
		}

		return null;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public EmpresaVO buscar(@PathParam("id") int id) {
		try {
			return ebo.listar(id);
		} catch (SQLException e) {
			System.err.println("Erro na operação...");
			e.printStackTrace();
		}

		return null;
	}

	@POST
	@Consumes
	public Response cadastrar(EmpresaVO empresa, @Context UriInfo uriInfo) {
		ebo.cadastrar(empresa);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(empresa.getId()));
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(String novoNome, @PathParam("{id}") int id) throws SQLException {
		ebo.atualizar(id,novoNome);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) throws SQLException {
		ebo.deletar(id);
	}
}
