package trello

import com.google.gson.annotations.SerializedName

class CardPosition {

    @SerializedName("id")
    String id
    @SerializedName("name")
    String currentState
    @SerializedName("closed")
    Boolean isClosed
    @SerializedName("idBoard")
    String boardId
}
