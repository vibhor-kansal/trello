package trello
import com.google.gson.annotations.SerializedName

class TrelloCard {

    @SerializedName("id")
    String id
    @SerializedName("name")
    String name
    @SerializedName("url")
    String url
    @SerializedName("closed")
    Boolean isClosed
    @SerializedName("dateLastActivity")
    Date lastActivity
}
