http://localhost:8080/
{
  "_links" : {
    "terrains" : {
      "href" : "http://localhost:8080/terrains"
    },
    "foods" : {
      "href" : "http://localhost:8080/foods"
    },
    "crows" : {
      "href" : "http://localhost:8080/crows"
    },
    "foxes" : {
      "href" : "http://localhost:8080/foxes"
    },
    "deities" : {
      "href" : "http://localhost:8080/deities"
    },
    "profile" : {
      "href" : "http://localhost:8080/profile"
    }
  }
}

http://localhost:8080/terrains

{
  "_embedded" : {
    "terrains" : [ {
      "name" : "Лес",
      "sizeBeauty" : 50,
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/terrains/1"
        },
        "terrain" : {
          "href" : "http://localhost:8080/terrains/1"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/terrains"
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/terrains"
    },
    "search" : {
      "href" : "http://localhost:8080/terrains/search"
    }
  }
}
