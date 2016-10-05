package trello.exception

import groovy.transform.Canonical

@Canonical
class TrelloBusinessException extends RuntimeException {

    List<ErrorObject> errors
}
