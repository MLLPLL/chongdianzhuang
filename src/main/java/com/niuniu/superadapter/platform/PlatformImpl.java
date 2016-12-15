package com.niuniu.superadapter.platform;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.niuniu.superadapter.operator.OperatorAdapter;
import com.niuniu.superadapter.platform.params.StationsListRequest;
import com.niuniu.superadapter.platform.params.StationsListResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Component
@Path("/niuniupf")
@Api(value="NiuniuInterface", description="Icomm 接口服务")
public class PlatformImpl {
	
	
    @Path("/stationsinfo")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value="取得所有充电站信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "方法执行正确",response = StationsListResponse.class ),
            @ApiResponse(code = 500, message = "方法执行错误")})	
	public Response queryStationsInfo(StationsListRequest request){
    	StandardIcomm icomm = new OperatorAdapter();
    	StationsListResponse response = icomm.queryStationsInfo(request); 
    	return Response.status(200).entity(response).build();
	}
}
