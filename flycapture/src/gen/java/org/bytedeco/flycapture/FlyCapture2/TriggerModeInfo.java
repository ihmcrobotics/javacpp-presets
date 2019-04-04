// Targeted by JavaCPP version 1.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.flycapture.FlyCapture2;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.flycapture.global.FlyCapture2.*;


    /** Information about a camera trigger property. */
    @Namespace("FlyCapture2") @NoOffset @Properties(inherit = org.bytedeco.flycapture.presets.FlyCapture2.class)
public class TriggerModeInfo extends Pointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public TriggerModeInfo(Pointer p) { super(p); }
        /** Native array allocator. Access with {@link Pointer#position(long)}. */
        public TriggerModeInfo(long size) { super((Pointer)null); allocateArray(size); }
        private native void allocateArray(long size);
        @Override public TriggerModeInfo position(long position) {
            return (TriggerModeInfo)super.position(position);
        }
    
        /** Presence of trigger mode. */
        public native @Cast("bool") boolean present(); public native TriggerModeInfo present(boolean present);
        /** Flag indicating if trigger value can be read out. */
        public native @Cast("bool") boolean readOutSupported(); public native TriggerModeInfo readOutSupported(boolean readOutSupported);
        /** Flag indicating if on/off is supported. */
        public native @Cast("bool") boolean onOffSupported(); public native TriggerModeInfo onOffSupported(boolean onOffSupported);
        /** Flag indicating if polarity is supported. */
        public native @Cast("bool") boolean polaritySupported(); public native TriggerModeInfo polaritySupported(boolean polaritySupported);
        /** Flag indicating if the value is readable. */
        public native @Cast("bool") boolean valueReadable(); public native TriggerModeInfo valueReadable(boolean valueReadable);
        /** Source mask. */
        public native @Cast("unsigned int") int sourceMask(); public native TriggerModeInfo sourceMask(int sourceMask);
        /** Flag indicating if software trigger is supported. */
        public native @Cast("bool") boolean softwareTriggerSupported(); public native TriggerModeInfo softwareTriggerSupported(boolean softwareTriggerSupported);
        /** Mode mask. */
        public native @Cast("unsigned int") int modeMask(); public native TriggerModeInfo modeMask(int modeMask);
        /** Reserved for future use. */
        public native @Cast("unsigned int") int reserved(int i); public native TriggerModeInfo reserved(int i, int reserved);
        @MemberGetter public native @Cast("unsigned int*") IntPointer reserved();

        public TriggerModeInfo() { super((Pointer)null); allocate(); }
        private native void allocate();
    }