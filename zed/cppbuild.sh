#!/bin/bash
# This file is meant to be included by the parent cppbuild.sh script
if [[ -z "$PLATFORM" ]]; then
    pushd ..
    bash cppbuild.sh "$@" zed
    popd
    exit
fi

# Requires libusb-dev, CUDA

ZED_C_VERSION=4.0.4
download https://github.com/stereolabs/zed-c-api/archive/refs/tags/v$ZED_C_VERSION.tar.gz zed-c-api-$ZED_C_VERSION.tar.gz
mkdir -p $PLATFORM
cd $PLATFORM
INSTALL_PATH=`pwd`
tar -xzvf ../zed-c-api-$ZED_C_VERSION.tar.gz
cd zed-c-api-$ZED_C_VERSION

case $PLATFORM in
    linux-arm64)
        if [[ ! -d "/usr/local/zed" ]]; then
            echo "Please install ZED under the default installation directory: /usr/local/zed"
            exit 1
        fi
        mkdir build && cd build
        cmake .. -DCMAKE_BUILD_TYPE=Release
        make
        # Installs to /usr/local/zed
        # Include: /usr/local/zed/include/sl/c_api/
        # Lib: /usr/local/zed/lib/libsl_zed_c.so
        make install
        ;;
    linux-x86_64)
        if [[ ! -d "/usr/local/zed" ]]; then
            echo "Please install ZED under the default installation directory: /usr/local/zed"
            exit 1
        fi
        mkdir build && cd build
        cmake .. -DCMAKE_BUILD_TYPE=Release
        make
        # Installs to /usr/local/zed
        # Include: /usr/local/zed/include/sl/c_api/
        # Lib: /usr/local/zed/lib/libsl_zed_c.so
        make install
        ;;
    windows-x86_64)
        ;;
    *)
        echo "Error: Platform \"$PLATFORM\" is not supported"
        ;;
esac
