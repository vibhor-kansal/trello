package trello

import com.google.gson.annotations.SerializedName

class CardAction {

    @SerializedName("id")
    String id
    @SerializedName("type")
    String type
    @SerializedName("data")
    CardData cardData
    @SerializedName("date")
    Date date
    @SerializedName("memberCreator")
    MemberCreator memberCreator

}
