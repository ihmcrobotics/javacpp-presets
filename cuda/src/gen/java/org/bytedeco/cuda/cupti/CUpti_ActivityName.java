// Targeted by JavaCPP version 1.5.11-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.cupti;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.cuda.cudart.*;
import static org.bytedeco.cuda.global.cudart.*;

import static org.bytedeco.cuda.global.cupti.*;


/**
 * \brief The activity record providing a name.
 *
 * This activity record provides a name for a device, context, thread,
 * etc. and other resource naming done via NVTX APIs
 * (CUPTI_ACTIVITY_KIND_NAME).
 */
@Properties(inherit = org.bytedeco.cuda.presets.cupti.class)
public class CUpti_ActivityName extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public CUpti_ActivityName() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public CUpti_ActivityName(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CUpti_ActivityName(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public CUpti_ActivityName position(long position) {
        return (CUpti_ActivityName)super.position(position);
    }
    @Override public CUpti_ActivityName getPointer(long i) {
        return new CUpti_ActivityName((Pointer)this).offsetAddress(i);
    }

  /**
   * The activity record kind, must be CUPTI_ACTIVITY_KIND_NAME.
   */
  public native @Cast("CUpti_ActivityKind") int kind(); public native CUpti_ActivityName kind(int setter);

  /**
   * The kind of activity object being named.
   */
  public native @Cast("CUpti_ActivityObjectKind") int objectKind(); public native CUpti_ActivityName objectKind(int setter);

  /**
   * The identifier for the activity object. 'objectKind' indicates
   * which ID is valid for this record.
   */
  public native @ByRef CUpti_ActivityObjectKindId objectId(); public native CUpti_ActivityName objectId(CUpti_ActivityObjectKindId setter);

// #ifdef CUPTILP64
  /**
   * Undefined. Reserved for internal use.
   */
  public native @Cast("uint32_t") int pad(); public native CUpti_ActivityName pad(int setter);
// #endif

  /**
   * The name.
   */
  public native @Cast("const char*") BytePointer name(); public native CUpti_ActivityName name(BytePointer setter);

}