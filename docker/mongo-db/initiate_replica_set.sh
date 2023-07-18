#!/bin/bash

echo "Starting replica set initialization"
until mongosh --host mongo1 --eval "print(\"waited for connection\")"
do
   sleep 7
done
echo "Connection finished"
echo "Creating replica set"

MONGO1IP=$(getent hosts mongo1 | awk '{ print $1 }')
MONGO2IP=$(getent hosts mongo2 | awk '{ print $1 }')
MONGO3IP=$(getent hosts mongo3 | awk '{ print $1 }')

read -r -d '' CMD <<EOF
rs.initiate(
  {
    _id : 'myReplicaSet',
    members: [
      { _id : 0, host : '${MONGO1IP}:27017' },
      { _id : 1, host : '${MONGO2IP}:27017' },
      { _id : 2, host : '${MONGO3IP}:27017' }
    ]
  }
)
EOF

echo $CMD | mongosh --host mongo1
echo "replica set created"