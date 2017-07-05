package reflectionTools;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * This program uses reflection to print all features of a class.
 * 
 * @author SkyFervor
 *
 */
public class ClassAnalyzer {

	public static String analyze(String name) throws ClassNotFoundException {
		Class<?> cl = Class.forName(name);

		return analyze(cl);
	}

	public static String analyze(Class<?> cl) {
		StringBuilder r = new StringBuilder();

		// Modifiers
		String modifiers = Modifier.toString(cl.getModifiers());
		if (modifiers.length() > 0)
			r.append(modifiers + " ");

		// Class
		r.append("class " + cl.getSimpleName());

		// Super class
		Class<?> superCl = cl.getSuperclass();
		if (superCl != null && superCl != Object.class)
			r.append(" extends " + superCl.getSimpleName() + "\n");

		r.append("{");

		// Fields
		analyzeFields(cl, r);

		// Constructors
		analyzeConstructors(cl, r);

		// Methods
		analyzeMethods(cl, r);

		r.append("}");
		return r.toString();
	}

	/**
	 * Analyzes all fields of a class
	 * 
	 * @param cl
	 *        a class
	 * @param r
	 *        analysis result
	 */
	private static void analyzeFields(Class<?> cl, StringBuilder r) {
		Field[] fields = cl.getDeclaredFields();

		if (fields.length > 0)
			r.append("\n");

		for (Field f : fields) {
			r.append("\t");

			// Modifier
			String modifiers = Modifier.toString(f.getModifiers());
			if (modifiers.length() > 0)
				r.append(modifiers + " ");

			// Type
			Class<?> type = f.getType();
			r.append(type.getSimpleName());

			// Name
			String name = f.getName();
			r.append(" " + name + ";\n");
		}
	}

	/**
	 * Analyzes all constructors of a class
	 * 
	 * @param cl
	 *        a class
	 * @param r
	 *        analysis result
	 */
	private static void analyzeConstructors(Class<?> cl, StringBuilder r) {
		Constructor<?>[] constructors = cl.getDeclaredConstructors();

		if (constructors.length > 0)
			r.append("\n");

		for (Constructor<?> c : constructors) {
			r.append("\t");

			// Modifier
			String modifiers = Modifier.toString(c.getModifiers());
			if (modifiers.length() > 0)
				r.append(modifiers + " ");

			// Name
			String name = cl.getSimpleName();
			r.append(name + "(");

			// Parameter types
			Class<?>[] paramTypes = c.getParameterTypes();
			for (int i = 0; i < paramTypes.length; i++) {
				if (i > 0)
					r.append(", ");
				r.append(paramTypes[i].getSimpleName());
			}
			r.append(");\n");
		}
	}

	/**
	 * Analyzes all methods of a class
	 * 
	 * @param cl
	 *        a class
	 * @param r
	 *        analysis result
	 */
	private static void analyzeMethods(Class<?> cl, StringBuilder r) {
		Method[] methods = cl.getDeclaredMethods();

		if (methods.length > 0)
			r.append("\n");

		for (Method m : methods) {
			r.append("\t");

			// Modifier
			String modifiers = Modifier.toString(m.getModifiers());
			if (modifiers.length() > 0)
				r.append(modifiers + " ");

			// Return type
			Class<?> retType = m.getReturnType();
			r.append(retType.getSimpleName());

			// Name
			String name = m.getName();
			r.append(" " + name + "(");

			// Parameter types
			Class<?>[] paramTypes = m.getParameterTypes();
			for (int i = 0; i < paramTypes.length; i++) {
				if (i > 0)
					r.append(", ");
				r.append(paramTypes[i].getSimpleName());
			}
			r.append(");\n");
		}
	}

	public static void main(String[] args) {
		System.out.println(analyze(ClassAnalyzer.class));
	}

}
