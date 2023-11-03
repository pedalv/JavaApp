package no.agitec.fagaften.mellom.oppdrag.repository;

import no.agitec.fagaften.mellom.oppdrag.domain.Partner;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "partner", path = "partner")
public interface PartnerRepository extends PagingAndSortingRepository<Partner, Long> {

    List<Partner> findByName(@Param("name") String name);

}

/*
Postman
localhost:8080/partner
{
  "_embedded": {
    "partner": [
      {
        "name": "Agitec",
        "_links": {
          "self": {
            "href": "http://localhost:8080/partner/6"
          },
          "partner": {
            "href": "http://localhost:8080/partner/6"
          }
        }
      },
      {
        "name": "Decisive",
        "_links": {
          "self": {
            "href": "http://localhost:8080/partner/7"
          },
          "partner": {
            "href": "http://localhost:8080/partner/7"
          }
        }
      },
      {
        "name": "Experis",
        "_links": {
          "self": {
            "href": "http://localhost:8080/partner/8"
          },
          "partner": {
            "href": "http://localhost:8080/partner/8"
          }
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "http://localhost:8080/partner"
    },
    "profile": {
      "href": "http://localhost:8080/profile/partner"
    },
    "search": {
      "href": "http://localhost:8080/partner/search"
    }
  },
  "page": {
    "size": 20,
    "totalElements": 3,
    "totalPages": 1,
    "number": 0
  }
}

curl -i -H "Content-Type:application/json" -d '{"name": "Agitec"}' http://localhost:8080/partner

WINDOWS
curl -i -H "Content-Type:application/json" -d "{\"name\": \"Agitec\"}" http://localhost:8080/partner

curl http://localhost:8080/partner/6
 */