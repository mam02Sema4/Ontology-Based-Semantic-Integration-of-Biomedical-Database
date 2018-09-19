`{:description "This rule finds any previously reified catalysis record from Reactome and sets its controller fields.",
 :name "add_catalysis_record_controller_from_human_reactome_to_ice_step_c2",

 :head ((?/modul_record obo/BFO_0000051 ?/controller_record)
        (?/controller_record rdf/type ccp/IAO_EXT_0001566) ;; controller field value
        ),
  :body "#add_catalysis_record_controller_from_human_reactome_to_ice_step_c2.clj
PREFIX franzOption_chunkProcessingAllowed: <franz:yes>
PREFIX franzOption_clauseReorderer: <franz:identity>
PREFIX obo: <http://purl.obolibrary.org/obo/>
PREFIX ccp: <http://ccp.ucdenver.edu/obo/ext/>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX bp: <http://www.biopax.org/release/biopax-level3.owl#>
PREFIX bp3: <http://www.reactome.org/biopax/63/48887#>
SELECT ?modul_record ?controller ?controller_record 
WHERE {
?modul rdf:type bp:Catalysis .
?modul bp:controller ?controller .
GRAPH <file://add_catalysis_records_from_human_reactome_to_ice_step_a.nt> {
?modul obo:IAO_0000142 ?modul_record .
}
?controller obo:IAO_0000142 ?controller_record .

}"
}
