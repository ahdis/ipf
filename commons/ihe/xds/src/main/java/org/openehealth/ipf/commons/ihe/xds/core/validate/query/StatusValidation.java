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
package org.openehealth.ipf.commons.ihe.xds.core.validate.query;

import static org.apache.commons.lang3.Validate.notNull;
import static org.openehealth.ipf.commons.ihe.xds.core.validate.ValidationMessage.INVALID_QUERY_PARAMETER_VALUE;
import static org.openehealth.ipf.commons.ihe.xds.core.validate.ValidationMessage.MISSING_REQUIRED_QUERY_PARAMETER;
import static org.openehealth.ipf.commons.ihe.xds.core.validate.ValidationMessage.PARAMETER_VALUE_NOT_STRING_LIST;
import static org.openehealth.ipf.commons.ihe.xds.core.validate.ValidatorAssertions.metaDataAssert;

import java.util.List;
import java.util.regex.Pattern;

import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLAdhocQueryRequest;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.QueryParameter;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.query.QuerySlotHelper;
import org.openehealth.ipf.commons.ihe.xds.core.validate.XDSMetaDataException;

/**
 * Query parameter validation for parameters that are AvailabilityStatus-based.
 * @author Jens Riemschneider
 */
public class StatusValidation implements QueryParameterValidation {
    private static final Pattern PATTERN =
            Pattern.compile("\\s*\\(\\s*'.*'(\\s*,\\s*'.*')*\\s*\\)\\s*");

    private final QueryParameter param;

    /**
     * Constructs a validation object.
     * @param param
     *          parameter to validate.
     */
    public StatusValidation(QueryParameter param) {
        notNull(param, "param cannot be null");
        this.param = param;
    }

    @Override
    public void validate(EbXMLAdhocQueryRequest request) throws XDSMetaDataException {
        List<String> slotValues = request.getSlotValues(param.getSlotName());
        metaDataAssert(!slotValues.isEmpty(), MISSING_REQUIRED_QUERY_PARAMETER, slotValues);
        for (String slotValue : slotValues) {
            metaDataAssert(slotValue != null, MISSING_REQUIRED_QUERY_PARAMETER, param);
            metaDataAssert(PATTERN.matcher(slotValue).matches(),
                    PARAMETER_VALUE_NOT_STRING_LIST, param);
        }

        QuerySlotHelper slots = new QuerySlotHelper(request);

        List<AvailabilityStatus> list = slots.toStatus(param);

        if (list != null && list.isEmpty()) {
            for (String value : slots.toStringList(param)) {
                metaDataAssert(AvailabilityStatus.valueOfOpcode(value) != null, INVALID_QUERY_PARAMETER_VALUE, value);
            }
        }
        metaDataAssert(!list.isEmpty(), MISSING_REQUIRED_QUERY_PARAMETER, slotValues);

    }
}
