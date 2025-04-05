#!/bin/bash

#Check for admin priviliges
if [[ "$(whoami)" != "Administrator" && "$(whoami)" != "root" ]]; then
     echo "Requesting Admin Priviliges..."
     if command -v powershell.exe >/dev/null; then
        powershell.exe -Command "Start-Process -Verb RunAs -FilePath 'bash' -ArgumentList '-c', \"cd '$PWD'; ./$(basename $0)\""
    else
        exec sudo "$0" "$@"
    fi
    exit
fi

#config
LOG_FILE="cleaner.log"
TEMP_DIRS=("$USERPROFILE/Downloads" "/tmp" "$USERPROFILE/AppData/Local/Temp")
FILE_TYPES=("*.tmp" "*.log" "*.temp")

#logging function
log() {
    echo "[$(date '+%Y-%m-%d %H:%M:%S')] $1" >> "$LOG_FILE"
}

#main cleanup
for dir in "${TEMP_DIRS[@]}"; do
    if [ -d "$dir" ]; then
        for type in "${FILE_TYPES[@]}"; do
            find "$dir" -name "$type" -mtime +7 -exec rm -v {} \; 2>/dev/null | while read -r line; do
                log "Deleted: $line"
            done
        done
    else
       log "Skipped: $dir (not found)"
    fi
done

log "******Cleanup Completed*******"
