package com.niuniu.superadapter.platform;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.gof.rest.vo.SampleResponse;
import org.springframework.stereotype.Component;

import com.niuniu.superadapter.operator.OperatorAdapter;
import com.niuniu.superadapter.platform.params.StationListRequest;
import com.niuniu.superadapter.platform.params.StationListResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Component
@Path("/niuniupf")
@Api(value="NiuniuInterface", description="Icomm 接口服务")
public class PlatformImpl {
	
	
    @Path("/icomm/stationsinfo")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value="取得所有充电站信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "方法执行正确",response = StationListResponse.class ),
            @ApiResponse(code = 500, message = "方法执行错误")})	
	public Response queryStationsInfo(StationListRequest request){
    	StandardIcomm icomm = new OperatorAdapter();
    	StationListResponse response = icomm.queryStationsInfo(request); 
    	return Response.status(200).entity(response).build();
	}
}
