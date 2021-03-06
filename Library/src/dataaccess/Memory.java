package dataaccess;

import java.util.ArrayList;
import java.util.List;

public class Memory {
	
    private static List<Object> tempCollection = new ArrayList<>();
    private static Role currentRole;
    private static LibraryMember member;
    
    public static void addObjectToMem(Object o) {
    	tempCollection.add(o);
    }
    
    public static List<Object> getListFromMem() {
    	return tempCollection;
    }
    
    public static void clearMemory() {
    	//tempBookCollection = new ArrayList<>();
    	//tempAuthorCollection = new ArrayList<>();
    	tempCollection = new ArrayList<>();
    }
    
    public static void setRole(Role r) {
    	currentRole = r;
    }
    
    public static Role getRole() {
    	return currentRole;
    }

	public static LibraryMember getMember() {
		return member;
	}

	public static void setMember(LibraryMember mem) {
		member = mem;
	}
}
