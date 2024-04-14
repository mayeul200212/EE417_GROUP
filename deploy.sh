#!/bin/bash

# Colors
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No color

# Function to check disk usage and cleanup if necessary
check_disk_and_cleanup() {
    local disk_usage
    disk_usage=$(df -h / | grep / | awk '{print $5}')
    if [[ "$disk_usage" == "100%" ]]; then
        printf "%bDisk at 100%, initiating cleanup...%b\n" "${YELLOW}" "${NC}"
        docker system prune --all --force --volumes
    fi
}

# Function to update the repository
update_repository() {
    printf "%bUpdating repository...%b\n" "${YELLOW}" "${NC}"
    if ! git pull; then
        printf "%bError: git pull failed.%b\n" "${RED}" "${NC}" >&2
        return 1
    fi
}

# Function to start production environment
start_production() {
    printf "%bStarting production environment...%b\n" "${YELLOW}" "${NC}"
    if ! make prod; then
        printf "%bError: prod command failed.%b\n" "${RED}" "${NC}" >&2
        check_disk_and_cleanup
        printf "%bRetrying make prod...%b\n" "${YELLOW}" "${NC}"
        if ! make prod; then
            printf "%bError: prod command failed again after cleanup.%b\n" "${RED}" "${NC}" >&2
            return 84
        fi
    fi
}

# Main function
main() {
    update_repository || return 1
    start_production
}

main
