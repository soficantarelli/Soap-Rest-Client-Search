package ar.edu.ubp.das.ws;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(targetNamespace = "http://ws.das.ubp.edu.ar/", portName = "ListWSPort", serviceName = "ListWSService")
public class ListWS {
	
	@Resource
	WebServiceContext context;

	@WebMethod(operationName = "getList", action = "urn:GetList")
	@WebResult(name = "return")
	public String[] getList() {
		MessageContext messageContext = context.getMessageContext();
		Map http_headers = (Map) messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
		List userList = (List) http_headers.get("Authorization");
		System.out.print(userList);
		
		String[] urls = new String[3];
		urls[0] = "https://es.stackoverflow.com/questions/514226/fecha-con-javascript";
		urls[1] = "https://developer.mozilla.org/es/docs/Web/JavaScript";
		return urls;
	}
	
	@WebMethod(operationName = "ping", action = "urn:Ping")
	@WebResult(name = "return")
	public String ping() {
		return "!pong";
	}
}
