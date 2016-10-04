package trello.controller.controllerRequest

import grails.converters.JSON
import grails.web.Controller
import grails.web.RequestParameter
import trello.impl.ItrelloCardService

@Controller
class TrelloCardController {

    ItrelloCardService trelloCardService

    public JSON getAllTrelloCards(@RequestParameter("boardId") Integer boardId) {
        def cards = trelloCardService.getAllCardsOnMyBoard(boardId)
        render cards as JSON
    }
}
