;; ------------------------------------------------------------------------
;; --------- Ontology Concept Identifier Denotes Ontology Concept ---------
;; ------------------------------------------------------------------------
;; create id denotes concept triple for every ontology concept; this rule handles the TAIR URIs used by pr.owl
`{:name "ontology-id-denotes-concept-gen-tair"
  :description "This rule generates an ontology concept identifier for every non-root ontology concept with the TAIR namespace."
  :head ((?/id obo/IAO_0000219 ?/ontology_concept) ; denotes
         (?/id rdf/type ccp/IAO_EXT_0000088)) ; ontology concept identifier
  :reify ([?/id {:ln (:regex "TAIR:locus:" "TAIR_LOCUS_" ?/concept_id)
                 :ns "ccp" :prefix "" :suffix ""}])
  :sparql-string "prefix franzOption_clauseReorderer: <franz:identity>
                  prefix ccp: <http://ccp.ucdenver.edu/obo/ext/>
                  prefix obo: <http://purl.obolibrary.org/obo/>
                  prefix oboInOwl: <http://www.geneontology.org/formats/oboInOwl#>
                  select ?ontology_concept ?concept_id {
                  ?ontology_concept oboInOwl:id ?concept_id .
                  # include only concepts with the TAIR namespace
                  filter (contains (str(?ontology_concept), 'http://www.arabidopsis.org/servlets/TairObject?type=locus'))
                  minus {?ontology_concept owl:deprecated true} .
                  minus {?ontology_concept rdf:type ccp:IAO_EXT_0000190} . #ccp:ontology root concept identifier
                  ?ontology_concept rdfs:subClassOf* ?root_class .
                  ?root_id obo:IAO_0000219 ?root_class . #obo:denotes
                  ?root_id rdf:type ccp:IAO_EXT_0000190 . #ccp:ontology root concept identifier
  }"
  }