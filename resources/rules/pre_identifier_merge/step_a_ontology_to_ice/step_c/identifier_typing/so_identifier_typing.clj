;; -----------------------------------------------
;; --------- so identifier typing ---------
;; -----------------------------------------------
`{:name "so-identifier-typing"
  :description "This rule specifically the sequence ontology identifier"
  :head ((?/id rdf/type ccp/IAO_EXT_0000203)) ; CCP:sequence_ontology_identifier
  :sparql-string "prefix obo: <http://purl.obolibrary.org/obo/>
                  prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
                  prefix oboInOwl: <http://www.geneontology.org/formats/oboInOwl#>
                  select ?id {
                  ?id rdf:type ccp:IAO_EXT_0000088 . # CCP:ontology_concept_identifier
                  ?id obo:IAO_0000219 ?c . # IAO:denotes
                  ?c oboInOwl:hasOBONamespace 'sequence'}" 
  }