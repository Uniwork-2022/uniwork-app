package br.com.uniwork.model.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.uniwork.model.bo.CompatibilidadeBO;
import br.com.uniwork.model.vo.CompatibilidadeVO;

@Path("/compatibilidade")
public class CompatiiblidadeResource {
	CompatibilidadeBO cb;
	
}
