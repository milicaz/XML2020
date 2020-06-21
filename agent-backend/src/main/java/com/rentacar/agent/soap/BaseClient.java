package com.rentacar.agent.soap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.rentacar.agent.model.GetAgentRequest;
import com.rentacar.agent.model.GetAgentResponse;
import com.rentacar.agent.model.GetKrajnjiKorisnikRequest;
import com.rentacar.agent.model.GetPorukaRequest;
import com.rentacar.agent.model.GetPorukaResponse;
import com.rentacar.agent.model.GetPrivilegeRequest;
import com.rentacar.agent.model.GetPrivilegeResponse;
import com.rentacar.agent.model.GetRoleRequest;
import com.rentacar.agent.model.GetRoleResponse;
import com.rentacar.agent.model.GetkrajnjiKorisnikResponse;

public class BaseClient extends WebServiceGatewaySupport {

	public GetPrivilegeResponse getPrivilege(Long agentId) {

		GetPrivilegeRequest request = new GetPrivilegeRequest();
		request.setAgentId(agentId);

		System.out.println("getPrivilege u BaseClient");

		GetPrivilegeResponse response = (GetPrivilegeResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8762/rentacar-backend/ws", request);

		return response;
	}

	public GetRoleResponse getRole(Long agentId) {

		GetRoleRequest request = new GetRoleRequest();
		request.setAgentId(agentId);

		System.out.println("getRole u BaseClient");

		GetRoleResponse response = (GetRoleResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8762/rentacar-backend/ws", request);

		return response;
	}

	public GetAgentResponse getAgent(Long agentId) {

		GetAgentRequest request = new GetAgentRequest();
		request.setAgentId(agentId);

		System.out.println("getAgent u BaseClient");

		GetAgentResponse response = (GetAgentResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8762/rentacar-backend/ws", request);

		return response;
	}

	public GetkrajnjiKorisnikResponse getKrajnjiKorisnik(Long agentId) {

		GetKrajnjiKorisnikRequest request = new GetKrajnjiKorisnikRequest();
		request.setAgentId(agentId);

		System.out.println("getClient u BaseClient");

		GetkrajnjiKorisnikResponse response = (GetkrajnjiKorisnikResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8762/rentacar-backend/ws", request);

		return response;
	}

	public GetPorukaResponse getPoruka(Long agentId) {

		GetPorukaRequest request = new GetPorukaRequest();
		request.setAgentId(agentId);

		System.out.println("getMessage u BaseClient");

		GetPorukaResponse response = (GetPorukaResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8762/rentacar-backend/ws", request);

		return response;
	}

}
