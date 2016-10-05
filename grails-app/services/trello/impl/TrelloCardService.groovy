package trello.impl

import grails.converters.JSON
import grails.transaction.Transactional
import org.grails.web.json.JSONArray
import org.springframework.beans.factory.annotation.Autowired
import trello.GsonHelper
import trello.ItrelloService
import trello.RestExecutor
import trello.TrelloCard
import trello.TrelloList

@Transactional
class TrelloCardService implements ItrelloService {

    private static final String BOARD_ID = "CMV0pT47"
    private static final String LISTS_ENDPOINT = "lists"
    private static final String CARDS_ENDPOINT = "cards"

    @Autowired
    private RestExecutor restExecutor

    @Autowired
    private GsonHelper gsonHelper

    @Override
    List<TrelloCard> getAllCardsOnMyBoard(Integer boardId) {
        List<TrelloCard> trelloCardList = new ArrayList<>()
        JSONArray jsonArray = (JSONArray)JSON.parse(restExecutor.getTrelloResponse("${BOARD_ID}/${CARDS_ENDPOINT}"))
        jsonArray.each { value ->
            TrelloCard trelloCard = gsonHelper.mapJsonString(value.toString(), TrelloCard.class)
            trelloCardList << trelloCard
        }
        return trelloCardList
    }

    @Override
    List<TrelloList> getAllListsOnMyBoard(Integer boardId) {
        def trelloLists = []
        JSONArray jsonArray = (JSONArray)JSON.parse(restExecutor.getTrelloResponse("${BOARD_ID}/${LISTS_ENDPOINT}"))
        jsonArray.each { value ->
            TrelloList trelloList = gsonHelper.mapJsonString(value.toString(), TrelloList.class)
            trelloLists << trelloList
        }
        return trelloLists
    }
}
