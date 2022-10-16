package br.com.uniwork.model.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.uniwork.model.bo.CompatibilidadeBO;
import br.com.uniwork.model.vo.CandidatoVO;
import br.com.uniwork.model.vo.CompatibilidadeVO;
import br.com.uniwork.model.vo.VagaEmpregoVO;

@Path("/compatibilidade")
public class CompatibilidadeResource {
	CompatibilidadeBO cb;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CompatibilidadeVO> buscar() {
		cb = new CompatibilidadeBO();
		try {
			return cb.listar();
		} catch (SQLException e) {
			System.err.println("Erro na operação...");
			e.printStackTrace();
		}

		return null;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CompatibilidadeVO buscar(@PathParam("id") int id) {
		cb = new CompatibilidadeBO();
		try {
			return cb.listar(id);
		} catch (SQLException e) {
			System.err.println("Erro na operação...");
			e.printStackTrace();
		}

		return null;
	}

	@POST
	@Consumes
	public Response cadastrar(CandidatoVO candidato, VagaEmpregoVO vaga, CompatibilidadeVO cvo,
			@Context UriInfo uriInfo) {
		cb = new CompatibilidadeBO(candidato, vaga);

		cb.cadastrar(cvo);

		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(candidato.getId()));
		return Response.created(builder.build()).build();
	}


	@DELETE
	@Path("/{idVaga}/{idCandidato}")
	public void excluir(@PathParam("id") int idVaga, int idCandidato) throws SQLException {
		cb = new CompatibilidadeBO();
		cb.deletar(idVaga, idCandidato);
	}

}
