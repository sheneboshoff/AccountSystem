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

import java.util.List;

@RestController
@RequestMapping("member")
public class MemberController {

    private final FetchMemberFlow fetchMemberFlow;
    private final CreateMemberFlow createMemberFlow;
    private final ModifyMemberFlow modifyMemberFlow;

    @Autowired
    public MemberController(FetchMemberFlow fetchMemberFlow, @Qualifier("createMemberFlowName") CreateMemberFlow createMemberFlow,
                            ModifyMemberFlow modifyMemberFlow){
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


}
