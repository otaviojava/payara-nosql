package my.compary;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("fishes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FishResource {

    @Inject
    private FishRepository repository;

    @POST
    public void create(Fish entity) {
        repository.save(entity);
    }

    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") String id, Fish entity) {
        repository.save(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        repository.deleteById(id);
    }

    @GET
    @Path("{id}")
    public Fish find(@PathParam("id") String id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @GET
    public List<Fish> findAll() {
        return repository.findAll();
    }

}
