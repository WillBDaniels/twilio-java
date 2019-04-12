/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.serverless.v1.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.Twilio;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.TwilioException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static com.twilio.TwilioTest.serialize;
import static org.junit.Assert.*;

public class BuildTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @Before
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.SERVERLESS.toString(),
                                          "/v1/Services/ZSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Builds");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Build.reader("ZSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").read();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testReadEmptyResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"builds\": [],\"meta\": {\"first_page_url\": \"https://serverless.twilio.com/v1/Services/ZS00000000000000000000000000000000/Builds?PageSize=50&Page=0\",\"key\": \"builds\",\"next_page_url\": null,\"page\": 0,\"page_size\": 50,\"previous_page_url\": null,\"url\": \"https://serverless.twilio.com/v1/Services/ZS00000000000000000000000000000000/Builds?PageSize=50&Page=0\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Build.reader("ZSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").read());
    }

    @Test
    public void testFetchRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.SERVERLESS.toString(),
                                          "/v1/Services/ZSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Builds/ZBXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Build.fetcher("ZSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "ZBXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"ZB00000000000000000000000000000000\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"ZS00000000000000000000000000000000\",\"asset_versions\": [{\"sid\": \"ZN00000000000000000000000000000000\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"ZS00000000000000000000000000000000\",\"asset_sid\": \"ZH00000000000000000000000000000000\",\"date_created\": \"2018-11-10T20:00:00Z\",\"path\": \"asset-path\",\"visibility\": \"PUBLIC\"}],\"function_versions\": [{\"sid\": \"ZN00000000000000000000000000000001\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"ZS00000000000000000000000000000000\",\"function_sid\": \"ZH00000000000000000000000000000001\",\"date_created\": \"2018-11-10T20:00:00Z\",\"path\": \"function-path\",\"visibility\": \"PUBLIC\"}],\"dependencies\": [{\"name\": \"twilio\",\"version\": \"3.6.3\"}],\"status\": \"deploying\",\"date_created\": \"2018-11-10T20:00:00Z\",\"date_updated\": \"2018-11-10T20:00:00Z\",\"url\": \"https://serverless.twilio.com/v1/Services/ZS00000000000000000000000000000000/Builds/ZB00000000000000000000000000000000\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Build.fetcher("ZSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "ZBXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch());
    }

    @Test
    public void testCreateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.SERVERLESS.toString(),
                                          "/v1/Services/ZSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Builds");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Build.creator("ZSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").create();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testCreateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"ZB00000000000000000000000000000000\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"ZS00000000000000000000000000000000\",\"asset_versions\": [{\"sid\": \"ZN00000000000000000000000000000000\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"ZS00000000000000000000000000000000\",\"asset_sid\": \"ZH00000000000000000000000000000000\",\"date_created\": \"2018-11-10T20:00:00Z\",\"path\": \"asset-path\",\"visibility\": \"PUBLIC\"}],\"function_versions\": [{\"sid\": \"ZN00000000000000000000000000000001\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"ZS00000000000000000000000000000000\",\"function_sid\": \"ZH00000000000000000000000000000001\",\"date_created\": \"2018-11-10T20:00:00Z\",\"path\": \"function-path\",\"visibility\": \"PUBLIC\"}],\"dependencies\": [{\"name\": \"twilio\",\"version\": \"3.6.3\"}],\"status\": \"queued\",\"date_created\": \"2018-11-10T20:00:00Z\",\"date_updated\": \"2018-11-10T20:00:00Z\",\"url\": \"https://serverless.twilio.com/v1/Services/ZS00000000000000000000000000000000/Builds/ZB00000000000000000000000000000000\"}", TwilioRestClient.HTTP_STATUS_CODE_CREATED);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        Build.creator("ZSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").create();
    }
}