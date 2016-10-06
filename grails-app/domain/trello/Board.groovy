package trello

import com.google.gson.annotations.SerializedName

class Board {

    @SerializedName("id")
    String id
    @SerializedName("name")
    String name
}
