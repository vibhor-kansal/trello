class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')

        "/api/trello/cards"(controller: "trello", action: "getAllTrelloCards", method: "GET") {
            format = "json"
        }
        "/api/trello/lists"(controller: "trello", action: "getAllTrelloLists", method: "GET") {
            format = "json"
        }
    }
}
