// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package org.bytedeco.cpython;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cpython.global.python.*;


/* Long integer representation.
   The absolute value of a number is equal to
        SUM(for i=0 through abs(ob_size)-1) ob_digit[i] * 2**(SHIFT*i)
   Negative numbers are represented with ob_size < 0;
   zero is represented by ob_size == 0.
   In a normalized number, ob_digit[abs(ob_size)-1] (the most significant
   digit) is never zero.  Also, in all cases, for all valid i,
        0 <= ob_digit[i] <= MASK.
   The allocation function takes care of allocating extra memory
   so that ob_digit[0] ... ob_digit[abs(ob_size)-1] are actually available.
   We always allocate memory for at least one digit, so accessing ob_digit[0]
   is always safe. However, in the case ob_size == 0, the contents of
   ob_digit[0] may be undefined.

   CAUTION:  Generic code manipulating subtypes of PyVarObject has to
   aware that ints abuse  ob_size's sign bit.
*/

@Properties(inherit = org.bytedeco.cpython.presets.python.class)
public class _PyLongValue extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public _PyLongValue() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public _PyLongValue(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public _PyLongValue(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public _PyLongValue position(long position) {
        return (_PyLongValue)super.position(position);
    }
    @Override public _PyLongValue getPointer(long i) {
        return new _PyLongValue((Pointer)this).offsetAddress(i);
    }

    public native @Cast("uintptr_t") long lv_tag(); public native _PyLongValue lv_tag(long setter); /* Number of digits, sign and flags */
    public native @Cast("digit") int ob_digit(int i); public native _PyLongValue ob_digit(int i, int setter);
    @MemberGetter public native @Cast("digit*") IntPointer ob_digit();
}
