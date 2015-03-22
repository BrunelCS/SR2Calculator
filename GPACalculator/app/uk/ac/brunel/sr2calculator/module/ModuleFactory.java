package uk.ac.brunel.sr2calculator.module;

import java.util.HashMap;
import java.util.Map;


public class ModuleFactory {
	private static ModuleFactory instance;
	
	private Map<String, Module>modules;
	
	private ModuleFactory() {
		 modules = new HashMap<String, Module>();
	}
	
	public static ModuleFactory getInstance() {
		if (instance==null) {
			instance=new ModuleFactory();
			
			// Static declaration of module data
			// TODO provide file upload for this.
			{
				instance.addModule("CS2001_CB", 40, 2);
				instance.addModule("CS2002_CN", 20, 2);
				instance.addModule("CS2003_CN", 20, 2);
				instance.addModule("CS2004_CN", 20, 2);
				instance.addModule("CS2005_CN", 20, 2);
				instance.addModule("CS2006_CN", 20, 2);
				instance.addModule("CS2007_C1", 20, 2);
				instance.addModule("CS2007_CN", 20, 2);
				instance.addModule("CS2555", 40, 2);
				instance.addModule("CS2555_CB", 40, 2);
				instance.addModule("CS3001_CE", 20, 3);
				instance.addModule("CS3002_CE", 20, 3);
				instance.addModule("CS3002_CB", 20, 3);
				instance.addModule("CS3002_CN", 20, 3);
				instance.addModule("CS3003_CN", 20, 3);
				instance.addModule("CS3003_CB", 20, 3);
				instance.addModule("CS3004_CB", 20, 3);
				instance.addModule("CS3004_CN", 20, 3);
				instance.addModule("CS3005_CB", 20, 3);
				instance.addModule("CS3005_CN", 20, 3);
				instance.addModule("CS3006_CE", 20, 3);
				instance.addModule("CS3007_CN", 20, 3);
				instance.addModule("CS3007_CB", 20, 3);
				instance.addModule("CS3008_CB", 20, 3);
				instance.addModule("CS3008_CN", 20, 3);
				instance.addModule("CS3009_CN", 20, 3);
				instance.addModule("CS3605_CB", 40, 3);
				instance.addModule("CS3606_CE", 40, 3);
				instance.addModule("CS3607_CN", 40, 3);
				instance.addModule("CS3608_CN", 20, 3);
				instance.addModule("CS3072_CB", 40, 3);
				instance.addModule("CS3074_CB", 40, 3);
				instance.addModule("CS3100_CN", 20, 3);
			}
		}
		return instance;
	}
	
	public  Module getModule(String moduleCode) {
		if (modules.containsKey(moduleCode)) {
			return modules.get(moduleCode);
		}
		throw new IllegalArgumentException("Module " + moduleCode + " not found");
	}
	
	/* package */ void addModule(String moduleCode, int credits, int level) {
		Module module = new Module(moduleCode, level, credits);
		modules.put(moduleCode, module);
	}
	
}
