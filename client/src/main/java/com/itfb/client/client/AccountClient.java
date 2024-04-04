package com.itfb.client.client;

import com.itfb.common.protocol.AccountProtocol;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="account", url="localhost:8002")
public interface AccountClient extends AccountProtocol {
}
