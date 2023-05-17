/*
 * Copyright Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */

package io.strimzi.kafka.bridge.quarkus;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Exception mapper providing a proper {@link Response} whenever a {@link RestBridgeException} is raised during
 * the HTTP request handling. The exception brings an {@link io.strimzi.kafka.bridge.quarkus.beans.Error}
 * containing the HTTP code and error message to use in the response.
 */
@Provider
public class RestBridgeExceptionMapper implements ExceptionMapper<RestBridgeException> {

    @Override
    public Response toResponse(RestBridgeException exception) {
        return RestUtils.buildResponseFromError(exception.getHttpBridgeError());
    }
}
