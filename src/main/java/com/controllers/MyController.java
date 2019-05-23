package com.controllers;

import com.beans.Movie;
import com.beans.User;
import com.services.IMyService;
import com.services.MyServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;

@Path("MyController")
public class MyController {

    IMyService myService = new MyServiceImpl();

//http://localhost:8080/JaxRsProjectMaven_war/api/MyController/start
    @GET
    @Path("/start")
    @Produces(MediaType.APPLICATION_JSON)
    public Response start() {

        Movie movie = new Movie();
        movie.setId(1L);
        movie.setMovieName("The Godfather");
        movie.setReleaseYear(1972);
        movie.setLanguage("English");
        HashMap<String,Movie> hash = new HashMap();
        hash.put("movie",movie);
        return Response.ok().entity(hash).build();
    }

    //http://localhost:8080/JaxRsProjectMaven_war/api/MyController/getPersistUser
    @GET
    @Path("/getPersistUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersistUser() {
        User user = myService.getPersistUser();
        HashMap<String,Object> hash = new HashMap();
        hash.put("user",user);
        return Response.ok().entity(hash).build();
    }

    //http://localhost:8080/JaxRsProjectMaven_war/api/MyController/getPersistUsers
    @GET
    @Path("/getPersistUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersistUsers() {
        List<User> users = myService.getPersistUsers();
        HashMap<String,Object> hash = new HashMap();
        hash.put("users",users);
        return Response.ok().entity(hash).build();
    }

    //http://localhost:8080/JaxRsProjectMaven_war/api/MyController/getUpdateUser/5/LeRoy
    @GET
    @Path("/getUpdateUser/{getId}/{getName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUpdateUser(@PathParam("getId") int id, @PathParam("getName") String name){
        User user = myService.getUpdateUser(id, name);
        HashMap<String,Object> hash = new HashMap();
        hash.put("user",user);
        return Response.ok().entity(hash).build();
    }

    //http://localhost:8080/JaxRsProjectMaven_war/api/MyController/getRemoveUser/15
    @GET
    @Path("getRemoveUser/{getId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRemoveUser(@PathParam("getId") int id){
        User user = myService.getRemoveUser(id);
        HashMap<String,Object> hash = new HashMap();
        hash.put("remove user",user);
        return Response.ok().entity(hash).build();
    }

}
