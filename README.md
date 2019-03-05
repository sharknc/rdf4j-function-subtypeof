# RDF4J Custom Function - SubtypeOf

## Create Subtype TTL

1. Open a new file in your text editor
2. Paste the following

```bash
@prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>.
@prefix ex: <http://example.org/> .
 
ex:a rdfs:label "Conflict.Attack.Punch" .
ex:b rdfs:label "Weapon.Pistol.Glock" .
```

3. Save as *subtype.ttl*

## Create custom function jar

1. In the rdf4j-function-subtypeof top level directory run the following
```bash
./gradlew build
```
2. Copy the resulting jar from _build/lib/rdf4j-function-subtypeof-1.0.0-SNAPSHOT.jar_ and place it into _/opt/GraphDBFree/app/lib/_
3. Updated the GraphDBFree.cfg to include the new rdf4j-function-subtypeof-1.0.0-SNAPSHOT.jar
4. Restart GraphDB

## Create GraphDB respository

1. In the GraphDB UI (localhost:7200) click on Setup
2. Click *Create New Repository* and name it
3. Click on *Import* from the left navigation panel and import *subtype.ttl*

## Run SPARQL Query

1. Run the following SPARQL query in GraphDB
```bash
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> 
PREFIX cfn: <http://example.org/custom-function/>
SELECT ?statement ?label ?subtype
WHERE {
    ?statement rdfs:label ?label .
    FILTER((cfn:subtypeOf(str(?label), "Conflict.Attack.Punch")) .
}
```

You should see the subtype return value. 

