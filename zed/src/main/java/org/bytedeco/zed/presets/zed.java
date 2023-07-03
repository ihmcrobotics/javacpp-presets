package org.bytedeco.zed.presets;

import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;
import org.bytedeco.javacpp.tools.*;

@Properties(
    value = {
        @Platform(include = {"/usr/local/zed/include/sl/c_api/types_c.h",
                             "/usr/local/zed/include/sl/c_api/zed_interface.h"},
              includepath = "/usr/local/cuda/include",
              linkpath = "/usr/local/zed/lib",
              link = "sl_zed_c")
    },
    target = "org.bytedeco.zed",
    global = "org.bytedeco.zed.global.zed"
)
public class zed implements InfoMapper {
    static { Loader.checkVersion("org.bytedeco", "zed"); }

    public void map(InfoMap infoMap) {
        infoMap.put(new Info("CUcontext", "cudaStream_t").skip());
    }
}
