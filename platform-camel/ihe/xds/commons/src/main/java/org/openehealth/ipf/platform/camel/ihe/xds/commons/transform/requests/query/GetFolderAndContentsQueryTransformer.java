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
package org.openehealth.ipf.platform.camel.ihe.xds.commons.transform.requests.query;

import static org.openehealth.ipf.platform.camel.ihe.xds.commons.transform.requests.QueryParameter.*;

import org.openehealth.ipf.platform.camel.ihe.xds.commons.ebxml.EbXMLAdhocQueryRequest;
import org.openehealth.ipf.platform.camel.ihe.xds.commons.requests.query.GetFolderAndContentsQuery;
import org.openehealth.ipf.platform.camel.ihe.xds.commons.requests.query.GetSubmissionSetAndContentsQuery;

/**
 * Transforms between a {@link GetSubmissionSetAndContentsQuery} and {@link EbXMLAdhocQueryRequest}.
 * @author Jens Riemschneider
 */
public class GetFolderAndContentsQueryTransformer extends GetByIDAndCodesQueryTransformer<GetFolderAndContentsQuery> {
    /**
     * Constructs the transformer.
     */
    public GetFolderAndContentsQueryTransformer() {
        super(FOLDER_UUID, 
                FOLDER_UNIQUE_ID, 
                DOC_ENTRY_FORMAT_CODE, 
                DOC_ENTRY_FORMAT_CODE_SCHEME, 
                DOC_ENTRY_CONFIDENTIALITY_CODE,
                DOC_ENTRY_CONFIDENTIALITY_CODE_SCHEME);
    }
}
