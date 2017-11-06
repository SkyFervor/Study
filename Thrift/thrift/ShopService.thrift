include "Common.thrift"

namespace java thrift

struct Shop {
    1: required i32 id,
    2: required string name
}

struct Item {
    1: required i32 id,
    2: required string name = "unknown",
    3: required string detail,
    4: required Shop shop
}

service ShopService extends Common.BaseService {
    Shop queryShopInfo(1: i32 id),
    bool isValidShop(1: Shop shop),
    set<Item> queryItems(1: i32 shopId),
}