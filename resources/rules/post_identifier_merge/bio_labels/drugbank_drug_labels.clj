;; --------------------------------------------------
;; --------- DrugBank Drug Label Assignment ---------
;; --------------------------------------------------
`{:name "drugbank-drug-labels"
  :description "This rule creates a label for every drug record and types it as (IAO_EXT_)"
  :head (
          ;; create a label for the drug
          (?/drug rdfs/label ?/drug_name))

  :body ((?/drug_ice_id obo/IAO_0000219 ?/drug) ; IAO:denotes
         (?/drug_field_value rdf/type ?/drug_ice_id)
         (?/drug_field_value rdf/type ccp/IAO_EXT_0000360) ; ccp:Drugbank_drug_record__drugbank_identifier_field_value
         (?/record obo/BFO_0000051 ?/drug_field_value) ; BFO:has_part
         (?/record rdf/type ccp/IAO_EXT_0000426) ; ccp:DrugBank_drug_record

         ;; retrieve the drug name
         (?/record obo/BFO_0000051 ?/drug_name_field_value) ; BFO:has_part
         (?/drug_name_field_value rdf/type ccp/IAO_EXT_0000367)) ; ccp:Drugbank_drug_record__drug_name_field_value


  ;; In this case no :reify entry is required, since all of the data required to form the new triples already exist

  :options {:magic-prefixes [["franzOption_chunkProcessingAllowed" "franz:yes"]]}
  }