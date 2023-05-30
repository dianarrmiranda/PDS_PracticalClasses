package lab12.ex1.reflection;

abstract class PluginManager {
	public static IPlugin load(String name) throws Exception {
		Class<?> c = Class.forName(name);
		return (IPlugin) c.getDeclaredConstructor().newInstance();
	}
}