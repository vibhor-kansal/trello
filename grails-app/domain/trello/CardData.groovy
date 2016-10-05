package trello

import com.google.gson.annotations.SerializedName

class CardData {

    @SerializedName("listAfter")
    CardStatus cardStatusAfterList
    @SerializedName("listBeofre")
    CardStatus cardStatusBeforeList
    @SerializedName("board")
    Board board
    @SerializedName("card")
    Card card
}
