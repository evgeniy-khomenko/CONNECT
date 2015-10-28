/*
 * Copyright (c) 2009-2015, United States Government, as represented by the Secretary of Health and Human Services.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above
 *       copyright notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the documentation
 *       and/or other materials provided with the distribution.
 *     * Neither the name of the United States Government nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE UNITED STATES GOVERNMENT BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package gov.hhs.fha.nhinc.docsubmission.audit.transform;

import com.services.nhinc.schema.auditmessage.AuditMessageType;
import gov.hhs.fha.nhinc.common.nhinccommon.AssertionType;
import gov.hhs.fha.nhinc.docsubmission.audit.DocSubmissionAuditTransformsConstants;
import ihe.iti.xds_b._2007.ProvideAndRegisterDocumentSetRequestType;
import oasis.names.tc.ebxml_regrep.xsd.rs._3.RegistryResponseType;

/**
 * Document Submission audit transforms to support DS audit logging.
 *
 * @author tjafri
 */
public class DocSubmissionAuditTransforms extends AbstractDocSubmissionAuditTransforms<
    ProvideAndRegisterDocumentSetRequestType, RegistryResponseType> {

    @Override
    protected AuditMessageType getParticipantObjectIdentificationForRequest(
        ProvideAndRegisterDocumentSetRequestType request, AssertionType assertion, AuditMessageType auditMsg) {
        // PatientParticipantObjetIdentification  and SubmissionSetParticipantObjetIdentification is same for both
        //Request and Response in case of DS
        auditMsg = getPatientParticipantObjectIdentification(request, auditMsg);
        auditMsg = getSubmissionSetParticipantObjectIdentification(request, auditMsg);
        return auditMsg;
    }

    @Override
    protected AuditMessageType getParticipantObjectIdentificationForResponse(
        ProvideAndRegisterDocumentSetRequestType request, RegistryResponseType response, AssertionType assertion,
        AuditMessageType auditMsg) {
        // PatientParticipantObjetIdentification  and SubmissionSetParticipantObjetIdentification is same for both
        //Request and Response in case of DS
        auditMsg = getPatientParticipantObjectIdentification(request, auditMsg);
        auditMsg = getSubmissionSetParticipantObjectIdentification(request, auditMsg);
        return auditMsg;
    }

    @Override
    protected String getServiceEventIdCodeRequestor() {
        return DocSubmissionAuditTransformsConstants.EVENT_ID_CODE_DS_SOURCE;
    }

    @Override
    protected String getServiceEventIdCodeResponder() {
        return DocSubmissionAuditTransformsConstants.EVENT_ID_CODE_DS_RECIPIENT;
    }

    @Override
    protected String getServiceEventCodeSystem() {
        return DocSubmissionAuditTransformsConstants.EVENT_ID_CODE_SYSTEM;
    }

    @Override
    protected String getServiceEventDisplayRequestor() {
        return DocSubmissionAuditTransformsConstants.EVENT_ID_DISPLAY_SOURCE;
    }

    @Override
    protected String getServiceEventDisplayResponder() {
        return DocSubmissionAuditTransformsConstants.EVENT_ID_DISPLAY_RECIPIENT;
    }

    @Override
    protected String getServiceEventTypeCode() {
        return DocSubmissionAuditTransformsConstants.EVENT_TYPE_CODE;
    }

    @Override
    protected String getServiceEventTypeCodeSystem() {
        return DocSubmissionAuditTransformsConstants.EVENT_TYPE_CODE_SYSTEM;
    }

    @Override
    protected String getServiceEventTypeCodeDisplayName() {
        return DocSubmissionAuditTransformsConstants.EVENT_TYPE_CODE_DISPLAY_NAME;
    }

    @Override
    protected String getServiceEventActionCodeRequestor() {
        return DocSubmissionAuditTransformsConstants.EVENT_ACTION_CODE_SOURCE;
    }

    @Override
    protected String getServiceEventActionCodeResponder() {
        return DocSubmissionAuditTransformsConstants.EVENT_ACTION_CODE_RECIPIENT;
    }
}