package trello

interface ItrelloCardService {

    List<Card> getAllCardsOnMyBoard(Integer boardId)
}
