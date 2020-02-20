// Targeted by JavaCPP version 1.5.3-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.onnxruntime;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import org.bytedeco.dnnl.*;
import static org.bytedeco.dnnl.global.dnnl.*;

import static org.bytedeco.onnxruntime.global.onnxruntime.*;


@Properties(inherit = org.bytedeco.onnxruntime.presets.onnxruntime.class)
public class OrtLoggingFunction extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    OrtLoggingFunction(Pointer p) { super(p); }
    protected OrtLoggingFunction() { allocate(); }
    private native void allocate();
    public native void call(
    Pointer param, @Cast("OrtLoggingLevel") int severity, @Cast("const char*") BytePointer category, @Cast("const char*") BytePointer logid, @Cast("const char*") BytePointer code_location,
    @Cast("const char*") BytePointer message);
}
