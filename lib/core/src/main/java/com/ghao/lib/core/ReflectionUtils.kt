@file:JvmName("ReflectionUtils")

package com.ghao.lib.core

import java.lang.reflect.Method

/**
 * Creates a new instance of this class using its default constructor.
 *
 * @throws IllegalArgumentException if the class can't be instantiated.
 */
fun <T> Class<T>.createInstance(): T =
    try {
        getDeclaredConstructor().newInstance()
    } catch (e: Exception) {
        throw IllegalArgumentException(e)
    }

/**
 * Creates a new instance of [T] using its default constructor.
 *
 * @throws IllegalArgumentException if the class can't be instantiated.
 */
inline fun <reified T> createInstance(): T = T::class.java.createInstance()

/**
 * Checks whether a class with name [className] can be loaded.
 */
fun classExists(className: String): Boolean = loadClassSafely<Any>(className) != null

/**
 * Tries to load a class by the name [className], and returns null if it fails.
 */
fun <T> loadClassSafely(className: String): Class<T>? =
    try {
        Class.forName(className).cast()
    } catch (e: ClassNotFoundException) {
        null
    }

/**
 * A shorthand to obtain an annotation of type [T] applied to the declaration of this class.
 */
inline fun <reified T : Annotation> Class<*>.getAnnotation(): T? = getAnnotation(T::class.java)

/**
 * Checks whether the declaration of this class has an annotation of type [T] applied to it.
 */
fun <T : Annotation> Class<*>.hasAnnotation(annotationClass: Class<T>): Boolean = isAnnotationPresent(annotationClass)

/**
 * Checks whether the declaration of this class has an annotation of type [T] applied to it.
 */
inline fun <reified T : Annotation> Class<*>.hasAnnotation(): Boolean = hasAnnotation(T::class.java)

/**
 * Checks whether this class has a method, given its [name] and [parameterTypes].
 */
fun Class<*>.hasMethod(name: String, vararg parameterTypes: Class<*>): Boolean =
    try {
        getDeclaredMethod(name, *parameterTypes)
        true
    } catch (e: NoSuchMethodException) {
        false
    }

/**
 * Returns the value of a field, static or not, and null in case of error.
 */
fun <T> Class<*>.getFieldValueSafely(instance: Any?, name: String): T? =
    try {
        getDeclaredField(name)
            .apply { isAccessible = true }
            .get(instance).cast()
    } catch (ignore: Exception) {
        // Intentionally ignored.
        null
    }

/**
 * Updates the value of a field.
 */
fun Class<*>.setFieldValueSafely(instance: Any?, name: String, value: Any?) =
    try {
        getDeclaredField(name)
            .apply { isAccessible = true }
            .set(instance, value)
    } catch (e: Exception) {
        // Intentionally ignored.
    }

/**
 * Gets a method, static or not, and returns null in case of error.
 */
fun Class<*>.getMethodSafely(name: String, vararg parameterTypes: Class<*>): Method? =
    try {
        getDeclaredMethod(name, *parameterTypes).apply { isAccessible = true }
    } catch (ignore: Exception) {
        // Intentionally ignored.
        null
    }

/**
 * Invokes a method, static or not, and returns the result, and null in case of error.
 */
fun <T> Method?.invokeMethodSafely(instance: Any?, vararg parameters: Any): T? =
    this?.let {
        try {
            invoke(instance, *parameters).cast<T>()
        } catch (ignore: Exception) {
            // Intentionally ignored.
            null
        }
    }

/**
 * Returns all superclasses and superinterfaces of this class, with the class itself and all superclasses in recursive
 * order and, after each class, all its interfaces and superinterfaces.
 */
fun Class<*>.traverseHierarchy(): Sequence<Class<*>> {
    fun superinterfaces(anInterface: Class<*>): Sequence<Class<*>> =
        sequenceOf(anInterface) + anInterface.interfaces.asSequence().flatMap { superinterfaces(it) }

    val superclasses = generateSequence(this) { it.superclass }
    return superclasses.flatMap { sequenceOf(it) + it.interfaces.asSequence().flatMap { superinterfaces(it) } }
        .distinct()
}

/**
 * A traversal of the hierarchy that's restricted to classes and interfaces that are assignable to [baseType].
 */
fun <T> Class<out T>.traverseTypedHierarchy(baseType: Class<out T>): Sequence<Class<out T>> =
    traverseHierarchy().filter { baseType.isAssignableFrom(it) }.filterIsInstance<Class<T>>()

/**
 * A traversal of the hierarchy that's restricted to classes and interfaces that are assignable to [T].
 */
inline fun <reified T> Class<out T>.traverseTypedHierarchy(): Sequence<Class<out T>> =
    traverseTypedHierarchy(T::class.java)

@Suppress("UNCHECKED_CAST")
fun <T> Any?.cast() = this as T
