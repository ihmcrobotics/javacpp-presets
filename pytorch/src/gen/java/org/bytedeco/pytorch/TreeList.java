// Targeted by JavaCPP version 1.5.10-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.pytorch;

import org.bytedeco.pytorch.Allocator;
import org.bytedeco.pytorch.Function;
import org.bytedeco.pytorch.functions.*;
import org.bytedeco.pytorch.Module;
import org.bytedeco.javacpp.annotation.Cast;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;

import static org.bytedeco.pytorch.global.torch.*;

@Name("c10::SmallVector<c10::intrusive_ptr<torch::jit::Tree>,4>") @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class TreeList extends TreeRefSmallVectorImpl {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TreeList(Pointer p) { super(p); }

  public TreeList() { super((Pointer)null); allocate(); }
  private native void allocate();

  public TreeList(@Cast("size_t") long Size, @Const @ByRef(nullValue = "c10::intrusive_ptr<torch::jit::Tree>()") TreeRef Value) { super((Pointer)null); allocate(Size, Value); }
  private native void allocate(@Cast("size_t") long Size, @Const @ByRef(nullValue = "c10::intrusive_ptr<torch::jit::Tree>()") TreeRef Value);
  public TreeList(@Cast("size_t") long Size) { super((Pointer)null); allocate(Size); }
  private native void allocate(@Cast("size_t") long Size);

  // note: The enable_if restricts Container to types that have a .begin() and
  // .end() that return valid input iterators.

  public TreeList(@Const @ByRef TreeList RHS) { super((Pointer)null); allocate(RHS); }
  private native void allocate(@Const @ByRef TreeList RHS);

  public native @ByRef @Name("operator =") TreeList put(@Const @ByRef TreeList RHS);

  // note: The enable_if restricts Container to types that have a .begin() and
  // .end() that return valid input iterators.

  

  

  // note: The enable_if restricts Container to types that have a .begin() and
  // .end() that return valid input iterators.
}