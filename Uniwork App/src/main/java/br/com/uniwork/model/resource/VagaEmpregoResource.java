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

import br.com.uniwork.model.bo.VagaEmpregoBO;
import br.com.uniwork.model.vo.VagaEmpregoVO;

@Path("/vagas")
public class VagaEmpregoResource {

	VagaEmpregoBO pb = new VagaEmpregoBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<VagaEmpregoVO> buscar() {
		try {
			return pb.listar();
		} catch (SQLException e) {
			System.out.println("Erro na operação...");
			e.printStackTrace();
		}
		return null;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public VagaEmpregoVO buscar(@PathParam("id") int id) {
		try {
			return pb.listar(id);
		} catch (SQLException e) {
			System.err.println("Erro na operação...");
			e.printStackTrace();
		}
		return null;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(VagaEmpregoVO vaga, @Context UriInfo uriInfo) throws SQLException {

		// INSERIR NA BASE
		pb.cadastrar(1,vaga);

		// CONSTRUIR O PATH DE RETORNO
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(vaga.getEmpresa()));

		// RETORNA O PATH E O STATUS 201
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(VagaEmpregoVO produtoU, @PathParam("{id}") int id) throws SQLException {
		pb.atualizar(id,produtoU);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) throws SQLException {
		pb.deletar(id);
	}

}