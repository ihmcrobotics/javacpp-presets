// Targeted by JavaCPP version 1.5.11-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflowlite;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.tensorflowlite.global.tensorflowlite.*;

// #endif  // __cplusplus

/** TfLiteOperator is an opaque version of TfLiteRegistration,
 *  and is used for registering custom ops.  It represents a definition of a
 *  custom op or a builtin op.
 * 
 *  \warning This is an experimental type and subject to change. */

///
///
///
///
///
///
@Opaque @Properties(inherit = org.bytedeco.tensorflowlite.presets.tensorflowlite.class)
public class TfLiteOperator extends Pointer {
    /** Empty constructor. Calls {@code super((Pointer)null)}. */
    public TfLiteOperator() { super((Pointer)null); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TfLiteOperator(Pointer p) { super(p); }
}