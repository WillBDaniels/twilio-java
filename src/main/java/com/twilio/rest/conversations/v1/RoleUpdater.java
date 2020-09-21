/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.conversations.v1;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.util.List;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class RoleUpdater extends Updater<Role> {
    private final String pathSid;
    private final List<String> permission;

    /**
     * Construct a new RoleUpdater.
     *
     * @param pathSid The SID of the Role resource to update
     * @param permission A permission the role should have
     */
    public RoleUpdater(final String pathSid,
                       final List<String> permission) {
        this.pathSid = pathSid;
        this.permission = permission;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Updated Role
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Role update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.CONVERSATIONS.toString(),
            "/v1/Roles/" + this.pathSid + ""
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Role update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Role.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (permission != null) {
            for (String prop : permission) {
                request.addPostParam("Permission", prop);
            }
        }
    }
}