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
package org.openehealth.ipf.commons.ihe.xds.core.audit;

import org.apache.cxf.wsdl.EndpointReferenceUtils;
import org.openehealth.ipf.commons.ihe.atna.AuditDataset;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLRegistryPackage;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLSubmitObjectsRequest;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Vocabulary;

import java.util.List;

/**
 * A data structure used to store information pieces collected by various
 * auditing-related CXF interceptors.
 * @author Dmytro Rud
 */
public class XdsAuditDataset extends AuditDataset {

    // SOAP Body (XML) payload
    private String payload;
    // client user ID (WS-Addressing <Reply-To> header)
    private String userId;
    // client user name (WS-Security <Username> header)
    private String userName;
    // client IP address
    private String clientIpAddress;
    // service (i.e. registry or repository) endpoint URL
    private String serviceEndpointUrl;
    // patient ID as HL7 CX datatype, e.g. "1234^^^&1.2.3.4&ISO"
    private String patientId;
    // submission set unique ID
    private String submissionSetUuid;

    /**
     * Constructor.
     * 
     * @param serverSide
     *            specifies whether this audit dataset will be used on the
     *            server side (<code>true</code>) or on the client side (
     *            <code>false</code>)
     */
    public XdsAuditDataset(boolean serverSide) {
        super(serverSide);
    }

    /**
     * Sets the SOAP Body (XML) payload.
     * @param payload
     *          SOAP Body (XML) payload.
     */
    public void setPayload(String payload) {
        this.payload = payload;
    }

    /**
     * @return SOAP Body (XML) payload.
     */
    public String getPayload() {
        return payload;
    }

    /**
     * Sets the client user ID (WS-Addressing <Reply-To> header).
     * @param userId
     *          client user ID (WS-Addressing <Reply-To> header).
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Returns User ID.
     * <p>
     * When the user ID could not be extracted from WS-Addressing header
     * &lt;ReplyTo&gt;, the special "WS-Addressing anonymous address" 
     * will be returned, as prescribed in 
     * http://www.w3.org/TR/2006/REC-ws-addr-soap-20060509/#anonaddress
     * @return client user ID (WS-Addressing <Reply-To> header).
     */
    public String getUserId() {
        return (userId != null) ? userId : EndpointReferenceUtils.ANONYMOUS_ADDRESS;
    }

    /**
     * Sets the client user name (WS-Security <Username> header).
     * @param userName
     *          client user name (WS-Security <Username> header).
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return client user name (WS-Security <Username> header).
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the client IP address
     * @param clientIpAddress
     *          client IP address.
     */
    public void setClientIpAddress(String clientIpAddress) {
        this.clientIpAddress = clientIpAddress;
    }

    /**
     * @return client IP address.
     */
    public String getClientIpAddress() {
        return clientIpAddress;
    }

    /**
     * Sets the service (i.e. registry or repository) endpoint URL.
     * @param serviceEntpointUrl
     *          service (i.e. registry or repository) endpoint URL.
     */
    public void setServiceEndpointUrl(String serviceEntpointUrl) {
        serviceEndpointUrl = serviceEntpointUrl;
    }

    /**
     * @return service (i.e. registry or repository) endpoint URL.
     */
    public String getServiceEndpointUrl() {
        return serviceEndpointUrl;
    }

    /**
     * Sets the patient ID as HL7 CX datatype, e.g. "1234^^^&1.2.3.4&ISO"
     * @param patientId
     *          patient ID as HL7 CX datatype, e.g. "1234^^^&1.2.3.4&ISO".
     */
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    /**
     * @return patient ID as HL7 CX datatype, e.g. "1234^^^&1.2.3.4&ISO".
     */
    public String getPatientId() {
        return patientId;
    }

    /**
     * Sets the submission set unique ID.
     * @param submissionSetUuid
     *          submission set unique ID.
     */
    public void setSubmissionSetUniqueID(String submissionSetUuid) {
        this.submissionSetUuid = submissionSetUuid;
    }

    /**
     * @return submission set unique ID.
     */
    public String getSubmissionSetUuid() {
        return submissionSetUuid;
    }

    /**
     * Enriches the set with fields extracted from a submit objects request POJO.
     * 
     * @param ebXML
     *      a {@link EbXMLSubmitObjectsRequest} as POJO 
     */
    public void enrichDatasetFromSubmitObjectsRequest(EbXMLSubmitObjectsRequest ebXML) 
    {
        List<EbXMLRegistryPackage> submissionSets = 
            ebXML.getRegistryPackages(Vocabulary.SUBMISSION_SET_CLASS_NODE);
        
        for (EbXMLRegistryPackage submissionSet : submissionSets) {
            String patientID = submissionSet.getExternalIdentifierValue(
                    Vocabulary.SUBMISSION_SET_PATIENT_ID_EXTERNAL_ID);            
            setPatientId(patientID);
            
            String uniqueID = submissionSet.getExternalIdentifierValue(
                    Vocabulary.SUBMISSION_SET_UNIQUE_ID_EXTERNAL_ID);
            setSubmissionSetUniqueID(uniqueID);
        }
    }
}