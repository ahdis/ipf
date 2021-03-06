/*
 * Copyright 2011 the original author or authors.
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
package org.openehealth.ipf.platform.camel.ihe.mllp.core.mbean;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.ErrorCode;
import ca.uhn.hl7v2.Version;
import org.openehealth.ipf.commons.ihe.hl7v2.Hl7v2TransactionConfiguration;
import org.openehealth.ipf.commons.ihe.hl7v2.NakFactory;
import org.openehealth.ipf.commons.ihe.hl7v2.audit.MllpAuditDataset;
import org.openehealth.ipf.platform.camel.ihe.mllp.core.MllpTransactionComponent;

/**
 * Test MLLP Component implementation
 */
public class SomeMllpItiComponent extends MllpTransactionComponent<MllpAuditDataset> {
    
    private static final Hl7v2TransactionConfiguration<MllpAuditDataset> CONFIGURATION =
        new Hl7v2TransactionConfiguration<>(
                "foo",
                "Some MLLP Component",
                false,
                null,
                null,
                new Version[] {Version.V25},
                "Some MLLP adapter",
                "IPF-Test",
                ErrorCode.APPLICATION_INTERNAL_ERROR,
                ErrorCode.APPLICATION_INTERNAL_ERROR,
                new String[] { "ADT" },
                new String[] { "A01 A04" },
                new String[] { "ACK" },
                new String[] { "*" },
                new boolean[] { true },
                new boolean[] { false },
                new DefaultHapiContext());

    public SomeMllpItiComponent() {
        super(null);
    }

    private static final NakFactory<MllpAuditDataset> NAK_FACTORY = new NakFactory<>(CONFIGURATION);

    @Override
    public NakFactory<MllpAuditDataset> getNakFactory() {
        return NAK_FACTORY;
    }
    
    @Override
    public Hl7v2TransactionConfiguration<MllpAuditDataset> getHl7v2TransactionConfiguration() {
        return CONFIGURATION;
    }
    
}
