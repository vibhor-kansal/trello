package trello.controller

import grails.converters.JSON
import grails.web.RequestParameter
import trello.ItrelloCardService
import trello.TrelloCard
import trello.TrelloList

class TrelloCardController {

    ItrelloCardService trelloCardService

    JSON getAllTrelloCards(@RequestParameter("boardId") Integer boardId) {
        List<TrelloCard> trelloCardList = trelloCardService.getAllCardsOnMyBoard(boardId)
        render trelloCardList
    }

    JSON getAllTrelloLists(@RequestParameter("boardId") Integer boardId) {
        List<TrelloList> trelloLists = trelloCardService.getAllListsOnMyBoard(boardId)
        render trelloLists
    }
}