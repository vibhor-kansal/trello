package trello.impl

import grails.transaction.Transactional
import groovy.util.logging.Log4j
import org.springframework.beans.factory.annotation.Autowired
import trello.RestExecutor

@Log4j
@Transactional
class TrelloCardService implements ItrelloCardService {

    private static final String BOARD_ID = "CMV0pT47"

    @Autowired
    RestExecutor restExecutor

    @Override
    def getAllCardsOnMyBoard(Integer boardId) {

        restExecutor.getTrelloResponse(BOARD_ID)
    }
}
