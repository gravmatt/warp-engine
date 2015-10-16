#!/bin/sh
cd ~/warp-engine/
if [ -f ~/warp-engine/target/universal/stage/RUNNING_PID ]
then
    PID=$(tail RUNNING_PID)
    echo "stopping server $PID"
    kill -15 $PID
    # kill java to free resources
    pkill java
    rm ~/warp-engine/target/universal/stage/RUNNING_PID
fi
exit 0



