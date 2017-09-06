package com.phonet.project.resource;

import com.phonet.project.domain.Account;
import com.phonet.project.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

/**
 * Created by yuri on 06.09.17.
 */
@Resource
@Path("/accounts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {

    private static final String URI_STR = "http://localhost:8080/project/accounts/";

    @Autowired
    AccountService accountService;

    @GET
    public List<Account> getAll(){
        return accountService.findAll();
    }

    @GET
    @Path("/{id}")
    public Account findOneById(@PathParam("id") Long id){
        return accountService.findById(id);
    }

    @POST
    public Response save(Account account){
        Long id = accountService.save(account).getId();
        return Response.created(URI.create(URI_STR + id)).build();
    }

    @PUT
    @Path("/{id}")
    public Account update(@PathParam("id") Long id, Account account){
        account.setId(id);
        return accountService.update(account);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id")Long id){
        accountService.delete(id);
    }

}
