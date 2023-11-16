#!/bin/bash
# This file is meant to be included by the parent cppbuild.sh script
if [[ -z "$PLATFORM" ]]; then
    pushd ..
    bash cppbuild.sh "$@" spinnaker
    popd
    exit
fi

SPINNAKER_VERSION=3.1.0.79

case $PLATFORM in
    linux-*)
        if [[ ! -d "/usr/include/spinnaker/" ]] && [[ ! -d "/opt/spinnaker/include/" ]]; then
            echo "Please install Spinnaker under the default installation directory: /usr/include/spinnaker or /opt/spinnaker/include"
            exit 1
        fi
        ;;
    windows-*)
        if [[ ! -d "/C/Program Files/Spinnaker/" ]] && [[ ! -d "/C/Program Files (x86)/Spinnaker/" ]] &&
           [[ ! -d "/C/Program Files/FLIR Systems/Spinnaker/" ]] && [[ ! -d "/C/Program Files (x86)/FLIR Systems/Spinnaker/" ]]; then
            echo "Please install Spinnaker under the default installation directory"
            exit 1
        fi
        ;;
    *)
        echo "Error: Platform \"$PLATFORM\" is not supported"
        ;;
esac
