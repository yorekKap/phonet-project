package com.phonet.project.resource;

import com.phonet.project.domain.Transaction;
import com.phonet.project.domain.dto.TransactionDto;
import com.phonet.project.service.interfaces.AccountService;
import com.phonet.project.service.interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

/**
 * Created by yuri on 06.09.17.
 */
@Resource
@Path("/transactions")
public class TransactionResource {

    private static final String URI_STR = "http://localhost:8080/project/transactions/";

    @Autowired
    TransactionService transactionService;

    @Autowired
    AccountService accountService;

    @GET
    public List<Transaction> findByAccountId(@QueryParam("account_id") Long accountId) {
        if (accountId == null) {
            return transactionService.findAll();
        }
        return transactionService.findAllByAccountId(accountId);
    }

    @POST
    public Response save(TransactionDto transactionDto) {
        accountService.addToSum(transactionDto.getAccountId(), transactionDto.getSum());
        Long id = transactionService.save(transactionDto.getAccountId(), transactionDto.getSum())
                .getId();

        return Response.created(URI.create(URI_STR + id)).build();

    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        transactionService.delete(id);
    }
}
