package trello.impl
import grails.converters.JSON
import grails.transaction.Transactional
import org.grails.web.json.JSONArray
import org.springframework.beans.factory.annotation.Autowired
import trello.GsonHelper
import trello.ItrelloCardService
import trello.RestExecutor
import trello.Card

@Transactional
class TrelloCardService implements ItrelloCardService {

    private static final String BOARD_ID = "CMV0pT47"
    private static final String CARDS_ENDPOINT = "cards"

    @Autowired
    private RestExecutor restExecutor

    @Autowired
    private GsonHelper gsonHelper

    @Override
    List<Card> getAllCardsOnMyBoard(Integer boardId) {
        List<Card> trelloCardList = new ArrayList<>()
        JSONArray jsonArray = (JSONArray)JSON.parse(restExecutor.getTrelloResponse("${BOARD_ID}/${CARDS_ENDPOINT}"))
        jsonArray.each { value ->
            Card trelloCard = gsonHelper.mapJsonString(value.toString(), Card.class)
            trelloCardList << trelloCard
        }
        return trelloCardList
    }
}
