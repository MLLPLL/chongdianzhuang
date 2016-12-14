package org.gof.rest.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ContainerRequest;
import org.gof.rest.vo.SampleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * @author Alex.Chen
 *         Header头Token的拦截例子，详细逻辑需要重写
 */

@Provider
public class AuthorizationRequestFilter implements ContainerRequestFilter {

    private static final Logger LOG = LoggerFactory.getLogger(AuthorizationRequestFilter.class);

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        ContainerRequest request = (ContainerRequest) containerRequestContext;
//        LOG.info("验证权限,使用" + request.getHeaderString("User-Agent") + ",以" + request.getMethod() + "的方式请求资源:" + request.getPath(true));
//        String token = request.getHeaderString("Authorization_Token");
//        if ("swagger.json".equals(request.getPath(true)) ||
//                "sample/login".equals(request.getPath(true))) {
//            return;
//        }
//        if (StringUtils.isEmpty(token) || (!"123456".equals(token))) {
//            SampleResponse sampleResponse = new SampleResponse();
//            sampleResponse.setError("没有权限");
//            containerRequestContext.abortWith(
//                    Response.status(Response.Status.FORBIDDEN)
//                            .entity(sampleResponse)
//                            .build());
//        }
    }
}
