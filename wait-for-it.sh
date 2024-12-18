#!/usr/bin/env bash
# wait-for-it.sh

# The MIT License (MIT)
# Copyright (c) 2015 Vishnu Bob
# https://github.com/vishnubob/wait-for-it

TIMEOUT=20
QUIET=0
HOST=""
PORT=""
WAIT_FOR=""
usage() {
  echo "Usage: wait-for-it.sh host:port [-t timeout] [-- command args]"
  echo "  -t TIMEOUT   Timeout in seconds (default: $TIMEOUT)"
  echo "  -q           Quiet mode (no output)"
  echo "  --           End of options"
  echo "  host:port    Host and port to wait for"
  echo "  command args Execute command after waiting for the host:port"

  exit 1
}

wait_for() {
  start_ts=$(date +%s)
  while :; do
    nc -z $HOST $PORT
    result=$?
    if [[ $result -eq 0 ]]; then
      end_ts=$(date +%s)
      duration=$(( end_ts - start_ts ))
      [[ $QUIET -eq 0 ]] && echo "$HOST:$PORT is available after $duration seconds"
      return 0
    fi
    duration=$(( $(date +%s) - start_ts ))
    if [[ $duration -gt $TIMEOUT ]]; then
      [[ $QUIET -eq 0 ]] && echo "$HOST:$PORT did not become available before the timeout"
      return 1
    fi
    sleep 1
  done
}

while [[ $# -gt 0 ]]; do
  case "$1" in
    -t)
      TIMEOUT=$2
      shift 2
      ;;
    -q)
      QUIET=1
      shift
      ;;
    --)
      shift
      break
      ;;
    *)
      if [[ -z "$HOST" ]]; then
        HOST=$(echo "$1" | cut -d: -f1)
        PORT=$(echo "$1" | cut -d: -f2)
        shift
      else
        break
      fi
      ;;
  esac
done

wait_for

if [[ $# -gt 0 ]]; then
  exec "$@"
fi
