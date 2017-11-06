package client;

import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import thrift.Item;
import thrift.ShopService;

import java.util.Set;

@Slf4j
public class SimpleClientHolder {

	private TTransport transport;

	public ShopService.Client buildClient(String serverAddr, int serverPort, int timeout) throws TTransportException {
		this.transport = new TSocket(serverAddr, serverPort, timeout);
		TProtocol protocol = new TCompactProtocol(transport);
		transport.open();

		ShopService.Client client = new ShopService.Client(protocol);
		return client;
	}

	public static void main(String[] args) {
		SimpleClientHolder simpleClientHolder = new SimpleClientHolder();
		ShopService.Client client = null;
		try {
			client = simpleClientHolder.buildClient("localhost", 8081, 1000);
			Set<Item> items = client.queryItems(666);
			log.info("return items = {}", String.valueOf(items));
		} catch (TException e) {
			e.printStackTrace();
		}

		if (null != simpleClientHolder.transport) {
			simpleClientHolder.transport.close();
		}
	}
}
