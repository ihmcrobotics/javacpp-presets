// Targeted by JavaCPP version 1.5.3-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.arrow.global.arrow.*;


@Namespace("arrow") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class StringScalar extends BinaryScalar {
    static { Loader.load(); }

  
    
      
      
        public StringScalar(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type) { super((Pointer)null); allocate(type); }
        private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type);
  
  
    public StringScalar(@SharedPtr ArrowBuffer value,
                   @SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type) { super((Pointer)null); allocate(value, type); }
    private native void allocate(@SharedPtr ArrowBuffer value,
                   @SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type);
  
    public StringScalar(@SharedPtr ArrowBuffer value) { super((Pointer)null); allocate(value); }
    private native void allocate(@SharedPtr ArrowBuffer value);
  
    public StringScalar() { super((Pointer)null); allocate(); }
    private native void allocate();
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public StringScalar(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public StringScalar(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public StringScalar position(long position) {
        return (StringScalar)super.position(position);
    }


  public StringScalar(@StdString String s) { super((Pointer)null); allocate(s); }
  private native void allocate(@StdString String s);
  public StringScalar(@StdString BytePointer s) { super((Pointer)null); allocate(s); }
  private native void allocate(@StdString BytePointer s);
}