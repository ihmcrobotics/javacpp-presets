#!/bin/bash
# This file is meant to be included by the parent cppbuild.sh script
if [[ -z "$PLATFORM" ]]; then
    pushd ..
    bash cppbuild.sh "$@" zed
    popd
    exit
fi

ZED_C_VERSION=4.0.7
download https://github.com/stereolabs/zed-c-api/archive/refs/tags/v$ZED_C_VERSION.tar.gz zed-c-api-$ZED_C_VERSION.tar.gz
mkdir -p $PLATFORM
cd $PLATFORM
INSTALL_PATH=`pwd`
tar -xzvf ../zed-c-api-$ZED_C_VERSION.tar.gz
cd zed-c-api-$ZED_C_VERSION

#if [[ ! -d "/usr/local/zed" ]]; then
#    echo "Please install ZED under the default installation directory: /usr/local/zed"
#    exit 1
#fi
#if [[ ! -d "/usr/local/cuda" ]]; then
#    echo "Please install CUDA under the default installation directory: /usr/local/cuda"
#    exit 1
#fi

if [[ ! -d "C:\Program Files (x86)\ZED SDK" ]]; then
    echo "Please install ZED SDK under the default installation directory: C:\Program Files (x86)\ZED SDK"
    exit 1
fi
if [[ ! -d "C:\Program Files\NVIDIA GPU Computing Toolkit\CUDA\v12.1" ]]; then
    echo "Please install CUDA under the default installation directory: C:\Program Files\NVIDIA GPU Computing Toolkit\CUDA\v12.1"
    exit 1
fi

case $PLATFORM in
    linux-arm64)
        mkdir build && cd build
        cmake .. -DCUDA_TOOLKIT_ROOT_DIR=/usr/local/cuda -DCMAKE_BUILD_TYPE=Release
        make
        make install
        ;;
    linux-x86_64)
        mkdir build && cd build
        cmake .. -DCMAKE_BUILD_TYPE=Release
        make
        make install
        ;;
    windows-x86_64)
        ;;
    *)
        echo "Error: Platform \"$PLATFORM\" is not supported"
        ;;
esac
