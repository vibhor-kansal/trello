package trello.controller

import grails.converters.JSON
import grails.web.RequestParameter
import trello.ItrelloCardService
import trello.Card

class TrelloCardController {

    ItrelloCardService trelloCardService

    JSON getAllTrelloCards(@RequestParameter("boardId") Integer boardId) {
        List<Card> trelloCardList = trelloCardService.getAllCardsOnMyBoard(boardId)
        render trelloCardList
    }
}