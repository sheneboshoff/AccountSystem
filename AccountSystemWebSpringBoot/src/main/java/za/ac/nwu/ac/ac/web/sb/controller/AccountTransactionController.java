package za.ac.nwu.ac.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.ModifyAccountTransactionFlow;

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
            @RequestBody AccountTransactionDto accountTransaction){
        AccountTransactionDto accountTransactionResponse = createAccountTransactionFlow.create(accountTransaction);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransactionResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
