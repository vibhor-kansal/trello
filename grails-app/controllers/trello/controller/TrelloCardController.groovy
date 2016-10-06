package trello.controller
import grails.converters.JSON
import trello.ItrelloCardService

class TrelloCardController {

    ItrelloCardService trelloCardService

    JSON getAllTrelloCards() {
        def trelloCardList = trelloCardService.getAllCardsOnMyBoard()
        render trelloCardList as JSON
    }
}