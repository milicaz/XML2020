package com.rentacar.backend.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.rentacar.backend.model.Agent;
import com.rentacar.backend.model.GetAgentRequest;
import com.rentacar.backend.model.GetAgentResponse;
import com.rentacar.backend.model.GetKrajnjiKorisnikRequest;
import com.rentacar.backend.model.GetPrivilegeRequest;
import com.rentacar.backend.model.GetPrivilegeResponse;
import com.rentacar.backend.model.GetRoleRequest;
import com.rentacar.backend.model.GetRoleResponse;
import com.rentacar.backend.model.GetkrajnjiKorisnikResponse;
import com.rentacar.backend.model.KrajnjiKorisnik;
import com.rentacar.backend.model.Privilege;
import com.rentacar.backend.model.Role;
import com.rentacar.backend.service.KorisnikService;
import com.rentacar.backend.service.PrivilegeService;
import com.rentacar.backend.service.RoleService;

@Endpoint
public class BaseEndpoint {

	private static final String NAMESPACE_URI = "rentacar";

	@Autowired
	private KorisnikService korisnikService;
	@Autowired
	private PrivilegeService privilegeService;
	@Autowired
	private RoleService roleService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAgentRequest")
	@ResponsePayload
	public GetAgentResponse getAgent(@RequestPayload GetAgentRequest request) {
		System.out.println("-----getAgent u BaseEndpoint-u------");
		System.out.println("agent id: " + request.getAgentId());
		GetAgentResponse response = new GetAgentResponse();
		List<Agent> agenti = korisnikService.getAllAgenti();
		response.setKorisnik(agenti);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetKrajnjiKorisnikRequest")
	@ResponsePayload
	public GetkrajnjiKorisnikResponse getKrajnjiKorisnik(@RequestPayload GetKrajnjiKorisnikRequest request) {
		System.out.println("-----getKrajnjiKorisnik u BaseEndpoint-u------");
		System.out.println("korisnik id: " + request.getAgentId());
		GetkrajnjiKorisnikResponse response = new GetkrajnjiKorisnikResponse();
		List<KrajnjiKorisnik> korisnici = korisnikService.getAllKrajnjiKorisnici();
		response.setKorisnik(korisnici);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetRoleRequest")
	@ResponsePayload
	public GetRoleResponse getRole(@RequestPayload GetRoleRequest request) {
		System.out.println("-----getRole u BaseEndpoint-u------");
		System.out.println("agent id: " + request.getAgentId());
		GetRoleResponse response = new GetRoleResponse();
		List<Role> uloge = roleService.getAllRoles();
		response.setUloge(uloge);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetPrivilegeRequest")
	@ResponsePayload
	public GetPrivilegeResponse getPrivilege(@RequestPayload GetPrivilegeRequest request) {
		System.out.println("-----getPrivilege u BaseEndpoint-u------");
		System.out.println("agent id: " + request.getAgentId());
		GetPrivilegeResponse response = new GetPrivilegeResponse();
		List<Privilege> privilegije = privilegeService.getAllPrivilege();
		response.setPrivilegije(privilegije);
		return response;
	}

}
