package trello

import com.google.gson.annotations.SerializedName

class MemberCreator {

    @SerializedName("id")
    String id
    @SerializedName("fullName")
    String name
    @SerializedName("initials")
    String initials
    @SerializedName("username")
    String username
}
