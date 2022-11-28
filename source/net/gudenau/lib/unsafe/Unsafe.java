package net.gudenau.lib.unsafe;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.security.ProtectionDomain;

import static net.auoeke.dycon.Dycon.*;

@SuppressWarnings({"unused", "Java9ReflectionClassVisibility"})
public class Unsafe {
	public static final Class<?> SunUnsafe = sun.misc.Unsafe.class;
	public static final Class<?> Unsafe = Class.forName("jdk.internal.misc.Unsafe");
	public static final sun.misc.Unsafe theSunUnsafe = (sun.misc.Unsafe) MethodHandles.privateLookupIn(SunUnsafe, MethodHandles.lookup()).findStaticVarHandle(SunUnsafe, "theUnsafe", SunUnsafe).get();
	public static final MethodHandles.Lookup trustedLookup = (MethodHandles.Lookup) theSunUnsafe.getObject(MethodHandles.Lookup.class, theSunUnsafe.staticFieldOffset(MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP")));
	public static final Object theUnsafe = trustedLookup.findStatic(Unsafe, "getUnsafe", MethodType.methodType(Unsafe)).invoke();

	public static final int
		ARRAY_BOOLEAN_BASE_OFFSET = arrayBaseOffset(boolean[].class),
		ARRAY_BYTE_BASE_OFFSET = arrayBaseOffset(byte[].class),
		ARRAY_SHORT_BASE_OFFSET = arrayBaseOffset(short[].class),
		ARRAY_CHAR_BASE_OFFSET = arrayBaseOffset(char[].class),
		ARRAY_INT_BASE_OFFSET = arrayBaseOffset(int[].class),
		ARRAY_LONG_BASE_OFFSET = arrayBaseOffset(long[].class),
		ARRAY_FLOAT_BASE_OFFSET = arrayBaseOffset(float[].class),
		ARRAY_DOUBLE_BASE_OFFSET = arrayBaseOffset(double[].class),
		ARRAY_OBJECT_BASE_OFFSET = arrayBaseOffset(Object[].class),

		ARRAY_BOOLEAN_INDEX_SCALE = arrayIndexScale(boolean[].class),
		ARRAY_BYTE_INDEX_SCALE = arrayIndexScale(byte[].class),
		ARRAY_SHORT_INDEX_SCALE = arrayIndexScale(short[].class),
		ARRAY_CHAR_INDEX_SCALE = arrayIndexScale(char[].class),
		ARRAY_INT_INDEX_SCALE = arrayIndexScale(int[].class),
		ARRAY_LONG_INDEX_SCALE = arrayIndexScale(long[].class),
		ARRAY_FLOAT_INDEX_SCALE = arrayIndexScale(float[].class),
		ARRAY_DOUBLE_INDEX_SCALE = arrayIndexScale(double[].class),
		ARRAY_OBJECT_INDEX_SCALE = arrayIndexScale(Object[].class),

		ADDRESS_SIZE = addressSize(),
		INVALID_FIELD_OFFSET = -1;

	public static int getInt(Object o, long offset) {
		return (int) ldc(() -> bind("getInt", int.class, Object.class, long.class)).invokeExact(o, offset);
	}

	public static void putInt(Object o, long offset, int x) {
		ldc(() -> bind("putInt", void.class, Object.class, long.class, int.class)).invokeExact(o, offset, x);
	}

	public static <T> T getReference(Object o, long offset) {
		return (T) ldc(() -> bind("getReference", Object.class, Object.class, long.class)).invokeExact(o, offset);
	}

	public static void putReference(Object o, long offset, Object x) {
		ldc(() -> bind("putReference", void.class, Object.class, long.class, Object.class)).invokeExact(o, offset, x);
	}

	public static boolean getBoolean(Object o, long offset) {
		return (boolean) ldc(() -> bind("getBoolean", boolean.class, Object.class, long.class)).invokeExact(o, offset);
	}

	public static void putBoolean(Object o, long offset, boolean x) {
		ldc(() -> bind("putBoolean", void.class, Object.class, long.class, boolean.class)).invokeExact(o, offset, x);
	}

	public static byte getByte(Object o, long offset) {
		return (byte) ldc(() -> bind("getByte", byte.class, Object.class, long.class)).invokeExact(o, offset);
	}

	public static void putByte(Object o, long offset, byte x) {
		ldc(() -> bind("putByte", void.class, Object.class, long.class, byte.class)).invokeExact(o, offset, x);
	}

	public static short getShort(Object o, long offset) {
		return (short) ldc(() -> bind("getShort", short.class, Object.class, long.class)).invokeExact(o, offset);
	}

	public static void putShort(Object o, long offset, short x) {
		ldc(() -> bind("putShort", void.class, Object.class, long.class, short.class)).invokeExact(o, offset, x);
	}

	public static char getChar(Object o, long offset) {
		return (char) ldc(() -> bind("getChar", char.class, Object.class, long.class)).invokeExact(o, offset);
	}

	public static void putChar(Object o, long offset, char x) {
		ldc(() -> bind("putChar", void.class, Object.class, long.class, char.class)).invokeExact(o, offset, x);
	}

	public static long getLong(Object o, long offset) {
		return (long) ldc(() -> bind("getLong", long.class, Object.class, long.class)).invokeExact(o, offset);
	}

	public static void putLong(Object o, long offset, long x) {
		ldc(() -> bind("putLong", void.class, Object.class, long.class, long.class)).invokeExact(o, offset, x);
	}

	public static float getFloat(Object o, long offset) {
		return (float) ldc(() -> bind("getFloat", float.class, Object.class, long.class)).invokeExact(o, offset);
	}

	public static void putFloat(Object o, long offset, float x) {
		ldc(() -> bind("putFloat", void.class, Object.class, long.class, float.class)).invokeExact(o, offset, x);
	}

	public static double getDouble(Object o, long offset) {
		return (double) ldc(() -> bind("getDouble", double.class, Object.class, long.class)).invokeExact(o, offset);
	}

	public static void putDouble(Object o, long offset, double x) {
		ldc(() -> bind("putDouble", void.class, Object.class, long.class, double.class)).invokeExact(o, offset, x);
	}

	public static byte getByte(long address) {
		return (byte) ldc(() -> bind("getByte", byte.class, long.class)).invokeExact(address);
	}

	public static void putByte(long address, byte x) {
		ldc(() -> bind("putByte", void.class, long.class, byte.class)).invokeExact(address, x);
	}

	public static short getShort(long address) {
		return (short) ldc(() -> bind("getShort", short.class, long.class)).invokeExact(address);
	}

	public static void putShort(long address, short x) {
		ldc(() -> bind("putShort", void.class, long.class, short.class)).invokeExact(address, x);
	}

	public static char getChar(long address) {
		return (char) ldc(() -> bind("getChar", char.class, long.class)).invokeExact(address);
	}

	public static void putChar(long address, char x) {
		ldc(() -> bind("putChar", void.class, long.class, char.class)).invokeExact(address, x);
	}

	public static int getInt(long address) {
		return (int) ldc(() -> bind("getInt", int.class, long.class)).invokeExact(address);
	}

	public static void putInt(long address, int x) {
		ldc(() -> bind("putInt", void.class, long.class, int.class)).invokeExact(address, x);
	}

	public static long getLong(long address) {
		return (long) ldc(() -> bind("getLong", long.class, long.class)).invokeExact(address);
	}

	public static void putLong(long address, long x) {
		ldc(() -> bind("putLong", void.class, long.class, long.class)).invokeExact(address, x);
	}

	public static float getFloat(long address) {
		return (float) ldc(() -> bind("getFloat", float.class, long.class)).invokeExact(address);
	}

	public static void putFloat(long address, float x) {
		ldc(() -> bind("putFloat", void.class, long.class, float.class)).invokeExact(address, x);
	}

	public static double getDouble(long address) {
		return (double) ldc(() -> bind("getDouble", double.class, long.class)).invokeExact(address);
	}

	public static void putDouble(long address, double x) {
		ldc(() -> bind("putDouble", void.class, long.class, double.class)).invokeExact(address, x);
	}

	public static long getAddress(long address) {
		return (long) ldc(() -> bind("getAddress", long.class, long.class)).invokeExact(address);
	}

	public static long getAddress(Object object, long address) {
		return (long) ldc(() -> bind("getAddress", long.class, Object.class, long.class)).invokeExact(object, address);
	}

	public static void putAddress(long address, long x) {
		ldc(() -> bind("putAddress", void.class, long.class, long.class)).invokeExact(address, x);
	}

	public static void putAddress(Object object, long address, long x) {
		ldc(() -> bind("putAddress", void.class, Object.class, long.class, long.class)).invokeExact(object, address, x);
	}

	public static <T> T getUncompressedObject(long address) {
		return (T) ldc(() -> bind("getUncompressedObject", Object.class, long.class)).invokeExact(address);
	}

	public static long allocateMemory(long bytes) {
		return (long) ldc(() -> bind("allocateMemory", long.class, long.class)).invokeExact(bytes);
	}

	public static long reallocateMemory(long address, long bytes) {
		return (long) ldc(() -> bind("reallocateMemory", long.class, long.class, long.class)).invokeExact(address, bytes);
	}

	public static void setMemory(Object o, long offset, long bytes, byte value) {
		ldc(() -> bind("setMemory", void.class, Object.class, long.class, long.class, byte.class)).invokeExact(o, offset, bytes, value);
	}

	public static void setMemory(long address, long bytes, byte value) {
		ldc(() -> bind("setMemory", void.class, long.class, long.class, byte.class)).invokeExact(address, bytes, value);
	}

	public static void copyMemory(Object srcBase, long srcOffset, Object destBase, long destOffset, long bytes) {
		ldc(() -> bind("copyMemory", void.class, Object.class, long.class, Object.class, long.class, long.class)).invokeExact(srcBase, srcOffset, destBase, destOffset, bytes);
	}

	public static void copyMemory(long srcAddress, long destAddress, long bytes) {
		ldc(() -> bind("copyMemory", void.class, long.class, long.class, long.class)).invokeExact(srcAddress, destAddress, bytes);
	}

	public static void freeMemory(long address) {
		ldc(() -> bind("freeMemory", void.class, long.class)).invokeExact(address);
	}

	public static long objectFieldOffset(Field field) {
		return (long) ldc(() -> bind("objectFieldOffset", long.class, Field.class)).invokeExact(field);
	}

	public static long staticFieldOffset(Field field) {
		return (long) ldc(() -> bind("staticFieldOffset", long.class, Field.class)).invokeExact(field);
	}

	public static Object staticFieldBase(Field field) {
		return (Object) ldc(() -> bind("staticFieldBase", Object.class, Field.class)).invokeExact(field);
	}

	public static boolean shouldBeInitialized(Class<?> klass) {
		return (boolean) ldc(() -> bind("shouldBeInitialized", boolean.class, Class.class)).invokeExact(klass);
	}

	public static void ensureClassInitialized(Class<?> c) {
		ldc(() -> bind("ensureClassInitialized", void.class, Class.class)).invokeExact(c);
	}

	public static int arrayBaseOffset(Class<?> arrayClass) {
		return (int) ldc(() -> bind("arrayBaseOffset", int.class, Class.class)).invokeExact(arrayClass);
	}

	public static <T> int arrayIndexScale(Class<T> arrayClass) {
		return (int) ldc(() -> bind("arrayIndexScale", int.class, Class.class)).invokeExact(arrayClass);
	}

	public static int addressSize() {
		return (int) ldc(() -> bind("addressSize", int.class)).invokeExact();
	}

	public static int pageSize() {
		return (int) ldc(() -> bind("pageSize", int.class)).invokeExact();
	}

	public static <T> Class<T> defineClass(String name, byte[] bytecode, int offset, int length, ClassLoader classLoader, ProtectionDomain protectionDomain) {
		return (Class<T>) ldc(() -> bind("defineClass", Class.class, String.class, byte[].class, int.class, int.class, ClassLoader.class, ProtectionDomain.class)).invokeExact(name, bytecode, offset, length, classLoader, protectionDomain);
	}

	public static <T> T allocateInstance(Class<T> cls) {
		return (T) ldc(() -> bind("allocateInstance", Object.class, Class.class)).invokeExact(cls);
	}

	public static RuntimeException throwException(Throwable throwable) {
		throw throwable;
	}

	public static boolean compareAndSwapObject(Object o, long offset, Object expected, Object x) {
		return (boolean) ldc(() -> bind("compareAndSetReference", boolean.class, Object.class, long.class, Object.class, Object.class)).invokeExact(o, offset, expected, x);
	}

	public static boolean compareAndSwapInt(Object o, long offset, int expected, int x) {
		return (boolean) ldc(() -> bind("compareAndSetInt", boolean.class, Object.class, long.class, int.class, int.class)).invokeExact(o, offset, expected, x);
	}

	public static boolean compareAndSwapLong(Object object, long offset, long expected, long x) {
		return (boolean) ldc(() -> bind("compareAndSetLong", boolean.class, Object.class, long.class, long.class, long.class)).invokeExact(object, offset, expected, x);
	}

	public static <T> T getReferenceVolatile(Object object, long offset) {
		return (T) ldc(() -> bind("getReferenceVolatile", Object.class, Object.class, long.class)).invokeExact(object, offset);
	}

	public static void putReferenceVolatile(Object o, long offset, Object x) {
		ldc(() -> bind("putReferenceVolatile", void.class, Object.class, long.class, Object.class)).invokeExact(o, offset, x);
	}

	public static int getIntVolatile(Object o, long offset) {
		return (int) ldc(() -> bind("getIntVolatile", int.class, Object.class, long.class)).invokeExact(o, offset);
	}

	public static void putIntVolatile(Object o, long offset, int x) {
		ldc(() -> bind("putIntVolatile", void.class, Object.class, long.class, int.class)).invokeExact(o, offset, x);
	}

	public static boolean getBooleanVolatile(Object o, long offset) {
		return (boolean) ldc(() -> bind("getBooleanVolatile", boolean.class, Object.class, long.class)).invokeExact(o, offset);
	}

	public static void putBooleanVolatile(Object o, long offset, boolean x) {
		ldc(() -> bind("putBooleanVolatile", void.class, Object.class, long.class, boolean.class)).invokeExact(o, offset, x);
	}

	public static byte getByteVolatile(Object o, long offset) {
		return (byte) ldc(() -> bind("getByteVolatile", byte.class, Object.class, long.class)).invokeExact(o, offset);
	}

	public static void putByteVolatile(Object o, long offset, byte x) {
		ldc(() -> bind("putByteVolatile", void.class, Object.class, long.class, byte.class)).invokeExact(o, offset, x);
	}

	public static short getShortVolatile(Object o, long offset) {
		return (short) ldc(() -> bind("getShortVolatile", short.class, Object.class, long.class)).invokeExact(o, offset);
	}

	public static void putShortVolatile(Object o, long offset, short x) {
		ldc(() -> bind("putShortVolatile", void.class, Object.class, long.class, short.class)).invokeExact(o, offset, x);
	}

	public static char getCharVolatile(Object o, long offset) {
		return (char) ldc(() -> bind("getCharVolatile", char.class, Object.class, long.class)).invokeExact(o, offset);
	}

	public static void putCharVolatile(Object o, long offset, char x) {
		ldc(() -> bind("putCharVolatile", void.class, Object.class, long.class, char.class)).invokeExact(o, offset, x);
	}

	public static long getLongVolatile(Object o, long offset) {
		return (long) ldc(() -> bind("getLongVolatile", long.class, Object.class, long.class)).invokeExact(o, offset);
	}

	public static void putLongVolatile(Object o, long offset, long x) {
		ldc(() -> bind("putLongVolatile", void.class, Object.class, long.class, long.class)).invokeExact(o, offset, x);
	}

	public static float getFloatVolatile(Object o, long offset) {
		return (float) ldc(() -> bind("getFloatVolatile", float.class, Object.class, long.class)).invokeExact(o, offset);
	}

	public static void putFloatVolatile(Object o, long offset, float x) {
		ldc(() -> bind("putFloatVolatile", void.class, Object.class, long.class, float.class)).invokeExact(o, offset, x);
	}

	public static double getDoubleVolatile(Object o, long offset) {
		return (double) ldc(() -> bind("getDoubleVolatile", double.class, Object.class, long.class)).invokeExact(o, offset);
	}

	public static void putDoubleVolatile(Object o, long offset, double x) {
		ldc(() -> bind("putDoubleVolatile", void.class, Object.class, long.class, double.class)).invokeExact(o, offset, x);
	}

	public static void putOrderedReference(Object o, long offset, Object x) {
		ldc(() -> bind("putReferenceRelease", void.class, Object.class, long.class, Object.class)).invokeExact(o, offset, x);
	}

	public static void putOrderedInt(Object o, long offset, int x) {
		ldc(() -> bind("putIntRelease", void.class, Object.class, long.class, int.class)).invokeExact(o, offset, x);
	}

	public static void putOrderedLong(Object o, long offset, long x) {
		ldc(() -> bind("putLongRelease", void.class, Object.class, long.class, long.class)).invokeExact(o, offset, x);
	}

	public static int getLoadAverage(double[] loadavg, int nelems) {
		return (int) ldc(() -> bind("getLoadAverage", int.class, double[].class, int.class)).invokeExact(loadavg, nelems);
	}

	public static int getAndAddInt(Object o, long offset, int delta) {
		return (int) ldc(() -> bind("getAndAddInt", int.class, Object.class, long.class, int.class)).invokeExact(o, offset, delta);
	}

	public static long getAndAddLong(Object o, long offset, long delta) {
		return (long) ldc(() -> bind("getAndAddLong", long.class, Object.class, long.class, long.class)).invokeExact(o, offset, delta);
	}

	public static int getAndSetInt(Object o, long offset, int newValue) {
		return (int) ldc(() -> bind("getAndSetInt", int.class, Object.class, long.class, int.class)).invokeExact(o, offset, newValue);
	}

	public static long getAndSetLong(Object o, long offset, long newValue) {
		return (long) ldc(() -> bind("getAndSetLong", long.class, Object.class, long.class, long.class)).invokeExact(o, offset, newValue);
	}

	public static <T> T getAndSetReference(Object o, long offset, T newValue) {
		return (T) ldc(() -> bind("getAndSetReference", Object.class, Object.class, long.class, Object.class)).invokeExact(o, offset, (Object) newValue);
	}

	public static void loadFence() {
		ldc(() -> bind("loadFence", void.class)).invokeExact();
	}

	public static void storeFence() {
		ldc(() -> bind("storeFence", void.class)).invokeExact();
	}

	public static void fullFence() {
		ldc(() -> bind("fullFence", void.class)).invokeExact();
	}

	public static void invokeCleaner(ByteBuffer directBuffer) {
		ldc(() -> bind("invokeCleaner", void.class, ByteBuffer.class)).invokeExact(directBuffer);
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
				throw new NoSuchMethodError("Unsafe::%s%s".formatted(method, MethodType.methodType(returnType, parameterTypes))).initCause(throwable);
			}

			return bind(method, null, returnType, parameterTypes);
		}
	}

	private static MethodHandle bind(String method, Class<?> returnType, Class<?>... parameterTypes) {
		return bind(method, null, returnType, parameterTypes);
	}
}
