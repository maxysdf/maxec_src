#!/bin/sh
base="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
host=http://localhost:9200
hdrs='Content-Type: application/json'

for actf in $base/*.action; do
   act=$(cut -f1 $actf)
   path=$(cut -f2 $actf)
   [ -z "$act" -o -z "$path" ] && continue

   df=${actf/\.action/.json}
   [ -f "$df" ] || df=

   echo "found action: $act, url: $host$path, json file: $df"
   ret=0
   if [ -n "$df" ]; then
      curl -X $act -d @$df -H "$hdrs" --fail $host$path
      ret=$?
   else
      curl -X $act -H "$hdrs" $host$path
      ret=$?
   fi
   echo 

   if [ $ret -ne 0 ]; then
      echo "error occurs, stop."
   else
      break
   fi

done