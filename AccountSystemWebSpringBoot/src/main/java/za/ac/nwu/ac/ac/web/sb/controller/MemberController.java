package za.ac.nwu.ac.ac.web.sb.controller;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.logic.flow.CreateMemberFlow;
import za.ac.nwu.ac.logic.flow.FetchMemberFlow;
import za.ac.nwu.ac.logic.flow.ModifyMemberFlow;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("member")
public class MemberController {

    private final FetchMemberFlow fetchMemberFlow;
    private final CreateMemberFlow createMemberFlow;
    private final ModifyMemberFlow modifyMemberFlow;

    @Autowired
    public MemberController(@Qualifier("fetchMemberFlowName") FetchMemberFlow fetchMemberFlow,
                            @Qualifier("createMemberFlowName") CreateMemberFlow createMemberFlow,
                            @Qualifier("modifyMemberFlowName") ModifyMemberFlow modifyMemberFlow) {
        this.createMemberFlow = createMemberFlow;
        this.fetchMemberFlow = fetchMemberFlow;
        this.modifyMemberFlow = modifyMemberFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Members.", notes = "Returns a list of members")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Members returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<MemberDto>>> getAll() {
        List<MemberDto> members = fetchMemberFlow.getAllMembers();
        GeneralResponse<List<MemberDto>> response = new GeneralResponse<>(true, members);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("memberID")
    @ApiOperation(value = "Fetches the specified Member.", notes = "Fetches the specified Member corresponding to the given MemberID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Goal Found"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MemberDto>> getMember(
            @ApiParam(value = "The memberID that uniquely identifies the Member.",
                    example = "1",
                    name = "memberID",
                    required = true)
            @RequestParam("memberID") final Long memberID,

            @ApiParam(value = "The accountTypeID that uniquely identifies the AccountType.",
                    example = "1",
                    name = "accountTypeID",
                    required = true)
            @RequestParam("accountTypeID")final Long accountTypeID)

    {
        MemberDto member = fetchMemberFlow.getMemberByMemberID(memberID, accountTypeID);
        GeneralResponse<MemberDto> response = new GeneralResponse<>(true, member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new Member.", notes = "Creates a new Member in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The Member was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MemberDto>> create(
            @ApiParam(value = "Request body to create a new Member.", required = true)
            @RequestBody MemberDto member) {
        MemberDto memberResponse = createMemberFlow.create(member);
        GeneralResponse<MemberDto> response = new GeneralResponse<>(true, memberResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("add/{addCurrency}")
    @ApiOperation(value = "Adds specified currency amount to the specified Member.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The amount was added successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MemberDto>> addCurrency(
            @ApiParam(value = "The amount that needs to be added to account.",
                    example = "200",
                    name = "addCurrency",
                    required = true)
            @PathVariable("addCurrency") final String amount,

            @ApiParam(value = "The memberID that uniquely identifies the member.",
                    example = "1",
                    name = "memberID",
                    required = true)
            @RequestParam("memberID") final Long memberID,

            @ApiParam(value = "The accountID that uniquely identifies the accountType.",
                    example = "1",
                    name = "accountTypeID",
                    required = true)
            @RequestParam("accountTypeID") final Long accountID) {

        Integer intAmount = 0;
        try {
            intAmount = Integer.parseInt(amount);
        } catch (Exception e) {
            throw new RuntimeException("Unable to parse String to Integer", e);
        }
        MemberDto memberResponse = modifyMemberFlow.addCurrency(intAmount, memberID, accountID);
        GeneralResponse<MemberDto> response = new GeneralResponse<>(true, memberResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("subtract/{subtractCurrency}")
    @ApiOperation(value = "Subtracts specified currency amount from the specified Member.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The amount was added successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MemberDto>> subtractCurrency(
            @ApiParam(value = "The amount that needs to be subtracted from the account.",
                    example = "200",
                    name = "subtractCurrency",
                    required = true)
            @PathVariable("subtractCurrency") final String amount,

            @ApiParam(value = "The memberID that uniquely identifies the member.",
                    example = "1",
                    name = "memberID",
                    required = true)
            @RequestParam("memberID") final Long memberID,

            @ApiParam(value = "The accountID that uniquely identifies the accountType.",
                    example = "1",
                    name = "accountTypeID",
                    required = true)
            @RequestParam("accountTypeID") final Long accountID) {

        Integer intAmount = 0;
        try {
            intAmount = Integer.parseInt(amount);
            intAmount = intAmount *= -1;
        } catch (Exception e) {
            throw new RuntimeException("Unable to parse String to Integer", e);
        }
        MemberDto memberResponse = modifyMemberFlow.addCurrency(intAmount, memberID, accountID);
        GeneralResponse<MemberDto> response = new GeneralResponse<>(true, memberResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
