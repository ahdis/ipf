/*
 * Copyright 2009 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openehealth.ipf.commons.ihe.xds.core.requests.query;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.Map;

/**
 * Base class for stored queries.
 * @author Jens Riemschneider
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StoredQuery", propOrder = {"homeCommunityId", "extraParameters"})
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, doNotUseGetters = true)
public abstract class StoredQuery extends Query {
    private static final long serialVersionUID = -8296981156625412818L;

    @Getter @Setter private String homeCommunityId;
    @Getter private Map<String, QueryList<String>> extraParameters = new HashMap<>();

    /**
     * For JAXB serialization only.
     */
    public StoredQuery() {
    }

    /**
     * Constructs the query.
     * @param type
     *          the type of the query.
     */
    protected StoredQuery(QueryType type) {
        super(type);
    }

}
