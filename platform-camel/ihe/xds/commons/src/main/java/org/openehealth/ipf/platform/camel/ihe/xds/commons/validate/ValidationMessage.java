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
package org.openehealth.ipf.platform.camel.ihe.xds.commons.validate;

import org.openehealth.ipf.platform.camel.ihe.xds.commons.responses.ErrorCode;

/**
 * All error messages that can occur during validation.
 * @author Jens Riemschneider
 */
public enum ValidationMessage {
    FOLDER_INVALID_AVAILABILITY_STATUS("Invalid availability status for a folder: %1s"),
    SUBMISSION_SET_INVALID_AVAILABILITY_STATUS("Invalid availability status for a submission set: %1s"),
    DOC_ENTRY_INVALID_AVAILABILITY_STATUS("Invalid availability status for a document entry: %1s"),
    EXACTLY_ONE_SUBMISSION_SET_MUST_EXIST("Exactly one submission set must be specified"),
    INVALID_TITLE_ENCODING("Invalid encoding for document entry title: %1s"),
    TITLE_TOO_LONG("Document entry title too long: %1s"),
    UNIQUE_ID_MISSING("Document entries, folders and submission sets are required to define a unique ID"),
    UNIQUE_ID_TOO_LONG("Unique IDs must not be longer than 64 characters"),
    UNIQUE_ID_NOT_UNIQUE("Duplicate ID found"),
    UUID_NOT_UNIQUE("Duplicate UUID found"),
    DOC_ENTRY_PATIENT_ID_WRONG("Document entry and submission set must define the same patient ID", ErrorCode.PATIENT_ID_DOES_NOT_MATCH),
    FOLDER_PATIENT_ID_WRONG("Folder and submission set must define the same patient ID", ErrorCode.PATIENT_ID_DOES_NOT_MATCH),
    INVALID_ASSOCIATION_TYPE("Unsupported association type"),
    TOO_MANY_SUBMISSION_SET_STATES("Exactly one submission set status must be defined for each association involving a document entry as its source"),
    INVALID_SUBMISSION_SET_STATUS("Association specifies an unknown submission set status label"),
    MISSING_ORIGINAL("Association specifies an original document entry, but it was not provided"),
    SOURCE_UUID_NOT_FOUND("The source of an association for a document relationship did not specify a valid UUID of a document entry contained in the request"),
    WRONG_NUMBER_OF_CLASSIFICATIONS("Unexpected amount of classifications of scheme %1s, allowed = [%2s-%3s], Was = %4s"),
    NO_CLASSIFIED_OBJ("Classification does not classify any object: %1s"),
    WRONG_CLASSIFIED_OBJ("Classification does not classify expected object: %1s, Was = %2s"),
    WRONG_NODE_REPRESENTATION("Classification does not specify its node representation. Scheme = %1s"),
    CX_TOO_MANY_COMPONENTS("Only the ID number and the assigning authority can be definied for a CX value"),
    CX_NEEDS_ID("ID number must be specified for a CX value"),
    HD_MUST_NOT_HAVE_NAMESPACE_ID("The namespace ID should not be defined for an assigning authority: %1s"),
    UNIVERSAL_ID_TYPE_MUST_BE_ISO("The universal ID type of an assigning authority must be ISO: %1s"),
    HD_NEEDS_UNIVERSAL_ID("The universal ID must be defined for an assigning authority: %1s"),
    MISSING_EXTERNAL_IDENTIFIER("External identifier value is missing: %1s"),
    INVALID_HASH_CODE("Invalid format of hash code: %1s"),
    INVALID_LANGUAGE_CODE("Invalid format of language code: %1s"),
    OID_TOO_LONG("OID must not be longer than 64 characters: %1s"),
    INVALID_OID("OID contains invalid characters: %1s"),
    INVALID_PID("Invalid PID format: %1s"),
    UNSUPPORTED_PID("PID number not supported in XDS: %1s"),
    INVALID_NUMBER_FORMAT("Invalid number format: %1s"),
    RECIPIENT_LIST_EMPTY("Recipient list should not be empty"),
    RECIPIENT_EMPTY("Recipient list value should not be empty"),
    INVALID_RECIPIENT("Invalid format of recipient list element: %1s"),
    SLOT_VALUE_TOO_LONG("Slot value length exceeds ebXML limit in slot: %1s"),
    WRONG_NUMBER_OF_SLOT_VALUES("Slot contains incorrect amount of values. Slot = %1s, allowed = [%2s-%3s], Was = %4s"),
    EMPTY_SLOT_VALUE("Slot value is undefined. Slot = %1s"),
    INVALID_TIME("Invalid time format: %1s"),
    NULL_URI("URI slot did not contain a value"),
    EMPTY_URI("Empty URI although slot is specified"),
    INVALID_URI("Invalid URI: %1s"),
    NULL_URI_PART("A URI part did not contain a value"),
    INVALID_URI_PART("Invalid URI part syntax: %1s"),
    MISSING_URI_PART("Missing URI part with index: %1s"),
    PERSON_MISSING_NAME_AND_ID("Either an id number or a name has to be specified for a person: %1s"),
    PERSON_HD_MISSING("If an id number is specified for a person, the assigning authority has to be specified as well: %1s"),
    ORGANIZATION_NAME_MISSING("An organization name has to be specified for an organization: %1s"),
    ORGANIZATION_TOO_MANY_COMPONENTS("An organization should not specify data other than its ID and name"),
    MISSING_DOC_ENTRY_FOR_DOCUMENT("A document was provided without a corresponding document entry. UUID=%1s", ErrorCode.MISSING_DOCUMENT_METADATA),
    MISSING_DOCUMENT_FOR_DOC_ENTRY("A document entry was provided without a corresponding document. UUID=%1s", ErrorCode.MISSING_DOCUMENT),
    UNKNOWN_QUERY_TYPE("Unknown query type: %1s"),
    MISSING_SQL_QUERY_TEXT("Missing SQL query text"),
    UNKNOWN_RETURN_TYPE("Unknown return type: %1s"),
    MISSING_REQUIRED_QUERY_PARAMETER("Missing required query parameter: %1s"),
    INVALID_QUERY_PARAMETER_VALUE("Invalid value for query parameter: %1s"),
    QUERY_PARAMETERS_CANNOT_BE_SET_TOGETHER("Query contains parameters that are mutually exclusive to each other: %1s"),
    TOO_MANY_VALUES_FOR_QUERY_PARAMETER("Too many values for query parameter: %1s"),
    PARAMETER_VALUE_NOT_STRING("Query parameter value is not specified as a string: %1s"),
    PARAMETER_VALUE_NOT_STRING_LIST("Query parameter value is not specified as a list of strings: %1s"),
    REPO_ID_MUST_BE_SPECIFIED("The repository Unique ID is missing"),
    DOC_ID_MUST_BE_SPECIFIED("The document Unique ID is missing"),
    INVALID_STATUS_IN_RESPONSE("Invalid status in response"),
    INVALID_ERROR_INFO_IN_RESPONSE("Invalid error info in response"),
    INVALID_ERROR_CODE_IN_RESPONSE("Invalid error code in response"),
    INVALID_SEVERITY_IN_RESPONSE("Invalid severity in response"),
    MISSING_OBJ_REF("Missing object reference"),
    DEPRECATED_OBJ_CANNOT_BE_TRANSFORMED("A deprecated entry cannot be transformed or appended", ErrorCode.REGISTRY_DEPRECATED_DOCUMENT_ERROR);
    
    private final String text;
    private final ErrorCode errorCode;
    
    private ValidationMessage(String text, ErrorCode errorCode) {
        this.text = text;
        this.errorCode = errorCode;
    }

    private ValidationMessage(String text) {
        this.text = text;
        this.errorCode = null;
    }

    public String getText() {
        return text;
    }
    
    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
