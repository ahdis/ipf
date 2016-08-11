/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openehealth.ipf.boot.fhir;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.core.io.Resource;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@ConfigurationProperties(prefix = "ipf.fhir")
public class IpfFhirConfigurationProperties {

    @NestedConfigurationProperty
    @Getter
    private final Servlet servlet = new Servlet();

    /**
     * Path that serves as the base URI for the FHIR services.
     */
    @NotNull
    @Getter @Setter
    @Pattern(regexp = "/[^?#]*", message = "Path must start with /")
    private String path = "/fhir";

    /**
     * Resource containing mappings from FHIR URIs to OIds and namespaces
     */
    @NotNull(message = "Must provide a NamingSystems resource")
    @Getter @Setter
    private Resource identifierNamingSystems;

    /**
     * Whether to create a cached PagingProvider
     */
    @Getter @Setter
    private boolean caching;

    String getFhirMapping() {
        String path = getPath();
        return path.endsWith("/") ? path + "*" : path + "/*";
    }

    public static class Servlet {

        /**
         * Servlet init parameters to pass to the FHIR Servlet.
         */
        @Getter @Setter
        private Map<String, String> init = new HashMap<>();

        /**
         * Load on startup priority of the FHIR servlet.
         */
        @Getter @Setter
        private int loadOnStartup = 1;

        /**
         * Name of the servlet
         */
        @Getter @Setter
        private String name = "FhirServlet";

        /**
         * Number of concurrent paging requests that can be handled
         */
        @Getter @Setter
        private int pagingRequests = 50;

        /**
         * Default number of result entries to be returned if no _count parameter is specified in a search
         */
        @Getter @Setter
        private int defaultPageSize = 50;

        /**
         * Maximum number of result entries to be returned even if the _count parameter of a search demands for more
         */
        @Getter @Setter
        private int maxPageSize = 100;

        /**
         * Whether the Paging Provider cache is expected to be distributed, so that serialization of result
         * bundles is necessary. In this case, FHIR endpoints must not use lazy-loading of results.
         */
        @Getter @Setter
        private boolean distributedPagingProvider = false;

        /**
         * Enable server-side request logging
         */
        @Getter @Setter
        private boolean logging = false;

        /**
         * Enable pretty-printing responses
         */
        @Getter @Setter
        private boolean prettyPrint = true;

        /**
         * Enable color-coding responses queried from a Web Browser
         */
        @Getter @Setter
        private boolean responseHighlighting = true;
    }
}
