package trello.controller
import grails.converters.JSON
import grails.web.RequestParameter
import trello.ItrelloCardService

class TrelloCardController {

    ItrelloCardService trelloCardService

    JSON getAllTrelloCards(@RequestParameter("boardId") Integer boardId) {
        def trelloCardList = trelloCardService.getAllCardsOnMyBoard(boardId)
        render trelloCardList
    }
}