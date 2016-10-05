package trello

interface ItrelloCardService {

    List<TrelloCard> getAllCardsOnMyBoard(Integer boardId)
    List<TrelloList> getAllListsOnMyBoard(Integer boardId)
}
