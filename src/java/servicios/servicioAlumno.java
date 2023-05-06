
package servicios;

import java.util.Date;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.dao.daoAlumno;
import modelo.dao.daoAsignatura;
import modelo.entidad.Alumno;

@Path("alumno")
public class servicioAlumno {

    @Context
    private UriInfo context;

    public servicioAlumno() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
        public Response getAlumnos() {
        daoAlumno daAlumno= new daoAlumno();        
        return Response.ok(daAlumno.getAll()).build();
        
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
        public Response getAlumno(@PathParam("id") int id) {
            System.out.println(id);
        daoAlumno daAlumno= new daoAlumno();        
        return Response.ok(daAlumno.getAlumno(id)).build();
        
    }
        
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregarAlumno(@FormParam("nom") String nombre, @FormParam("fecha") Date Fecha, @FormParam("tel") String tel ){
        Alumno a = new Alumno(nombre, Fecha, tel);
        daoAlumno daoAlumno1= new daoAlumno();
        int result = daoAlumno1.agregarAlumno(a);
        if (result>0){
            return  Response.status(Response.Status.CREATED).entity("").build();
        }
        else {
            return  Response.status(Response.Status.GONE).build();
        }
      
    }
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response modificarAlumno(@PathParam("id") int id,@FormParam("nom") String nombre, @FormParam("fecha") Date Fecha, @FormParam("tel") String tel ){
        Alumno a = new Alumno(nombre, Fecha, tel);
        daoAlumno daoAlumno1= new daoAlumno();
        int result=  daoAlumno1.modificarAlumno(a, id);
        if (result>0){
            return  Response.status(Response.Status.OK).build();
        }
        else {
            return  Response.status(Response.Status.GONE).build();
        }
      
    }
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarAlumno(@PathParam("id") int id){
        daoAlumno daAlumno= new daoAlumno();
        int result = daAlumno.eliminarAlumno(id);
        if (result>0){
            return  Response.status(Response.Status.OK).build();
        }
        else {
            return  Response.status(Response.Status.GONE).build();
        }
                
    }

}
