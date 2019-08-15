package kustomize;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

public class JUnit5ExampleTest {

	private String BASEPATH = "/Users/jorge/Documents/analisis/kustomize/examples/";
	
	@Test
	void helloWorldExample() {
		HashSet<String> set = new HashSet<String>();
		String basePath = BASEPATH+ "helloWorld";
		String file = BASEPATH + "helloWorld/kustomization.yaml";
		String file2 = BASEPATH + "helloWorld/deployment.yaml";
		String file3 = BASEPATH + "helloWorld/service.yaml";
		String file4 = BASEPATH + "helloWorld/configMap.yaml";
		set.add(file);
		set.add(file2);
		set.add(file3);
		set.add(file4);
		KustomizeFileReader k = new KustomizeFileReader();
		HashSet<String> result = k.getFilesToDownload(basePath);
		assertEquals(set, result);
	}
	
	@Test
	void ldapExample() {
		HashSet<String> set = new HashSet<String>();
		String basePath = BASEPATH+ "ldap/overlays/production";
		String file = BASEPATH + "ldap/base/service.yaml";
		String file2 = BASEPATH + "ldap/base/env.startup.txt";
		String file3 = BASEPATH + "ldap/base/kustomization.yaml";
		String file4 = BASEPATH + "ldap/base/deployment.yaml";
		String file5 = BASEPATH + "ldap/overlays/production/deployment.yaml";
		String file6 = BASEPATH + "ldap/overlays/production/kustomization.yaml";
		set.add(file);
		set.add(file2);
		set.add(file3);
		set.add(file4);
		set.add(file5);
		set.add(file6);
		KustomizeFileReader k = new KustomizeFileReader();
		HashSet<String> result = k.getFilesToDownload(basePath);
		assertEquals(set, result);
	}
	
	@Test
	void multibasesExample() {
		HashSet<String> set = new HashSet<String>();
		String basePath = BASEPATH+ "multibases/production";
		String file = BASEPATH + "multibases/base/kustomization.yaml";
		String file2 = BASEPATH + "multibases/production/kustomization.yaml";
		String file3 = BASEPATH + "multibases/base/pod.yaml";
		set.add(file);
		set.add(file2);
		set.add(file3);
		KustomizeFileReader k = new KustomizeFileReader();
		HashSet<String> result = k.getFilesToDownload(basePath);
		assertEquals(set, result);
	}
	

	@Test
	void wordpressExample() {
		HashSet<String> set = new HashSet<String>();
		String basePath = BASEPATH+ "wordpress";
		String file = BASEPATH + "wordpress/wordpress/deployment.yaml";
		String file2 = BASEPATH + "wordpress/mysql/secret.yaml";
		String file3 = BASEPATH + "wordpress/wordpress/kustomization.yaml";
		String file4 = BASEPATH + "wordpress/wordpress/service.yaml";
		String file5 = BASEPATH + "wordpress/mysql/deployment.yaml";
		String file6 = BASEPATH + "wordpress/kustomization.yaml";
		String file7 = BASEPATH + "wordpress/patch.yaml";
		String file8 = BASEPATH + "wordpress/mysql/kustomization.yaml";
		String file9 = BASEPATH + "wordpress/mysql/service.yaml";
		set.add(file);
		set.add(file2);
		set.add(file3);
		set.add(file4);
		set.add(file5);
		set.add(file6);
		set.add(file7);
		set.add(file8);
		set.add(file9);
		KustomizeFileReader k = new KustomizeFileReader();
		HashSet<String> result = k.getFilesToDownload(basePath);
		assertEquals(set, result);
	}
	
}
