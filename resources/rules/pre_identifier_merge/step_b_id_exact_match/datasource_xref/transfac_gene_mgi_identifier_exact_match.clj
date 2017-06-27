;; -------------------------------------------------------
;; --------- Transfac Gene MGI Identifier Exact Match ----------
;; -------------------------------------------------------
`{:name "transfac-gene-mgi-identifier-exact-match"
  :description "This rule asserts an exact match between transfac gene identifiers and mgi gene identifiers"
  :head ((?/transfacGeneIce skos/exactMatch ?/mgiIce))
  :body ((?/record iaotransfac/TransfacGeneDatFileData_transfacGeneIDDataField1 ?/transfacGeneIce)
         (?/record iaotransfac/TransfacGeneDatFileData_mgiDatabaseReferenceIDDataField1 ?/mgiIce))
  }