package za.ac.nwu.ac.ac.web.sb.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.ModifyAccountTransactionFlow;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("account-transaction")
public class AccountTransactionController {

    private final FetchAccountTransactionFlow fetchAccountTransactionFlow;
    private final CreateAccountTransactionFlow createAccountTransactionFlow;
    private final ModifyAccountTransactionFlow modifyAccountTransactionFlow;

    @Autowired
    public AccountTransactionController(FetchAccountTransactionFlow fetchAccountTransactionFlow,
                                        @Qualifier("createAccountTransactionFlowName") CreateAccountTransactionFlow createAccountTransactionFlow, ModifyAccountTransactionFlow modifyAccountTransactionFlow) {
        this.fetchAccountTransactionFlow = fetchAccountTransactionFlow;
        this.createAccountTransactionFlow = createAccountTransactionFlow;
        this.modifyAccountTransactionFlow = modifyAccountTransactionFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account transactions.", notes = "Returns a list of account transactions")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account transactions returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountTransactionDto>>> getAll() {
        List<AccountTransactionDto> accountTypes = fetchAccountTransactionFlow.getAllAccountTransactions();
        GeneralResponse<List<AccountTransactionDto>> response = new GeneralResponse<>(true, accountTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new AccountTransaction.", notes = "Creates a new AccountTransaction for the specified Member.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountType was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> create(
            @ApiParam(value = "Request body to create a new AccountTransaction.", required = true)
            @RequestBody AccountTransactionDto accountTransaction) {
        AccountTransactionDto accountTransactionResponse = createAccountTransactionFlow.create(accountTransaction);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransactionResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
            }

    //create separate mappings for add and subtract

    /*@PostMapping("addCurrency")
    @ApiOperation(value = "Adds specified currency amount to the specified Member.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The amount was created added successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> addCurrency(
            @ApiParam(value = "The amount that needs to be added to account.",
                    example = "200",
                    name = "amount",
                    required = true)
            @PathVariable("amount") final Integer amount,

            @ApiParam(value = "The memberID that uniquely identifies the member.",
                    example = "1",
                    name = "memberID",
                    required = true)
            @PathVariable("memberID") final Long memberID,

            @ApiParam(value = "The accountID that uniquely identifies the accountType.",
                    example = "1",
                    name = "accountID",
                    required = true)
            @PathVariable("accountID") final Long accountID,

            @ApiParam(value = "The date on which the transaction took place in ISO date format (yyyy-MM-dd)",
                    name = "transactionDate")
            @RequestParam(value = "transactionDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate transactionDate) {

        AccountTransactionDto accountTransactionResponse = modifyAccountTransactionFlow.addCurrency(amount, memberID, accountID, transactionDate);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransactionResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }*/

    /*@PostMapping("subtractCurrency")
    @ApiOperation(value = "Subtracts specified currency amount from the specified Member.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The amount was subtracted successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> subtractCurrency (
            @ApiParam(value = "The amount that needs to be subtracted from account.",
                    example = "200",
                    name = "amount",
                    required = true)
            @PathVariable("amount") final Integer amount,

            @ApiParam(value = "The memberID that uniquely identifies the member.",
                    example = "1",
                    name = "memberID",
                    required = true)
            @PathVariable("memberID") final Long memberID,

            @ApiParam(value = "The accountID that uniquely identifies the accountType.",
                    example = "1",
                    name = "accountID",
                    required = true)
            @PathVariable("accountID") final Long accountID,

            @ApiParam(value = "The date on which the transaction took place in ISO date format (yyyy-MM-dd)",
                    name = "transactionDate")
            @RequestParam(value = "transactionDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate transactionDate) {

        AccountTransactionDto accountTransactionResponse = modifyAccountTransactionFlow.subtractCurrency(amount, memberID, accountID, transactionDate);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransactionResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }*/


}
