// Targeted by JavaCPP version 1.5.11-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.pytorch;

import org.bytedeco.pytorch.Allocator;
import org.bytedeco.pytorch.Function;
import org.bytedeco.pytorch.Module;
import org.bytedeco.javacpp.annotation.Cast;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.javacpp.chrono.*;
import static org.bytedeco.javacpp.global.chrono.*;

import static org.bytedeco.pytorch.global.torch.*;


// Base class for supplementary data potentially needed by ReduceOps
@Namespace("c10d") @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class _SupplementBase extends CustomClassHolder {
    static { Loader.load(); }
    /** Default native constructor. */
    public _SupplementBase() { super((Pointer)null); allocate(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public _SupplementBase(Pointer p) { super(p); }
    @IntrusivePtr @Name("c10::make_intrusive<c10d::_SupplementBase>") private native void allocate();

}