# maprdb-rest-base64
This java app calls HBASE REST API and decode the output to get the value from <column family> : <column name> 
HBASE REST API output is in base64 encoded format. Downstream app can decode the value in column family: colunmane  for use

For java class path
a) Import jars from httpcomponents-client-4.5.5-bin.tar  to classpath
b) Import jars from json-simple-1.1.1

Sample HBASE REST call
`http://<your hbase rest node>:<port>/<hbase table>/<row key>/<column family name>:<column name>`
 
 Sample output (in JSON) from REST call.
 
 {"Row":[{"key":"MTAx","Cell":[{"column":"Y2YxOmZuYW1l","timestamp":1525187878127,"$":"MTExMQ=="}]}]}
 
 Here the value is MTExMQ==  (This is base64 encoded)
 
 This program  calls the REST API and parse the output get the value and decode it. Also this saves the output to an html file ( helps when the value is in html)
 
 




 
 
  
