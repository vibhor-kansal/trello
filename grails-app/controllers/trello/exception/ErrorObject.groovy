package trello.exception

import groovy.transform.Canonical

@Canonical
class ErrorObject {

    int errorCode
    String message
}
