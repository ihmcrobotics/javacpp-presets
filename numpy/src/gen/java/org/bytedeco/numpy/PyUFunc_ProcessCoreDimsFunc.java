// Targeted by JavaCPP version 1.5.11-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.numpy;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.cpython.*;
import static org.bytedeco.cpython.global.python.*;

import static org.bytedeco.numpy.global.numpy.*;


/*
 * This is the signature for the functions that may be assigned to the
 * `process_core_dims_func` field of the PyUFuncObject structure.
 * Implementation of this function is optional.  This function is only used
 * by generalized ufuncs (i.e. those with the field `core_enabled` set to 1).
 * The function is called by the ufunc during the processing of the arguments
 * of a call of the ufunc. The function can check the core dimensions of the
 * input and output arrays and return -1 with an exception set if any
 * requirements are not satisfied. If the caller of the ufunc didn't provide
 * output arrays, the core dimensions associated with the output arrays (i.e.
 * those that are not also used in input arrays) will have the value -1 in
 * `core_dim_sizes`.  This function can replace any output core dimensions
 * that are -1 with a value that is appropriate for the ufunc.
 *
 * Parameter       Description
 * --------------- ------------------------------------------------------
 * ufunc           The ufunc object
 * core_dim_sizes  An array with length `ufunc->core_num_dim_ix`.
 *                 The core dimensions of the arrays passed to the ufunc
 *                 will have been set.  If the caller of the ufunc didn't
 *                 provide the output array(s), the output-only core
 *                 dimensions will have the value -1.
 *
 * The function must not change any element in `core_dim_sizes` that is
 * not -1 on input. Doing so will result in incorrect output from the
 * ufunc, and could result in a crash of the Python interpreter.
 *
 * The function must return 0 on success, -1 on failure (with an exception
 * set).
 */
@Properties(inherit = org.bytedeco.numpy.presets.numpy.class)
public class PyUFunc_ProcessCoreDimsFunc extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    PyUFunc_ProcessCoreDimsFunc(Pointer p) { super(p); }
    protected PyUFunc_ProcessCoreDimsFunc() { allocate(); }
    private native void allocate();
    public native int call(
                                PyUFuncObject ufunc,
                                @Cast("npy_intp*") SizeTPointer core_dim_sizes);
}