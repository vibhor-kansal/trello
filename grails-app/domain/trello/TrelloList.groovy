package trello

import com.google.gson.annotations.SerializedName

class TrelloList {

    @SerializedName("id")
    String id
    @SerializedName("name")
    String name
    @SerializedName("idBoard")
    String boardId
    @SerializedName("closed")
    Boolean isClosed
}
