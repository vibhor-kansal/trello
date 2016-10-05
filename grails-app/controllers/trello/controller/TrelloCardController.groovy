package trello.controller

import grails.converters.JSON
import grails.web.RequestParameter
import trello.ItrelloService
import trello.TrelloCard
import trello.TrelloList

class TrelloCardController {

    ItrelloService trelloService

    JSON getAllTrelloCards(@RequestParameter("boardId") Integer boardId) {
        List<TrelloCard> trelloCardList = trelloService.getAllCardsOnMyBoard(boardId)
        render trelloCardList
    }

    JSON getAllTrelloLists(@RequestParameter("boardId") Integer boardId) {
        List<TrelloList> trelloLists = trelloService.getAllListsOnMyBoard(boardId)
        render trelloLists
    }
}