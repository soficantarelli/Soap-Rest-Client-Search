package ar.edu.ubp.das.resources;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ar.edu.ubp.das.beans.UrlBean;
import ar.edu.ubp.das.db.Dao;
import ar.edu.ubp.das.db.DaoFactory;

import java.sql.SQLException;
import java.util.List;

import javax.json.Json;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class ListResource {
	
	private String apiToken = "ejemplo";
	
	@GET
	@Path("/ping")
	public Response ping() {
		return Response.status(Status.OK).entity("pong!").build();
	}
	
	@GET
	@Path("/list")
	public Response getUrl(@HeaderParam ("Authorization") String token) {
			try {
		//System.out.print(token);
		//if (token.equals(apiToken)) {
			Dao<UrlBean, UrlBean> dao = DaoFactory.getDao("Url", "ar.edu.ubp.das");
			System.out.print(dao);
			
			
			return Response.status(Response.Status.OK).entity(dao.select(null)).build();
		/*} else {
			return null;
		}*/
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
	}
}