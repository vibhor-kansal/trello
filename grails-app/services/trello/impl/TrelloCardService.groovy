package trello.impl
import grails.converters.JSON
import grails.transaction.Transactional
import org.grails.web.json.JSONArray
import org.joda.time.DateTime
import org.joda.time.Days
import org.joda.time.Hours
import org.joda.time.Minutes
import org.joda.time.Seconds
import org.springframework.beans.factory.annotation.Autowired
import trello.Card
import trello.CardAction
import trello.GsonHelper
import trello.ItrelloCardService
import trello.RestExecutor

@Transactional
class TrelloCardService implements ItrelloCardService {

    private final String BOARD_ID = "CMV0pT47"
    private final String BOARD_ENDPOINT = "boards"
    private final String CARDS_ENDPOINT = "cards"
    private final String CARD_ACTION_ENDPOINT = "actions"
    private final String IN_PROGRESS_STATE = "In Progress"
    private final String DONE_STATE = "Done"
    private final String NOT_YET_DONE_MESSAGE = "Ticket is yet to be done"

    @Autowired
    private RestExecutor restExecutor

    @Autowired
    private GsonHelper gsonHelper

    @Override
    def getAllCardsOnMyBoard(Integer boardId) {
        Map<String, List<CardAction>> map = new HashMap<>()
        JSONArray cardArray = (JSONArray)JSON.parse(restExecutor.getTrelloResponse("${BOARD_ENDPOINT}/${BOARD_ID}/${CARDS_ENDPOINT}"))
        cardArray.each { cardValue ->
            Card card = gsonHelper.mapJsonString(cardValue.toString(), Card.class)
            println ("card : ${card.name} ${card.id}")
            List<CardAction> cardActionList = new ArrayList<>()
            JSONArray cardActionArray = (JSONArray)JSON.parse(restExecutor.getTrelloResponse("${CARDS_ENDPOINT}/${card.id}/${CARD_ACTION_ENDPOINT}"))
            cardActionArray.each { cardActionValue ->
                CardAction cardAction = gsonHelper.mapJsonString(cardActionValue.toString(), CardAction.class)
                println ("cardAction : ${cardAction.id}")
                cardActionList << cardAction
            }
            map.put(card.name, cardActionList)
        }
        return getTimeTakenForEachCard(map)
    }

    private Map<String, String> getTimeTakenForEachCard(final Map<String, List<CardAction>> map) {
        Map<String, String> finalMap = new HashMap<>()
        Date startDate = new Date()
        Date endDate = new Date()
        map.each { key, value ->
            value.each { cardAction ->
                /*if(cardAction.cardData.cardStatusBeforeList.name.contains(IN_PROGRESS_STATE) &&
                        cardAction.cardData.cardStatusAfterList.name.contains(DONE_STATE)) {
                    startDate = cardAction.date
                    endDate = cardAction.date
                }*//* else */
                if (cardAction.cardData.cardStatusBeforeList.name.contains(IN_PROGRESS_STATE)) {
                    startDate = cardAction.date
                } else if (cardAction.cardData.cardStatusAfterList.name.contains(DONE_STATE)) {
                    endDate = cardAction.date
                }
            }
            if(endDate) {
                finalMap.put(key, NOT_YET_DONE_MESSAGE)
            } else {
                finalMap.put(key, getTimeDifference(startDate, endDate))
            }
            /*if (notYetDoneFlag != 0) {
                finalMap.put(key, NOT_YET_DONE_MESSAGE)
            } else {
                finalMap.put(key, getTimeDifference(startDate, endDate))
            }*/
            println("cardFound : ${key}")
        }
        println finalMap
        return finalMap
    }

    private String getTimeDifference(Date startDate, Date endDate) {
        DateTime dt1 = new DateTime(startDate)
        DateTime dt2 = new DateTime(endDate)

        String actualTimeDifference = """${Days.daysBetween(dt1, dt2).getDays()} days, ${Hours.hoursBetween(dt1, dt2).getHours() % 24} hours,
                         ${Minutes.minutesBetween(dt1, dt2).getMinutes() % 60} minutes, ${Seconds.secondsBetween(dt1, dt2).getSeconds() % 60} seconds"""

        return actualTimeDifference
    }
}
