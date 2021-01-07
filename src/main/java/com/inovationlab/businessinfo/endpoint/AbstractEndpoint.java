package com.inovationlab.businessinfo.endpoint;

import org.springframework.http.ResponseEntity;

import java.util.Collections;

public abstract class AbstractEndpoint {
    protected final <T> ResponseEntity<T> getResponseEntity(T data) {
        return ResponseEntity.ok(data);
    }

    protected final ResponseEntity<?> getOkResponseEntity() {
        return ResponseEntity.ok(Collections.singletonMap("code", 200));
    }
}
