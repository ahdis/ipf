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
package org.openehealth.ipf.platform.camel.ihe.mllp.iti10

import org.apache.camel.builder.RouteBuilder

import static org.openehealth.ipf.platform.camel.hl7.HL7v2.*


/**
 * Camel route for generic unit tests.
 * @author Dmytro Rud
 */
class Iti10TestRouteBuilder extends RouteBuilder {

     void configure() throws Exception {

         from('pix-iti10://0.0.0.0:18107?audit=false')
             .onException(Exception.class)
                 .maximumRedeliveries(0)
                 .end()
             .process(validatingProcessor())
             .transform(ack())

             //.process(iti10ResponseValidator())

             
         from('pix-iti10://0.0.0.0:18108')
             .onException(Exception.class)
                 .maximumRedeliveries(0)
                 .end()
             .transform(ack())
     }
}
 
