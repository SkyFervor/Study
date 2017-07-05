package reflectionTools;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * This program uses reflection to spy on objects.
 * 
 * @author SkyFervor
 *
 */
public class ObjectAnalyzer {

	public static String analyze(Object obj) {
		if (obj == null)
			return "null";

		// Get class
		Class<?> cl = obj.getClass();

		// String
		if (cl == String.class)
			return (String) obj;

		// Array
		if (cl.isArray()) {
			// Element type
			String r = cl.getComponentType().getSimpleName() + "[]{";

			int i;
			for (i = 0; i < Array.getLength(obj); i++) {
				if (i == 0)
					r += "\n\t";
				else
					r += ",\n\t";

				// Element
				Object val = Array.get(obj, i);
				if (cl.getComponentType().isPrimitive())
					r += val;
				else
					r += analyze(val);
			}
			if (r.endsWith("{"))
				return r + "}";
			return r + "\n}";
		}

		// Object
		String r = "";
		do {
			// Type
			if (r.endsWith("}"))
				r += " --";
			r += cl.getSimpleName() + "{";

			Field[] fields = cl.getDeclaredFields();
			AccessibleObject.setAccessible(fields, true);
			for (Field f : fields) {
				/*
				// 跳过静态域
				if (Modifier.isStatic(f.getModifiers()))
					continue;
				*/

				if (r.endsWith("}"))
					r += ",\n";
				else if (!r.endsWith("{"))
					r += ", ";
				// Field name
				r += f.getName() + "=";
				try {
					// Field type
					Class<?> t = f.getType();

					// Field value
					Object val = f.get(obj);

					if (t.isPrimitive())
						r += val;
					else
						r += analyze(val);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			r += "}";

			// Super class
			cl = cl.getSuperclass();
		} while (cl != null);

		return r;
	}

}
