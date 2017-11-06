package service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import thrift.Item;
import thrift.Shop;
import thrift.ShopService;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class ShopServiceImpl implements ShopService.Iface {

	@Override
	public Shop queryShopInfo(int id) throws TException {
		return new Shop(id, "DMC_".concat(String.valueOf(id)));
	}

	@Override
	public boolean isValidShop(Shop shop) throws TException {
		return shop != null;
	}

	@Override
	public Set<Item> queryItems(int shopId) throws TException {
		if (shopId < 1) {
			return Collections.emptySet();
		}

		Set<Item> items = new HashSet<>();
		Shop shop = new Shop(1101, "DMC");
		for (int i = 0; i < 8; i++) {
			Item item = new Item(shopId + i, "sample_".concat(String.valueOf(shopId + i)),
					"this is sample_".concat(String.valueOf(i)),
					shop);
			items.add(item);
		}
		return items;
	}

	@Override
	public String echoServiceName() throws TException {
		return "alo! this is shop service!";
	}
}
