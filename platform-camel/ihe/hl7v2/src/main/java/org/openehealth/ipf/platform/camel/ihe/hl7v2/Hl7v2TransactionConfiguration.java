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
package org.openehealth.ipf.platform.camel.ihe.hl7v2;

import ca.uhn.hl7v2.ErrorCode;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.Version;

/**
 * Endpoint-agnostic parameters of an HL7v2-based transaction.
 *
 * @author Dmytro Rud
 *
 * @deprecated moved to {@link org.openehealth.ipf.commons.ihe.hl7v2.Hl7v2TransactionConfiguration}
 */
public class Hl7v2TransactionConfiguration extends org.openehealth.ipf.commons.ihe.hl7v2.Hl7v2TransactionConfiguration {

    public Hl7v2TransactionConfiguration(Version[] hl7Versions, String sendingApplication,
                                         String sendingFacility, ErrorCode requestErrorDefaultErrorCode,
                                         ErrorCode responseErrorDefaultErrorCode, String[] allowedRequestMessageTypes,
                                         String[] allowedRequestTriggerEvents, String[] allowedResponseMessageTypes,
                                         String[] allowedResponseTriggerEvents, boolean[] auditabilityFlags,
                                         boolean[] responseContinuabilityFlags, HapiContext hapiContext) {
        super(hl7Versions, sendingApplication, sendingFacility, requestErrorDefaultErrorCode, responseErrorDefaultErrorCode, allowedRequestMessageTypes, allowedRequestTriggerEvents, allowedResponseMessageTypes, allowedResponseTriggerEvents, auditabilityFlags, responseContinuabilityFlags, hapiContext);
    }
}

