package my.compary;


import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

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

@Path("fish")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FishResource {

    @Inject
    private FishRepository repository;

    @POST
    @Operation(summary = "Insert an Episode", description = "Insert a fish")
    @APIResponse(responseCode = "201", description = "When creates a fish")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    public void create(@RequestBody(description = "Create a new Episode.",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Fish.class))) Fish entity) {
        repository.save(entity);
    }

    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") String id, Fish entity) {
        repository.save(entity);
    }

    @DELETE
    @Operation(summary = "Delete a fish by ID", description = "Delete a fish by ID")
    @APIResponse(responseCode = "200", description = "When deletes the fish")
    @APIResponse(responseCode = "404", description = "When the id does not exist")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Path("{id}")
    public void remove(@Parameter(description = "The Fish ID", required = true,
            example = "1", schema = @Schema(type = SchemaType.INTEGER))
                       @PathParam("id") String id) {
        repository.deleteById(id);
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Find an fish by id", description = "Find an fish by id")
    @APIResponse(responseCode = "200", description = "The fish")
    @APIResponse(responseCode = "404", description = "When the id does not exist")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @APIResponse(description = "The Fish", content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = Fish.class)))
    public Fish find(@Parameter(description = "The Fish ID", required = true,
            example = "1", schema = @Schema(type = SchemaType.INTEGER)) @PathParam("id") String id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @GET
    @Operation(summary = "Get all the fish", description = "Returns all available fish")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @APIResponse(responseCode = "200", description = "The fish")
    public List<Fish> findAll() {
        return repository.findAll();
    }

}
