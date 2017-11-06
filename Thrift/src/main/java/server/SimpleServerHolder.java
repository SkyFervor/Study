package server;

import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import service.impl.ShopServiceImpl;
import thrift.ShopService;

@Slf4j
public class SimpleServerHolder {
	public static TServer buildServer() {
		TServerSocket serverSocket = null;
		try {
			serverSocket = new TServerSocket(8081);
		} catch (TTransportException e) {
			e.printStackTrace();
		}
		TProcessor tprocessor = new ShopService.Processor<ShopService.Iface>(new ShopServiceImpl());

		TServer.Args tArgs = new TServer.Args(serverSocket);
		tArgs.protocolFactory(new TCompactProtocol.Factory());
		tArgs.processor(tprocessor);

		TServer server = new TSimpleServer(tArgs);
		return server;
	}

	public static void main(String[] args) {
		TServer server = SimpleServerHolder.buildServer();
		log.info("server ready...");
		server.serve();
	}
}
