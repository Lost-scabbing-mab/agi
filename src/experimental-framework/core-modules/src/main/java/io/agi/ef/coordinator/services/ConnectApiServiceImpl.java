package io.agi.ef.coordinator.services;

import io.agi.ef.core.ConnectionManager;
import io.agi.ef.core.EndpointUtils;
import io.agi.ef.serverapi.api.*;


import io.agi.ef.serverapi.api.NotFoundException;

import javax.ws.rs.core.Response;

public class ConnectApiServiceImpl extends ConnectApiService {

    @Override
    public Response connectAgentBaseurlGet( String contextPath )
            throws NotFoundException {
        System.out.println( "Received request to connect to an agent at baseurl: " + contextPath );

        ConnectionManager.getInstance().registerServer(
                ConnectionManager.ServerConnection.ServerType.Agent,
                EndpointUtils.agentListenPort(),        // todo: ugly hardcoding. This should come from the request, but wishing to remove need for it completely.
                contextPath );

        return Response.ok().entity( new ApiResponseMessage( ApiResponseMessage.OK, "connect to agent: " + contextPath + "." ) ).build();
    }

}