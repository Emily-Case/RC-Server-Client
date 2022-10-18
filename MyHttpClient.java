import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MyHttpClient {
	
	private String hostN = null;
	private int portN;
	private PrintWriter pw;
	private Socket s;
	
	public MyHttpClient(String hostName, int portNumber) throws IOException {
		
		this.hostN = hostName;
		this.portN = portNumber;
		this.s = new Socket(hostN,portN);
		this.pw = new PrintWriter(s.getOutputStream());
	}
	
	public void getResource(String ObjectName) throws IOException {
		
		String request = "GET /" + ObjectName + " HTTP/1.1" + "\r\n";
		pw.println(request);
	}
	
	public void postData(String[] data) throws IOException {
		
	}
	
	public void sendUnimplementedMethod (String wrongMethodName) throws IOException {
		
		String unimplementedRequest = wrongMethodName + " /index.html HTTP/1.1" + "\r\n";
		pw.println(unimplementedRequest);
	}
	
	public void malformedRequest(int type) throws IOException {
		
		String badRequest;
		String Object = "index.html";

		switch (type) {
			
			case 1:
				badRequest = "GET /" + Object + " HTTP/1.1";
				pw.println(badRequest);	
				break;
				
			case 2:
				badRequest = "GET  /" + Object + " HTTP/1.1" + "\r\n";
				pw.println(badRequest);	
				break;
				
			case 3:
				badRequest = "GET /" + Object + "\r\n";	
				pw.println(badRequest);	
				break;
					
		}
		
	}
	
	public void close() throws IOException {
		
		s.close();
	}
}
