package trello

import grails.plugins.rest.client.RestBuilder
import groovy.util.logging.Log4j
import org.springframework.http.MediaType
import org.springframework.stereotype.Component

@Log4j
@Component
class RestExecutor {

    private final String BASE_URL = "https://api.trello.com/1"
    private final String TRELLO_AUTHENTICATION_KEY = "e3b7e44f89f67143e058c02aa80a6b66"
    private
    final String TRELLO_AUTHENTICATION_TOKEN = "586710edcb84284ec0fa1d407d913cea0230f3587fe3564940d1f661b5eb5c8e"
    private final String AUTHENTICATION_PARAMS = "key=${TRELLO_AUTHENTICATION_KEY}&token=${TRELLO_AUTHENTICATION_TOKEN}"

    RestBuilder restBuilder

    public String getTrelloResponse(final String apiEndpoint) {
        restBuilder = new RestBuilder()

        try {
            def response = restBuilder.get("${BASE_URL}/${apiEndpoint}?${AUTHENTICATION_PARAMS}") {
                accept(MediaType.APPLICATION_JSON_VALUE)
                contentType(MediaType.APPLICATION_JSON_VALUE)
            }
            return response.json.toString()
        } catch (Exception ex) {
            log.error("Exception occurred while getting response from Trello", ex);
            throw new RuntimeException(ex);
        }
    }
}
