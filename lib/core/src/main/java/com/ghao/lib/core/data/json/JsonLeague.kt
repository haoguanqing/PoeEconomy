package com.ghao.lib.core.data.json

import com.ghao.lib.core.data.League
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 *
{
"leagues":
[
{
"id": "Standard",
"realm": "pc",
"url": "https://www.pathofexile.com/ladders/league/Standard",
"startAt": "2013-01-23T21:00:00Z",
"endAt": null,
"description": "The default game mode.",
"registerAt": "2019-09-06T19:00:00Z",
"delveEvent": true,
"rules":
[]
},
{
"id": "Hardcore",
"realm": "pc",
"url": "https://www.pathofexile.com/ladders/league/Hardcore",
"startAt": "2013-01-23T21:00:00Z",
"endAt": null,
"description": "A character killed in the Hardcore league is moved to the Standard league.",
"registerAt": "2019-09-06T19:00:00Z",
"delveEvent": true,
"rules":
[
{
"id": "Hardcore",
"name": "Hardcore",
"description": "A character killed in Hardcore is moved to its parent league."
}
]
},
{
"id": "SSF Standard",
"realm": "pc",
"url": "https://www.pathofexile.com/ladders/league/SSF+Standard",
"startAt": "2013-01-23T21:00:00Z",
"endAt": null,
"description": "SSF Standard",
"registerAt": "2019-09-06T19:00:00Z",
"delveEvent": true,
"rules":
[
{
"id": "NoParties",
"name": "Solo",
"description": "You may not party in this league."
}
]
},
{
"id": "SSF Hardcore",
"realm": "pc",
"url": "https://www.pathofexile.com/ladders/league/SSF+Hardcore",
"startAt": "2013-01-23T21:00:00Z",
"endAt": null,
"description": "SSF Hardcore",
"registerAt": "2019-09-06T19:00:00Z",
"delveEvent": true,
"rules":
[
{
"id": "Hardcore",
"name": "Hardcore",
"description": "A character killed in Hardcore is moved to its parent league."
},
{
"id": "NoParties",
"name": "Solo",
"description": "You may not party in this league."
}
]
},
{
"id": "Sanctum",
"realm": "pc",
"url": "https://www.pathofexile.com/ladders/league/Sanctum",
"startAt": "2022-12-09T19:00:00Z",
"endAt": "2025-12-09T22:00:00Z",
"description": "Dare to enter The Forbidden Sanctum and uncover its treasures.\n\nThis is the default Path of Exile league.",
"registerAt": "2022-12-09T16:30:00Z",
"delveEvent": true,
"rules":
[]
},
{
"id": "Hardcore Sanctum",
"realm": "pc",
"url": "https://www.pathofexile.com/ladders/league/Hardcore+Sanctum",
"startAt": "2022-12-09T19:00:00Z",
"endAt": "2025-12-09T22:00:00Z",
"description": "Dare to enter The Forbidden Sanctum and uncover its treasures.\n\nA character killed in Hardcore Sanctum becomes a Standard character.",
"registerAt": "2022-12-09T16:30:00Z",
"delveEvent": true,
"rules":
[
{
"id": "Hardcore",
"name": "Hardcore",
"description": "A character killed in Hardcore is moved to its parent league."
}
]
},
{
"id": "SSF Sanctum",
"realm": "pc",
"url": "https://www.pathofexile.com/ladders/league/SSF+Sanctum",
"startAt": "2022-12-09T19:00:00Z",
"endAt": "2025-12-09T22:00:00Z",
"description": "SSF Sanctum",
"registerAt": "2022-12-09T16:30:00Z",
"delveEvent": true,
"rules":
[
{
"id": "NoParties",
"name": "Solo",
"description": "You may not party in this league."
}
]
},
{
"id": "HC SSF Sanctum",
"realm": "pc",
"url": "https://www.pathofexile.com/ladders/league/HC+SSF+Sanctum",
"startAt": "2022-12-09T19:00:00Z",
"endAt": "2025-12-09T22:00:00Z",
"description": "SSF HC Sanctum",
"registerAt": "2022-12-09T16:30:00Z",
"delveEvent": true,
"rules":
[
{
"id": "Hardcore",
"name": "Hardcore",
"description": "A character killed in Hardcore is moved to its parent league."
},
{
"id": "NoParties",
"name": "Solo",
"description": "You may not party in this league."
}
]
},
{
"id": "Ruthless Sanctum",
"realm": "pc",
"url": "https://www.pathofexile.com/ladders/league/Ruthless+Sanctum",
"startAt": "2022-12-09T19:00:00Z",
"endAt": "2025-12-09T22:00:00Z",
"description": "Dare to enter The Forbidden Sanctum and uncover its treasures.\n\nThis is the default Path of Exile league.",
"registerAt": "2022-12-09T16:30:00Z",
"delveEvent": true,
"rules":
[
{
"id": "HardMode",
"name": "Ruthless",
"description": "A significantly different game experience with extreme item scarcity, among other changes."
}
]
},
{
"id": "HC Ruthless Sanctum",
"realm": "pc",
"url": "https://www.pathofexile.com/ladders/league/HC+Ruthless+Sanctum",
"startAt": "2022-12-09T19:00:00Z",
"endAt": "2025-12-09T22:00:00Z",
"description": "Dare to enter The Forbidden Sanctum and uncover its treasures.\n\nA character killed in Hardcore Sanctum becomes a Standard character.",
"registerAt": "2022-12-09T16:30:00Z",
"delveEvent": true,
"rules":
[
{
"id": "Hardcore",
"name": "Hardcore",
"description": "A character killed in Hardcore is moved to its parent league."
},
{
"id": "HardMode",
"name": "Ruthless",
"description": "A significantly different game experience with extreme item scarcity, among other changes."
}
]
},
{
"id": "SSF R Sanctum",
"realm": "pc",
"url": "https://www.pathofexile.com/ladders/league/SSF+R+Sanctum",
"startAt": "2022-12-09T19:00:00Z",
"endAt": "2025-12-09T22:00:00Z",
"description": "SSF Sanctum",
"registerAt": "2022-12-09T16:30:00Z",
"delveEvent": true,
"rules":
[
{
"id": "NoParties",
"name": "Solo",
"description": "You may not party in this league."
},
{
"id": "HardMode",
"name": "Ruthless",
"description": "A significantly different game experience with extreme item scarcity, among other changes."
}
]
},
{
"id": "HC SSF R Sanctum",
"realm": "pc",
"url": "https://www.pathofexile.com/ladders/league/HC+SSF+R+Sanctum",
"startAt": "2022-12-09T19:00:00Z",
"endAt": "2025-12-09T22:00:00Z",
"description": "SSF HC Sanctum",
"registerAt": "2022-12-09T16:30:00Z",
"delveEvent": true,
"rules":
[
{
"id": "Hardcore",
"name": "Hardcore",
"description": "A character killed in Hardcore is moved to its parent league."
},
{
"id": "NoParties",
"name": "Solo",
"description": "You may not party in this league."
},
{
"id": "HardMode",
"name": "Ruthless",
"description": "A significantly different game experience with extreme item scarcity, among other changes."
}
]
}
]
}
 *
 */
@JsonClass(generateAdapter = true)
data class JsonLeague(
    @field:Json val id: String,
    @field:Json val realm: String,
    @field:Json val url: String,
    @field:Json val startAt: String,
    @field:Json val endAt: String,
    @field:Json val description: String,
    @field:Json val registerAt: String,
    @field:Json val delveEvent: Boolean,
    // @field:Json val rules: List<Rule>,
) {

    fun toDbEntity(): League {
        return League(id, realm, url, startAt, endAt, description, registerAt, delveEvent)
    }
}