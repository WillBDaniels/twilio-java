/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.serverless.v1.service.asset;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class AssetVersionCreator extends Creator<AssetVersion> {
    private final String pathServiceSid;
    private final String pathAssetSid;
    private final String path;
    private final AssetVersion.Visibility visibility;

    /**
     * Construct a new AssetVersionCreator.
     * 
     * @param pathServiceSid The service_sid
     * @param pathAssetSid The asset_sid
     * @param path The path
     * @param visibility The visibility
     */
    public AssetVersionCreator(final String pathServiceSid, 
                               final String pathAssetSid, 
                               final String path, 
                               final AssetVersion.Visibility visibility) {
        this.pathServiceSid = pathServiceSid;
        this.pathAssetSid = pathAssetSid;
        this.path = path;
        this.visibility = visibility;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created AssetVersion
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public AssetVersion create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.SERVERLESS.toString(),
            "/v1/Services/" + this.pathServiceSid + "/Assets/" + this.pathAssetSid + "/Versions",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("AssetVersion creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return AssetVersion.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (path != null) {
            request.addPostParam("Path", path);
        }

        if (visibility != null) {
            request.addPostParam("Visibility", visibility.toString());
        }
    }
}