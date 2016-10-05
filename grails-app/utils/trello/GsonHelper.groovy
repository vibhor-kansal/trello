package trello

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import groovy.util.logging.Log4j
import org.springframework.stereotype.Component

@Log4j
@Component
class GsonHelper {

    public static String ZULU_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

    private static final Gson gson = new GsonBuilder().setDateFormat(ZULU_DATE_FORMAT).create()

    public <T> T mapJsonString(String value, Class<T> clazz) {
        try {
            return gson.fromJson(value, clazz);
        } catch (Exception ex) {
            log.error("Exception in mapJsonString", ex);
            throw new RuntimeException(ex);
        }
    }
}
