package net.gudenau.lib.unsafe;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.security.ProtectionDomain;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings({"unused", "SameParameterValue"})
public class Unsafe {
    public static final Class<?> SunUnsafe = sun.misc.Unsafe.class;
    public static final Class<?> Unsafe = Class.forName("jdk.internal.misc.Unsafe");
    public static final sun.misc.Unsafe theSunUnsafe = (sun.misc.Unsafe) MethodHandles.privateLookupIn(SunUnsafe, MethodHandles.lookup()).findStaticVarHandle(SunUnsafe, "theUnsafe", SunUnsafe).get();
    public static final MethodHandles.Lookup trustedLookup = (MethodHandles.Lookup) theSunUnsafe.getObject(MethodHandles.Lookup.class, theSunUnsafe.staticFieldOffset(MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP")));
    public static final Object theUnsafe = trustedLookup.findStatic(Unsafe, "getUnsafe", MethodType.methodType(Unsafe)).invoke();

    private static final MethodHandle getObjectInt = bind("getInt", int.class, Object.class, long.class);
    private static final MethodHandle putObjectInt = bind("putInt", void.class, Object.class, long.class, int.class);
    private static final MethodHandle getObjectReference = bind("getReference", Object.class, Object.class, long.class);
    private static final MethodHandle putObjectReference = bind("putReference", void.class, Object.class, long.class, Object.class);
    private static final MethodHandle getObjectBoolean = bind("getBoolean", boolean.class, Object.class, long.class);
    private static final MethodHandle putObjectBoolean = bind("putBoolean", void.class, Object.class, long.class, boolean.class);
    private static final MethodHandle getObjectByte = bind("getByte", byte.class, Object.class, long.class);
    private static final MethodHandle putObjectByte = bind("putByte", void.class, Object.class, long.class, byte.class);
    private static final MethodHandle getObjectShort = bind("getShort", short.class, Object.class, long.class);
    private static final MethodHandle putObjectShort = bind("putShort", void.class, Object.class, long.class, short.class);
    private static final MethodHandle getObjectChar = bind("getChar", char.class, Object.class, long.class);
    private static final MethodHandle putObjectChar = bind("putChar", void.class, Object.class, long.class, char.class);
    private static final MethodHandle getObjectLong = bind("getLong", long.class, Object.class, long.class);
    private static final MethodHandle putObjectLong = bind("putLong", void.class, Object.class, long.class, long.class);
    private static final MethodHandle getObjectFloat = bind("getFloat", float.class, Object.class, long.class);
    private static final MethodHandle putObjectFloat = bind("putFloat", void.class, Object.class, long.class, float.class);
    private static final MethodHandle getObjectDouble = bind("getDouble", double.class, Object.class, long.class);
    private static final MethodHandle putObjectDouble = bind("putDouble", void.class, Object.class, long.class, double.class);
    private static final MethodHandle getByte = bind("getByte", byte.class, long.class);
    private static final MethodHandle putByte = bind("putByte", void.class, long.class, byte.class);
    private static final MethodHandle getShort = bind("getShort", short.class, long.class);
    private static final MethodHandle putShort = bind("putShort", void.class, long.class, short.class);
    private static final MethodHandle getChar = bind("getChar", char.class, long.class);
    private static final MethodHandle putChar = bind("putChar", void.class, long.class, char.class);
    private static final MethodHandle getInt = bind("getInt", int.class, long.class);
    private static final MethodHandle putInt = bind("putInt", void.class, long.class, int.class);
    private static final MethodHandle getLong = bind("getLong", long.class, long.class);
    private static final MethodHandle putLong = bind("putLong", void.class, long.class, long.class);
    private static final MethodHandle getFloat = bind("getFloat", float.class, long.class);
    private static final MethodHandle putFloat = bind("putFloat", void.class, long.class, float.class);
    private static final MethodHandle getDouble = bind("getDouble", double.class, long.class);
    private static final MethodHandle putDouble = bind("putDouble", void.class, long.class, double.class);
    private static final MethodHandle getAddress = bind("getAddress", long.class, long.class);
    private static final MethodHandle getObjectAddress = bind("getAddress", long.class, Object.class, long.class);
    private static final MethodHandle putAddress = bind("putAddress", void.class, long.class, long.class);
    private static final MethodHandle putObjectAddress = bind("putAddress", void.class, Object.class, long.class, long.class);
    private static final MethodHandle getUncompressedObject = bind("getUncompressedObject", Object.class, long.class);
    private static final MethodHandle allocateMemory = bind("allocateMemory", long.class, long.class);
    private static final MethodHandle reallocateMemory = bind("reallocateMemory", long.class, long.class, long.class);
    private static final MethodHandle setObjectMemory = bind("setMemory", void.class, Object.class, long.class, long.class, byte.class);
    private static final MethodHandle setMemory = bind("setMemory", void.class, long.class, long.class, byte.class);
    private static final MethodHandle copyObjectMemory = bind("copyMemory", void.class, Object.class, long.class, Object.class, long.class, long.class);
    private static final MethodHandle copyMemory = bind("copyMemory", void.class, long.class, long.class, long.class);
    private static final MethodHandle freeMemory = bind("freeMemory", void.class, long.class);
    private static final MethodHandle objectFieldOffset = bind("objectFieldOffset", long.class, Field.class);
    private static final MethodHandle staticFieldOffset = bind("staticFieldOffset", long.class, Field.class);
    private static final MethodHandle staticFieldBase = bind("staticFieldBase", Object.class, Field.class);
    private static final MethodHandle shouldBeInitialized = bind("shouldBeInitialized", boolean.class, Class.class);
    private static final MethodHandle ensureClassInitialized = bind("ensureClassInitialized", void.class, Class.class);
    private static final MethodHandle arrayBaseOffset = bind("arrayBaseOffset", int.class, Class.class);
    private static final MethodHandle arrayIndexScale = bind("arrayIndexScale", int.class, Class.class);
    private static final MethodHandle addressSize = bind("addressSize", int.class);
    private static final MethodHandle pageSize = bind("pageSize", int.class);
    private static final MethodHandle defineClass = bind("defineClass", Class.class, String.class, byte[].class, int.class, int.class, ClassLoader.class, ProtectionDomain.class);
    private static final MethodHandle allocateInstance = bind("allocateInstance", Object.class, Class.class);
    private static final MethodHandle compareAndSwapReference = bind("compareAndSetReference", boolean.class, Object.class, long.class, Object.class, Object.class);
    private static final MethodHandle compareAndSwapInt = bind("compareAndSetInt", boolean.class, Object.class, long.class, int.class, int.class);
    private static final MethodHandle compareAndSwapLong = bind("compareAndSetLong", boolean.class, Object.class, long.class, long.class, long.class);
    private static final MethodHandle getReferenceVolatile = bind("getReferenceVolatile", Object.class, Object.class, long.class);
    private static final MethodHandle putReferenceVolatile = bind("putReferenceVolatile", void.class, Object.class, long.class, Object.class);
    private static final MethodHandle getIntVolatile = bind("getIntVolatile", int.class, Object.class, long.class);
    private static final MethodHandle putIntVolatile = bind("putIntVolatile", void.class, Object.class, long.class, int.class);
    private static final MethodHandle getBooleanVolatile = bind("getBooleanVolatile", boolean.class, Object.class, long.class);
    private static final MethodHandle putBooleanVolatile = bind("putBooleanVolatile", void.class, Object.class, long.class, boolean.class);
    private static final MethodHandle getByteVolatile = bind("getByteVolatile", byte.class, Object.class, long.class);
    private static final MethodHandle putByteVolatile = bind("putByteVolatile", void.class, Object.class, long.class, byte.class);
    private static final MethodHandle getShortVolatile = bind("getShortVolatile", short.class, Object.class, long.class);
    private static final MethodHandle putShortVolatile = bind("putShortVolatile", void.class, Object.class, long.class, short.class);
    private static final MethodHandle getCharVolatile = bind("getCharVolatile", char.class, Object.class, long.class);
    private static final MethodHandle putCharVolatile = bind("putCharVolatile", void.class, Object.class, long.class, char.class);
    private static final MethodHandle getLongVolatile = bind("getLongVolatile", long.class, Object.class, long.class);
    private static final MethodHandle putLongVolatile = bind("putLongVolatile", void.class, Object.class, long.class, long.class);
    private static final MethodHandle getFloatVolatile = bind("getFloatVolatile", float.class, Object.class, long.class);
    private static final MethodHandle putFloatVolatile = bind("putFloatVolatile", void.class, Object.class, long.class, float.class);
    private static final MethodHandle getDoubleVolatile = bind("getDoubleVolatile", double.class, Object.class, long.class);
    private static final MethodHandle putDoubleVolatile = bind("putDoubleVolatile", void.class, Object.class, long.class, double.class);
    private static final MethodHandle putOrderedReference = bind("putReferenceRelease", void.class, Object.class, long.class, Object.class);
    private static final MethodHandle putOrderedInt = bind("putIntRelease", void.class, Object.class, long.class, int.class);
    private static final MethodHandle putOrderedLong = bind("putLongRelease", void.class, Object.class, long.class, long.class);
    private static final MethodHandle getLoadAverage = bind("getLoadAverage", int.class, double[].class, int.class);
    private static final MethodHandle getAndAddInt = bind("getAndAddInt", int.class, Object.class, long.class, int.class);
    private static final MethodHandle getAndAddLong = bind("getAndAddLong", long.class, Object.class, long.class, long.class);
    private static final MethodHandle getAndSetInt = bind("getAndSetInt", int.class, Object.class, long.class, int.class);
    private static final MethodHandle getAndSetLong = bind("getAndSetLong", long.class, Object.class, long.class, long.class);
    private static final MethodHandle getAndSetReference = bind("getAndSetReference", Object.class, Object.class, long.class, Object.class);
    private static final MethodHandle loadFence = bind("loadFence", void.class);
    private static final MethodHandle storeFence = bind("storeFence", void.class);
    private static final MethodHandle fullFence = bind("fullFence", void.class);
    private static final MethodHandle invokeCleaner = bind("invokeCleaner", void.class, ByteBuffer.class);

    public static final int ARRAY_BOOLEAN_BASE_OFFSET = arrayBaseOffset(boolean[].class);
    public static final int ARRAY_BYTE_BASE_OFFSET = arrayBaseOffset(byte[].class);
    public static final int ARRAY_SHORT_BASE_OFFSET = arrayBaseOffset(short[].class);
    public static final int ARRAY_CHAR_BASE_OFFSET = arrayBaseOffset(char[].class);
    public static final int ARRAY_INT_BASE_OFFSET = arrayBaseOffset(int[].class);
    public static final int ARRAY_LONG_BASE_OFFSET = arrayBaseOffset(long[].class);
    public static final int ARRAY_FLOAT_BASE_OFFSET = arrayBaseOffset(float[].class);
    public static final int ARRAY_DOUBLE_BASE_OFFSET = arrayBaseOffset(double[].class);
    public static final int ARRAY_OBJECT_BASE_OFFSET = arrayBaseOffset(Object[].class);

    public static final int ARRAY_BOOLEAN_INDEX_SCALE = arrayIndexScale(boolean[].class);
    public static final int ARRAY_BYTE_INDEX_SCALE = arrayIndexScale(byte[].class);
    public static final int ARRAY_SHORT_INDEX_SCALE = arrayIndexScale(short[].class);
    public static final int ARRAY_CHAR_INDEX_SCALE = arrayIndexScale(char[].class);
    public static final int ARRAY_INT_INDEX_SCALE = arrayIndexScale(int[].class);
    public static final int ARRAY_LONG_INDEX_SCALE = arrayIndexScale(long[].class);
    public static final int ARRAY_FLOAT_INDEX_SCALE = arrayIndexScale(float[].class);
    public static final int ARRAY_DOUBLE_INDEX_SCALE = arrayIndexScale(double[].class);
    public static final int ARRAY_OBJECT_INDEX_SCALE = arrayIndexScale(Object[].class);

    public static final int ADDRESS_SIZE = addressSize();
    public static final int INVALID_FIELD_OFFSET = -1;

    public static int getInt(Object o, long offset) {
        return (int) getObjectInt.invokeExact(o, offset);
    }

    public static void putInt(Object o, long offset, int x) {
        putObjectInt.invokeExact(o, offset, x);
    }

    public static <T> T getReference(Object o, long offset) {
        return (T) getObjectReference.invokeExact(o, offset);
    }

    public static void putReference(Object o, long offset, Object x) {
        putObjectReference.invokeExact(o, offset, x);
    }

    public static boolean getBoolean(Object o, long offset) {
        return (boolean) getObjectBoolean.invokeExact(o, offset);
    }

    public static void putBoolean(Object o, long offset, boolean x) {
        putObjectBoolean.invokeExact(o, offset, x);
    }

    public static byte getByte(Object o, long offset) {
        return (byte) getObjectByte.invokeExact(o, offset);
    }

    public static void putByte(Object o, long offset, byte x) {
        putObjectByte.invokeExact(o, offset, x);
    }

    public static short getShort(Object o, long offset) {
        return (short) getObjectShort.invokeExact(o, offset);
    }

    public static void putShort(Object o, long offset, short x) {
        putObjectShort.invokeExact(o, offset, x);
    }

    public static char getChar(Object o, long offset) {
        return (char) getObjectChar.invokeExact(o, offset);
    }

    public static void putChar(Object o, long offset, char x) {
        putObjectChar.invokeExact(o, offset, x);
    }

    public static long getLong(Object o, long offset) {
        return (long) getObjectLong.invokeExact(o, offset);
    }

    public static void putLong(Object o, long offset, long x) {
        putObjectLong.invokeExact(o, offset, x);
    }

    public static float getFloat(Object o, long offset) {
        return (float) getObjectFloat.invokeExact(o, offset);
    }

    public static void putFloat(Object o, long offset, float x) {
        putObjectFloat.invokeExact(o, offset, x);
    }

    public static double getDouble(Object o, long offset) {
        return (double) getObjectDouble.invokeExact(o, offset);
    }

    public static void putDouble(Object o, long offset, double x) {
        putObjectDouble.invokeExact(o, offset, x);
    }

    public static byte getByte(long address) {
        return (byte) getByte.invokeExact(address);
    }

    public static void putByte(long address, byte x) {
        putByte.invokeExact(address, x);
    }

    public static short getShort(long address) {
        return (short) getShort.invokeExact(address);
    }

    public static void putShort(long address, short x) {
        putShort.invokeExact(address, x);
    }

    public static char getChar(long address) {
        return (char) getChar.invokeExact(address);
    }

    public static void putChar(long address, char x) {
        putChar.invokeExact(address, x);
    }

    public static int getInt(long address) {
        return (int) getInt.invokeExact(address);
    }

    public static void putInt(long address, int x) {
        putInt.invokeExact(address, x);
    }

    public static long getLong(long address) {
        return (long) getLong.invokeExact(address);
    }

    public static void putLong(long address, long x) {
        putLong.invokeExact(address, x);
    }

    public static float getFloat(long address) {
        return (float) getFloat.invokeExact(address);
    }

    public static void putFloat(long address, float x) {
        putFloat.invokeExact(address, x);
    }

    public static double getDouble(long address) {
        return (double) getDouble.invokeExact(address);
    }

    public static void putDouble(long address, double x) {
        putDouble.invokeExact(address, x);
    }

    public static long getAddress(long address) {
        return (long) getAddress.invokeExact(address);
    }

    public static long getAddress(Object object, long address) {
        return (long) getObjectAddress.invokeExact(object, address);
    }

    public static void putAddress(long address, long x) {
        putAddress.invokeExact(address, x);
    }

    public static void putAddress(Object object, long address, long x) {
        putObjectAddress.invokeExact(object, address, x);
    }

    public static <T> T getUncompressedObject(long address) {
        return (T) getUncompressedObject.invokeExact(address);
    }

    public static long allocateMemory(long bytes) {
        return (long) allocateMemory.invokeExact(bytes);
    }

    public static long reallocateMemory(long address, long bytes) {
        return (long) reallocateMemory.invokeExact(address, bytes);
    }

    public static void setMemory(Object o, long offset, long bytes, byte value) {
        setObjectMemory.invokeExact(o, offset, bytes, value);
    }

    public static void setMemory(long address, long bytes, byte value) {
        setMemory.invokeExact(address, bytes, value);
    }

    public static void copyMemory(Object srcBase, long srcOffset, Object destBase, long destOffset, long bytes) {
        copyObjectMemory.invokeExact(srcBase, srcOffset, destBase, destOffset, bytes);
    }

    public static void copyMemory(long srcAddress, long destAddress, long bytes) {
        copyMemory.invokeExact(srcAddress, destAddress, bytes);
    }

    public static void freeMemory(long address) {
        freeMemory.invokeExact(address);
    }

    public static long objectFieldOffset(Field field) {
        return (long) objectFieldOffset.invokeExact(field);
    }

    public static long staticFieldOffset(Field field) {
        return (long) staticFieldOffset.invokeExact(field);
    }

    public static Object staticFieldBase(Field field) {
        return (Object) staticFieldBase.invokeExact(field);
    }

    public static boolean shouldBeInitialized(Class<?> klass) {
        return (boolean) shouldBeInitialized.invokeExact(klass);
    }

    public static void ensureClassInitialized(Class<?> c) {
        ensureClassInitialized.invokeExact(c);
    }

    public static int arrayBaseOffset(Class<?> arrayClass) {
        return (int) arrayBaseOffset.invokeExact(arrayClass);
    }

    public static <T> int arrayIndexScale(Class<T> arrayClass) {
        return (int) arrayIndexScale.invokeExact(arrayClass);
    }

    public static int addressSize() {
        return (int) addressSize.invokeExact();
    }

    public static int pageSize() {
        return (int) pageSize.invokeExact();
    }

    public static <T> Class<T> defineClass(String name, byte[] bytecode, int offset, int length, ClassLoader classLoader, ProtectionDomain protectionDomain) {
        return (Class<T>) defineClass.invokeExact(name, bytecode, offset, length, classLoader, protectionDomain);
    }

    public static <T> T allocateInstance(Class<T> cls) {
        return (T) allocateInstance.invokeExact(cls);
    }

    public static RuntimeException throwException(Throwable throwable) {
        throw throwable;
    }

    public static boolean compareAndSwapObject(Object o, long offset, Object expected, Object x) {
        return (boolean) compareAndSwapReference.invokeExact(o, offset, expected, x);
    }

    public static boolean compareAndSwapInt(Object o, long offset, int expected, int x) {
        return (boolean) compareAndSwapInt.invokeExact(o, offset, expected, x);
    }

    public static boolean compareAndSwapLong(Object object, long offset, long expected, long x) {
        return (boolean) compareAndSwapLong.invokeExact(object, offset, expected, x);
    }

    public static <T> T getReferenceVolatile(Object object, long offset) {
        return (T) getReferenceVolatile.invokeExact(object, offset);
    }

    public static void putReferenceVolatile(Object o, long offset, Object x) {
        putReferenceVolatile.invokeExact(o, offset, x);
    }

    public static int getIntVolatile(Object o, long offset) {
        return (int) getIntVolatile.invokeExact(o, offset);
    }

    public static void putIntVolatile(Object o, long offset, int x) {
        putIntVolatile.invokeExact(o, offset, x);
    }

    public static boolean getBooleanVolatile(Object o, long offset) {
        return (boolean) getBooleanVolatile.invokeExact(o, offset);
    }

    public static void putBooleanVolatile(Object o, long offset, boolean x) {
        putBooleanVolatile.invokeExact(o, offset, x);
    }

    public static byte getByteVolatile(Object o, long offset) {
        return (byte) getByteVolatile.invokeExact(o, offset);
    }

    public static void putByteVolatile(Object o, long offset, byte x) {
        putByteVolatile.invokeExact(o, offset, x);
    }

    public static short getShortVolatile(Object o, long offset) {
        return (short) getShortVolatile.invokeExact(o, offset);
    }

    public static void putShortVolatile(Object o, long offset, short x) {
        putShortVolatile.invokeExact(o, offset, x);
    }

    public static char getCharVolatile(Object o, long offset) {
        return (char) getCharVolatile.invokeExact(o, offset);
    }

    public static void putCharVolatile(Object o, long offset, char x) {
        putCharVolatile.invokeExact(o, offset, x);
    }

    public static long getLongVolatile(Object o, long offset) {
        return (long) getLongVolatile.invokeExact(o, offset);
    }

    public static void putLongVolatile(Object o, long offset, long x) {
        putLongVolatile.invokeExact(o, offset, x);
    }

    public static float getFloatVolatile(Object o, long offset) {
        return (float) getFloatVolatile.invokeExact(o, offset);
    }

    public static void putFloatVolatile(Object o, long offset, float x) {
        putFloatVolatile.invokeExact(o, offset, x);
    }

    public static double getDoubleVolatile(Object o, long offset) {
        return (double) getDoubleVolatile.invokeExact(o, offset);
    }

    public static void putDoubleVolatile(Object o, long offset, double x) {
        putDoubleVolatile.invokeExact(o, offset, x);
    }

    public static void putOrderedReference(Object o, long offset, Object x) {
        putOrderedReference.invokeExact(o, offset, x);
    }

    public static void putOrderedInt(Object o, long offset, int x) {
        putOrderedInt.invokeExact(o, offset, x);
    }

    public static void putOrderedLong(Object o, long offset, long x) {
        putOrderedLong.invokeExact(o, offset, x);
    }

    public static int getLoadAverage(double[] loadavg, int nelems) {
        return (int) getLoadAverage.invokeExact(loadavg, nelems);
    }

    public static int getAndAddInt(Object o, long offset, int delta) {
        return (int) getAndAddInt.invokeExact(o, offset, delta);
    }

    public static long getAndAddLong(Object o, long offset, long delta) {
        return (long) getAndAddLong.invokeExact(o, offset, delta);
    }

    public static int getAndSetInt(Object o, long offset, int newValue) {
        return (int) getAndSetInt.invokeExact(o, offset, newValue);
    }

    public static long getAndSetLong(Object o, long offset, long newValue) {
        return (long) getAndSetLong.invokeExact(o, offset, newValue);
    }

    public static <T> T getAndSetReference(Object o, long offset, T newValue) {
        return (T) getAndSetReference.invokeExact(o, offset, (Object) newValue);
    }

    public static void loadFence() {
        loadFence.invokeExact();
    }

    public static void storeFence() {
        storeFence.invokeExact();
    }

    public static void fullFence() {
        fullFence.invokeExact();
    }

    public static void invokeCleaner(ByteBuffer directBuffer) {
        invokeCleaner.invokeExact(directBuffer);
    }

    private static MethodHandle bind(String method, String alternative, Class<?> returnType, Class<?>... parameterTypes) {
        try {
            try {
                return trustedLookup.bind(theUnsafe, method, MethodType.methodType(returnType, parameterTypes));
            } catch (NoSuchMethodException exception) {
                return trustedLookup.bind(theSunUnsafe, method, MethodType.methodType(returnType, parameterTypes));
            }
        } catch (Throwable throwable) {
            if (alternative == null) {
                Logger.getLogger("Unsafe").log(Level.SEVERE, "Unable to access Unsafe method %s%s.%n".formatted(method, MethodType.methodType(returnType, parameterTypes)), throwable);

                return null;
            }

            return bind(method, null, returnType, parameterTypes);
        }
    }

    private static MethodHandle bind(String method, Class<?> returnType, Class<?>... parameterTypes) {
        return bind(method, null, returnType, parameterTypes);
    }
}
