/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.ipmessaging.v2.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class User extends Resource {
    private static final long serialVersionUID = 15176818292650L;

    public enum WebhookEnabledType {
        TRUE("true"),
        FALSE("false");

        private final String value;

        private WebhookEnabledType(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a WebhookEnabledType from a string.
         * @param value string value
         * @return generated WebhookEnabledType
         */
        @JsonCreator
        public static WebhookEnabledType forValue(final String value) {
            return Promoter.enumFromString(value, WebhookEnabledType.values());
        }
    }

    /**
     * Create a UserFetcher to execute fetch.
     *
     * @param pathServiceSid The SID of the Service to fetch the resource from
     * @param pathSid The SID of the User resource to fetch
     * @return UserFetcher capable of executing the fetch
     */
    public static UserFetcher fetcher(final String pathServiceSid,
                                      final String pathSid) {
        return new UserFetcher(pathServiceSid, pathSid);
    }

    /**
     * Create a UserDeleter to execute delete.
     *
     * @param pathServiceSid The SID of the Service to delete the resource from
     * @param pathSid The SID of  the User resource to delete
     * @return UserDeleter capable of executing the delete
     */
    public static UserDeleter deleter(final String pathServiceSid,
                                      final String pathSid) {
        return new UserDeleter(pathServiceSid, pathSid);
    }

    /**
     * Create a UserCreator to execute create.
     *
     * @param pathServiceSid The SID of the Service to create the new resource under
     * @param identity The `identity` value that identifies the new resource's User
     * @return UserCreator capable of executing the create
     */
    public static UserCreator creator(final String pathServiceSid,
                                      final String identity) {
        return new UserCreator(pathServiceSid, identity);
    }

    /**
     * Create a UserReader to execute read.
     *
     * @param pathServiceSid The SID of the Service to read the User resources from
     * @return UserReader capable of executing the read
     */
    public static UserReader reader(final String pathServiceSid) {
        return new UserReader(pathServiceSid);
    }

    /**
     * Create a UserUpdater to execute update.
     *
     * @param pathServiceSid The SID of the Service to update the resource from
     * @param pathSid The SID of the User resource to update
     * @return UserUpdater capable of executing the update
     */
    public static UserUpdater updater(final String pathServiceSid,
                                      final String pathSid) {
        return new UserUpdater(pathServiceSid, pathSid);
    }

    /**
     * Converts a JSON String into a User object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return User object represented by the provided JSON
     */
    public static User fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, User.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a User object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return User object represented by the provided JSON
     */
    public static User fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, User.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String serviceSid;
    private final String attributes;
    private final String friendlyName;
    private final String roleSid;
    private final String identity;
    private final Boolean isOnline;
    private final Boolean isNotifiable;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final Integer joinedChannelsCount;
    private final Map<String, String> links;
    private final URI url;

    @JsonCreator
    private User(@JsonProperty("sid")
                 final String sid,
                 @JsonProperty("account_sid")
                 final String accountSid,
                 @JsonProperty("service_sid")
                 final String serviceSid,
                 @JsonProperty("attributes")
                 final String attributes,
                 @JsonProperty("friendly_name")
                 final String friendlyName,
                 @JsonProperty("role_sid")
                 final String roleSid,
                 @JsonProperty("identity")
                 final String identity,
                 @JsonProperty("is_online")
                 final Boolean isOnline,
                 @JsonProperty("is_notifiable")
                 final Boolean isNotifiable,
                 @JsonProperty("date_created")
                 final String dateCreated,
                 @JsonProperty("date_updated")
                 final String dateUpdated,
                 @JsonProperty("joined_channels_count")
                 final Integer joinedChannelsCount,
                 @JsonProperty("links")
                 final Map<String, String> links,
                 @JsonProperty("url")
                 final URI url) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.attributes = attributes;
        this.friendlyName = friendlyName;
        this.roleSid = roleSid;
        this.identity = identity;
        this.isOnline = isOnline;
        this.isNotifiable = isNotifiable;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.joinedChannelsCount = joinedChannelsCount;
        this.links = links;
        this.url = url;
    }

    /**
     * Returns The unique string that identifies the resource.
     *
     * @return The unique string that identifies the resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The SID of the Account that created the resource.
     *
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The SID of the Service that the resource is associated with.
     *
     * @return The SID of the Service that the resource is associated with
     */
    public final String getServiceSid() {
        return this.serviceSid;
    }

    /**
     * Returns The JSON string that stores application-specific data.
     *
     * @return The JSON string that stores application-specific data
     */
    public final String getAttributes() {
        return this.attributes;
    }

    /**
     * Returns The string that you assigned to describe the resource.
     *
     * @return The string that you assigned to describe the resource
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The SID of the Role assigned to the user.
     *
     * @return The SID of the Role assigned to the user
     */
    public final String getRoleSid() {
        return this.roleSid;
    }

    /**
     * Returns The string that identifies the resource's User.
     *
     * @return The string that identifies the resource's User
     */
    public final String getIdentity() {
        return this.identity;
    }

    /**
     * Returns Whether the User is actively connected to the Service instance and
     * online.
     *
     * @return Whether the User is actively connected to the Service instance and
     *         online
     */
    public final Boolean getIsOnline() {
        return this.isOnline;
    }

    /**
     * Returns Whether the User has a potentially valid Push Notification
     * registration for the Service instance.
     *
     * @return Whether the User has a potentially valid Push Notification
     *         registration for the Service instance
     */
    public final Boolean getIsNotifiable() {
        return this.isNotifiable;
    }

    /**
     * Returns The ISO 8601 date and time in GMT when the resource was created.
     *
     * @return The ISO 8601 date and time in GMT when the resource was created
     */
    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The ISO 8601 date and time in GMT when the resource was last updated.
     *
     * @return The ISO 8601 date and time in GMT when the resource was last updated
     */
    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The number of Channels the User is a Member of.
     *
     * @return The number of Channels the User is a Member of
     */
    public final Integer getJoinedChannelsCount() {
        return this.joinedChannelsCount;
    }

    /**
     * Returns The absolute URLs of the Channel and Binding resources related to the
     * user.
     *
     * @return The absolute URLs of the Channel and Binding resources related to
     *         the user
     */
    public final Map<String, String> getLinks() {
        return this.links;
    }

    /**
     * Returns The absolute URL of the User resource.
     *
     * @return The absolute URL of the User resource
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User other = (User) o;

        return Objects.equals(sid, other.sid) &&
               Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(serviceSid, other.serviceSid) &&
               Objects.equals(attributes, other.attributes) &&
               Objects.equals(friendlyName, other.friendlyName) &&
               Objects.equals(roleSid, other.roleSid) &&
               Objects.equals(identity, other.identity) &&
               Objects.equals(isOnline, other.isOnline) &&
               Objects.equals(isNotifiable, other.isNotifiable) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(joinedChannelsCount, other.joinedChannelsCount) &&
               Objects.equals(links, other.links) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            serviceSid,
                            attributes,
                            friendlyName,
                            roleSid,
                            identity,
                            isOnline,
                            isNotifiable,
                            dateCreated,
                            dateUpdated,
                            joinedChannelsCount,
                            links,
                            url);
    }
}