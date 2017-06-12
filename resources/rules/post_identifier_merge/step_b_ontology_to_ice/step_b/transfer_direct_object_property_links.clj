`{:name "transfer-direct-object-property-links"
  :description "This rule transfers direct links between ObjectProperty instances to bio world, e.g. rdfs:subPropertyOf, owl:inverseOf, etc."
  :head ((?/bio_p1 ?/p ?/bio_p2))
  :sparql-string "prefix franzOption_clauseReorderer: <franz:identity>
                  prefix franzOption_chunkProcessingAllowed: <franz:yes>
                  prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
                  prefix owl: <http://www.w3.org/2002/07/owl#>
                  prefix obo: <http://purl.obolibrary.org/obo/>

                  select ?bio_p1 ?p ?bio_p2 {
                           ?p1 rdf:type owl:ObjectProperty .
                           ?property_id_1 obo:IAO_0000219 ?p1 .
                           ?property_id_1 obo:IAO_0000219 ?bio_p1 .
                           filter (?p1 != ?bio_p1 && contains(str(?bio_p1),'http://ccp.ucdenver.edu/obo/ext/'))
                           ?p1 ?p ?p2 .
                           ?p2 rdf:type owl:ObjectProperty .
                           ?property_id_2 obo:IAO_0000219 ?p2 .
                           ?property_id_2 obo:IAO_0000219 ?bio_p2 .
                           filter (?p2 != ?bio_p2 && contains(str(?bio_p2),'http://ccp.ucdenver.edu/obo/ext/'))
                           }"
  }





