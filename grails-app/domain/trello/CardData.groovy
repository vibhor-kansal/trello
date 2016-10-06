package trello

import com.google.gson.annotations.SerializedName

class CardData {

    @SerializedName("listAfter")
    CardStatus cardStatusAfterList
    @SerializedName("listBefore")
    CardStatus cardStatusBeforeList
    @SerializedName("board")
    Board board
    @SerializedName("card")
    Card card
}
