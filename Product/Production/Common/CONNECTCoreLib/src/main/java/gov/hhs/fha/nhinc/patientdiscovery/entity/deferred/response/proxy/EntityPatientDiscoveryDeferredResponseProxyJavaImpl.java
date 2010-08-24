package gov.hhs.fha.nhinc.patientdiscovery.entity.deferred.response.proxy;

import gov.hhs.fha.nhinc.common.nhinccommon.AssertionType;
import gov.hhs.fha.nhinc.common.nhinccommon.NhinTargetCommunitiesType;
import gov.hhs.fha.nhinc.patientdiscovery.entity.deferred.response.EntityPatientDiscoveryDeferredResponseOrchImpl;
import org.hl7.v3.MCCIIN000002UV01;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hl7.v3.PRPAIN201306UV02;

/**
 *
 * @author dunnek
 */
public class EntityPatientDiscoveryDeferredResponseProxyJavaImpl implements EntityPatientDiscoveryDeferredResponseProxy
{

    private static Log log = null;

    public EntityPatientDiscoveryDeferredResponseProxyJavaImpl()
    {
        log = createLogger();
    }

    protected Log createLogger()
    {
        return LogFactory.getLog(getClass());
    }

    public MCCIIN000002UV01 processPatientDiscoveryAsyncResp(PRPAIN201306UV02 body, AssertionType assertion, NhinTargetCommunitiesType target)
    {
        log.debug("Begin EntityPatientDiscoveryDeferredResponseProxyJavaImpl.processPatientDiscoveryAsyncResp(...)");

        return getEntityImpl().processPatientDiscoveryAsyncRespOrch(body, assertion, target);

    }

    protected EntityPatientDiscoveryDeferredResponseOrchImpl getEntityImpl()
    {
        return new EntityPatientDiscoveryDeferredResponseOrchImpl();
    }
}
