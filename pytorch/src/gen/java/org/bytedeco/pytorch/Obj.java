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


// User-defined object.
@Name("c10::ivalue::Object") @NoOffset @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class Obj extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Obj(Pointer p) { super(p); }

  // In general, class types hold a shared_ptr to its owning CompilationUnit,
  // so that its type and methods do not get deallocated while the class exists.
  // However, the CompilationUnit holds ownership of the type's graphs, so
  // inserting a constant object into a Graph would create a reference cycle if
  // that constant object held a shared_ptr to its CU. For these objects we
  // instatiate them with non-owning references to its CU
  public Obj(@ByVal WeakOrStrongTypePtr type, @Cast("size_t") long numSlots) { super((Pointer)null); allocate(type, numSlots); }
  @IntrusivePtr @Name("c10::make_intrusive<c10::ivalue::Object>") private native void allocate(@ByVal WeakOrStrongTypePtr type, @Cast("size_t") long numSlots);

  public Obj(@ByVal StrongTypePtr type, @Cast("size_t") long numSlots) { super((Pointer)null); allocate(type, numSlots); }
  @IntrusivePtr @Name("c10::make_intrusive<c10::ivalue::Object>") private native void allocate(@ByVal StrongTypePtr type, @Cast("size_t") long numSlots);

  public static native @IntrusivePtr("c10::ivalue::Object") @Cast({"", "c10::intrusive_ptr<c10::ivalue::Object>&"}) Obj create(
        @ByVal WeakOrStrongTypePtr type,
        @Cast("size_t") long numSlots);

  public static native @IntrusivePtr("c10::ivalue::Object") @Cast({"", "c10::intrusive_ptr<c10::ivalue::Object>&"}) Obj create(
        @ByVal StrongTypePtr type,
        @Cast("size_t") long numSlots);

  public static native @IntrusivePtr("c10::ivalue::Object") @Cast({"", "c10::intrusive_ptr<c10::ivalue::Object>&"}) Obj create(@SharedPtr("c10::ClassType") @ByVal ClassType classType, @Cast("size_t") long numSlots);

  /**
   * Slot API.
   *
   * Attributes are stored as a simple vector so that lookups are fast at
   * runtime. A "slot" is just an index into that vector, which can be computed
   * statically if you have access to the class type. Use this API if you are
   * writing compiler stuff.
   */
  public native void setSlot(@Cast("size_t") long slot, @ByVal IValue v);

  public native @Const @ByRef IValue getSlot(@Cast("size_t") long slot);

  public native void unsafeRemoveSlot(@Cast("size_t") long slot);

  /**
   * Attribute API.
   *
   * Wrappers around the slot stuff so that users can access attributes
   * directly. Use this API if you are a user.
   *
   * Note: Unlike in Python, TorchScript must make a distinction between
   * attributes (which are IValues) and methods (which are Methods). If you
   * want a method, use {@code obj.type()->getMethod()}
   */
  public native @ByVal IValue getAttr(@StdString BytePointer name);
  public native @ByVal IValue getAttr(@StdString String name);
  public native void setAttr(@StdString BytePointer name, @ByVal IValue v);
  public native void setAttr(@StdString String name, @ByVal IValue v);
  // Remove attribute by name, caller is responsible for
  // the safety of this operation
  // We didn't remove the attribute in the type because the type
  // might be shared by multiple objects.
  // Therefore after removing attribute, the object is in an inconsistent
  // state where it has more attribute types in its Type than
  // the attribute slots it has, user needs to make sure the object
  // has consistent by removing the attribute in type as well
  public native void unsafeRemoveAttr(@StdString BytePointer name);
  public native void unsafeRemoveAttr(@StdString String name);

  public native @StdString BytePointer name();

  public native @Const @ByRef IValueVector slots();
  public native @SharedPtr("c10::ClassType") @ByVal ClassType type();

  public native @SharedPtr("torch::jit::CompilationUnit") @ByVal CompilationUnit compilation_unit();

  public native @IntrusivePtr("c10::ivalue::Object") @Cast({"", "c10::intrusive_ptr<c10::ivalue::Object>&"}) Obj copy_to_weak_compilation_ref();

  public native void unsafe_make_weak_compilation_ref();

  public native @IntrusivePtr("c10::ivalue::Object") @Cast({"", "c10::intrusive_ptr<c10::ivalue::Object>&"}) Obj copy();

  public native @IntrusivePtr("c10::ivalue::Object") @Cast({"", "c10::intrusive_ptr<c10::ivalue::Object>&"}) Obj deepcopy(
        @ByVal(nullValue = "std::optional<at::Device>(c10::nullopt)") DeviceOptional device);
  public native @IntrusivePtr("c10::ivalue::Object") @Cast({"", "c10::intrusive_ptr<c10::ivalue::Object>&"}) Obj deepcopy();

  public native @IntrusivePtr("c10::ivalue::Object") @Cast({"", "c10::intrusive_ptr<c10::ivalue::Object>&"}) Obj deepcopy(
        @ByRef HashIdentityIValueMap memo,
        @ByVal(nullValue = "std::optional<at::Device>(c10::nullopt)") DeviceOptional device);
  public native @IntrusivePtr("c10::ivalue::Object") @Cast({"", "c10::intrusive_ptr<c10::ivalue::Object>&"}) Obj deepcopy(
        @ByRef HashIdentityIValueMap memo);

  public native @Cast("bool") boolean is_weak_compilation_ref();

  public native @Cast("bool") boolean is_empty_strong_compilation_ref();
}